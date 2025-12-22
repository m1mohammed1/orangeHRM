package project_orangehrm.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project_orangehrm.Base.BaseTest;
import project_orangehrm.Pages.DashboardPage;
import project_orangehrm.Pages.LoginPage;
import project_orangehrm.Pages.RecruitmentPage;

public class Recruitment_Actions_Test extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private RecruitmentPage recruitmentPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        recruitmentPage = new RecruitmentPage(driver);

        loginPage
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin();
        dashboardPage
                .navigateToModule("Recruitment");
    }

    @Test(priority = 1, description = "TC01 - Verify Reject Candidate Workflow")
    public void verifyCandidate_Reject_Success() {
        String firstName = "Reject";
        String lastName = "User";
        String email = "reject@test.com";

        recruitmentPage
                .clickToAdd()
                .typeInDynamicNameFiled("Full Name", "FirstName", firstName)
                .typeInDynamicNameFiled("Full Name", "Last Name", lastName)
                .typeInDynamicField("Email", email)
                .clickSave()
                .verifySuccessMessage();
        recruitmentPage
                .clickEyeStatus("Reject User")
                .clickEditSwitch()
                .typeInDynamicTextArea("Notes", "Skills do not match")
                .clickSave()
                .verifySuccessMessage();
        recruitmentPage
                .navigateToSection("Candidates")
                .verifyStatusContains("Status: Rejected")
                .typeInDynamicField("Candidate Name", "Reject User")
                .selectFromList()
                .searchUser()
                .verifyStatusContains("Status: Rejected")
                .deleteSpecificValue("Reject User")
                .verifySuccessMessage();
    }

    @Test(priority = 3, description = "TC03 - Verify Add Candidate Validation")
    public void verifyCandidate_EmptyFields_Error() {
        recruitmentPage
                .clickToAdd()
                .clickSave()
                .verifyFieldErrorMessage("First Name", "Required")
                .verifyFieldErrorMessage("Email", "Required");
    }
}

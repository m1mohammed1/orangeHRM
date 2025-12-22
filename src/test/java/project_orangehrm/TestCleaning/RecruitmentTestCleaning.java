package project_orangehrm.TestCleaning;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project_orangehrm.Base.BaseTest;
import project_orangehrm.Pages.DashboardPage;
import project_orangehrm.Pages.LoginPage;
import project_orangehrm.Pages.RecruitmentPage;

public class RecruitmentTestCleaning extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private RecruitmentPage recruitmentPage;

    @BeforeMethod
    public void setUP() {
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


    @Test(priority = 1, description = "test1")
    public void test1() {
        recruitmentPage
                .navigateToSection("Candidates")
                .typeInDynamicField("Candidate Name","E2E")
                .selectFromList()
                .searchUser()
                .deleteSpecificValue("E2E Candidate")
                .verifySuccessMessage();
    }

    @Test(priority = 2, description = "test2")
    public void test2() {
        recruitmentPage
                .navigateToSection("Candidates")
                .typeInDynamicField("Candidate Name","Decline")
                .selectFromList()
                .searchUser()
                .deleteSpecificValue("Decline Candidate")
                .verifySuccessMessage();
    }

    @Test(priority = 3, description = "test3")
    public void test3() {
        recruitmentPage
                .navigateToSection("Vacancies")
                .clickAndSelectDropdown("Vacancy","Senior Java SDET")
                .searchUser()
                .deleteSpecificValue("Senior Java SDET")
                .verifySuccessMessage();
    }
}

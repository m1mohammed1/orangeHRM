package project_orangehrm.TestCleaning;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project_orangehrm.Base.BaseTest;
import project_orangehrm.Pages.ClaimPage;
import project_orangehrm.Pages.DashboardPage;
import project_orangehrm.Pages.LoginPage;

public class ClaimTestCleaning extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ClaimPage claimPage;

    @BeforeMethod
    public void setUP() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        claimPage = new ClaimPage(driver);

        loginPage
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin();
        dashboardPage
                .navigateToModule("Claim");
    }

    @Test(priority = 1,description = "test1")
    public void test1() {
        claimPage
                .navigateToSection("Configuration", "Events")
                .verifyRecordExists("Global QA Summit 2025")
                .deleteSpecificValue("Global QA Summit 2025")
                .verifySuccessMessage();
    }

    @Test(priority = 2,description = "test2")
    public void test2() {
        claimPage
                .navigateToSection("Configuration", "Expense Types")
                .verifyRecordExists("Local Transport")
                .deleteSpecificValue("Local Transport")
                .verifySuccessMessage();
    }
}

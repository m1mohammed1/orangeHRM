package project_orangehrm.TestCleaning;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project_orangehrm.Base.BaseTest;
import project_orangehrm.Pages.DashboardPage;
import project_orangehrm.Pages.LoginPage;
import project_orangehrm.Pages.PIMPage;

public class PIMTestCleaning extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PIMPage pimPage;

    @BeforeMethod
    public void setUP() {

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);

        loginPage
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin();
        dashboardPage
                .navigateToModule("PIM");
    }


    @Test(priority = 1, description = "test")
    public void test1() {
        pimPage
                .verifyPIMPage("PIM")
                .navigateToSection("Configuration", "Custom Fields")
                .verifyRecordExists("Automation Badge ID")
                .deleteSpecificValue("Automation Badge ID")
                .verifySuccessMessage();
    }


    @Test(priority = 2, description = "test2")
    public void test2() {
        pimPage
                .verifyPIMPage("PIM")
                .navigateToSection("Configuration", "Reporting Methods")
                .verifyRecordExists("Weekly Scrum Report")
                .deleteSpecificValue("Weekly Scrum Report")
                .verifySuccessMessage();
    }


    @Test(priority = 3, description = "test3")
    public void test3() {
        pimPage
                .verifyPIMPage("PIM")
                .navigateToSection("Configuration", "Termination Reasons")
                .verifyRecordExists("Better Salary Opportunity")
                .deleteSpecificValue("Better Salary Opportunity")
                .verifySuccessMessage();
    }

    @Test(priority = 4, description = "test4")
    public void test4() {
        pimPage
                .verifyPIMPage("PIM")
                .navigateToSection("Employee")
                .typeInDynamicField("Employee Id", "77777")
                .clickAndSelectDropdown("Include", "Current Employees Only")
                .searchUser()
                .verifyRecordExists("77777")
                .deleteSpecificValue("77777")
                .verifySuccessMessage();
    }

    @Test(priority = 7, description = "test4")
    public void test7() {
        pimPage
                .verifyPIMPage("PIM")
                .navigateToSection("Employee")
                .typeInDynamicField("Employee Id", "0777")
                .clickAndSelectDropdown("Include", "Current Employees Only")
                .searchUser()
                .verifyRecordExists("0777")
                .deleteSpecificValue("0777")
                .verifySuccessMessage();
    }

    @Test(priority = 4, description = "test5")
    public void test5() {
        pimPage
                .verifyPIMPage("PIM")
                .navigateToSection("Reports")
                .verifyRecordExists("QA Employee Audit Report")
                .deleteSpecificValue("QA Employee Audit Report")
                .verifySuccessMessage();
    }


}

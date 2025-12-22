package project_orangehrm.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project_orangehrm.Base.BaseTest;
import project_orangehrm.Pages.DashboardPage;
import project_orangehrm.Pages.LoginPage;
import project_orangehrm.Pages.PIMPage;

/**
 IMPORTANT TO EDIT MORE TEST CASE
 */


public class PIM_EmployeeDetails_Test extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PIMPage pimPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);

        loginPage.
                enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin();
        dashboardPage
                .verifyDashboard("Dashboard");
        dashboardPage
                .navigateToModule("PIM");

        pimPage
                .navigateToSection( "Add Employee")
                .typeInDynamicNameFiled("Employee Full Name","First Name","Automation")
                .typeInDynamicNameFiled("Employee Full Name","Last Name","Test")
                .typeInDynamicField("Employee Id","7733")
                .clickSave();
    }

    @Test(priority = 1, description = "TC01 - Verify Updating Personal Details (Gender, Nationality)")
    public void verifyPersonalDetails_Update_Success() {
        pimPage
                .typeInDynamicField("Driver's License Number", "DL-999999")
                .clickAndSelectDropdown("Nationality", "Egyptian")
                .clickAndSelectDropdown("Marital Status", "Single")
                .clickToRadioButton("Male")
                .clickSave()
                .verifySuccessMessage();
    }

    @Test(priority = 2, description = "TC02 - Verify Updating Contact Details")
    public void verifyContactDetails_Update_Success() {
        pimPage
                .clickSideTab("Contact Details")
                .typeInDynamicField("Street 1", "123 Innovation Street")
                .typeInDynamicField("City", "Cairo")
                .typeInDynamicField("Home", "0223456789")
                .typeInDynamicField("Mobile", "01000000000")
                .typeInDynamicField("Work Email", "test@company.com")
                .clickSave()
                .verifySuccessMessage();
    }

    @Test(priority = 3, description = "TC03 - Verify Updating Job Details (Title, Category)")
    public void verifyJobDetails_Update_Success() {
        pimPage
                .clickSideTab("Job")
                .typeInDynamicField("Joined Date", "2023-01-01")
                .clickAndSelectDropdown("Job Title", "QA Engineer") // Must exist in Admin > Job
                .clickAndSelectDropdown("Job Category", "Professionals")
                .clickAndSelectDropdown("Sub Unit", "Engineering")
                .clickSave()
                .verifySuccessMessage();
    }

    @Test(priority = 4, description = "TC04 - Verify Adding Salary Component")
    public void verifySalary_Add_Success() {
        pimPage
                .clickSideTab("Salary")
                .clickToAdd() // Clicking Add in Salary Section
                .typeInDynamicField("Salary Component", "Basic Salary")
                .clickAndSelectDropdown("Pay Grade", "Grade 1") // Must exist in Admin
                .typeInDynamicField("Amount", "5000")
                .clickAndSelectDropdown("Currency", "USD - United States Dollar")
                .clickSave()
                .verifySuccessMessage();
    }

    @Test(priority = 5, description = "TC05 - Cleanup: Delete Employee")
    public void cleanup_DeleteEmployee() {
        pimPage
                .navigateToSection("PIM", "Employee List")
                .typeInDynamicField("Employee Id", "7733")
                .searchUser()
                .deleteSpecificValue("7733")
                .verifySuccessMessage();
    }
}
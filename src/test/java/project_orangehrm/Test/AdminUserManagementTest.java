package project_orangehrm.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project_orangehrm.Base.BaseTest;
import project_orangehrm.Pages.AdminPage;
import project_orangehrm.Pages.DashboardPage;
import project_orangehrm.Pages.LoginPage;

public class AdminUserManagementTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AdminPage adminPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        adminPage = new AdminPage(driver);
        loginPage
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin();

        dashboardPage
                .verifyDashboard("Dashboard");
        dashboardPage
                .navigateToModule("Admin");
    }

    @Test(priority = 1, description = "TC01 - Positive: Verify Admin User Lifecycle: Create, Search, and Delete")
    public void verifyUserManagement_Lifecycle_Success() {
        adminPage
                .verifyAdminPage("Admin")
                .clickToAdd()
                .clickAndSelectDropdown("User Role", "Admin")
                .typeInDynamicField("Employee Name", "Script Automation Test")
                .selectFromList()
                .clickAndSelectDropdown("Status", "Enabled")
                .typeInDynamicField("Username", "TestAdmin_QA")
                .typeInDynamicField("Password", "Password123!")
                .typeInDynamicField("Confirm Password", "Password123!")
                .clickToSave()
                .verifySuccessMessage();
        adminPage
                .typeInDynamicField("Username", "TestAdmin_QA")
                .searchUser()
                .verifyRecordExists("TestAdmin_QA");
    }

    @Test(priority = 2, description = "TC02 - Negative: Verify validation errors for all required fields in User Form")
    public void verifyUserManagement_EmptyFields_ShowError() {
        adminPage
                .clickToAdd()
                .clickToSave()
                .verifyFieldErrorMessage("User Role", "Required")
                .verifyFieldErrorMessage("Employee Name", "Required")
                .verifyFieldErrorMessage("Status", "Required")
                .verifyFieldErrorMessage("Username", "Required")
                .verifyFieldErrorMessage("Password", "Required")
                .verifyFieldErrorMessage("Confirm Password", "Required");
    }

    @Test(priority = 3, description = "TC03 - Negative: Verify search with non-existing username")
    public void verifyUserManagement_SearchNotFound_NoRecords() {
        adminPage
                .typeInDynamicField("Username", "InvalidUser_XYZ")
                .searchUser()
                .verifyRecordDeleted("InvalidUser_XYZ");
    }

    @Test(priority = 4, description = "TC04 - Negative: Verify error message when Password and Confirm Password do not match")
    public void verifyUserManagement_PasswordMismatch_ShowError() {
        adminPage
                .clickToAdd()
                .clickAndSelectDropdown("User Role", "Admin")
                .typeInDynamicField("Employee Name", "Script Automation Test")
                .selectFromList()
                .clickAndSelectDropdown("Status", "Enabled")
                .typeInDynamicField("Username", "TestMismatch_QA")
                .typeInDynamicField("Password", "Pass1234!")
                .typeInDynamicField("Confirm Password", "WrongPass123!")
                .verifyFieldErrorMessage("Confirm Password", "Required");

    }

    @Test(priority = 5, description = "TC05 - Negative: Verify error message when Password and Confirm Password do not match")
    public void verifyUserManagement_PasswordContainMinimumNumber_ShowError() {
        adminPage
                .clickToAdd()
                .clickAndSelectDropdown("User Role", "Admin")
                .typeInDynamicField("Employee Name", "Script Automation Test")
                .selectFromList()
                .clickAndSelectDropdown("Status", "Enabled")
                .typeInDynamicField("Username", "Test_QA")
                .typeInDynamicField("Password", "PasswordQA!")
                .typeInDynamicField("Confirm Password", "PasswordQA!")
                .verifyFieldErrorMessage("Password", "Required");
    }

}
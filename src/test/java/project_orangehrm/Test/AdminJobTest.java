package project_orangehrm.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project_orangehrm.Base.BaseTest;
import project_orangehrm.Pages.AdminPage;
import project_orangehrm.Pages.DashboardPage;
import project_orangehrm.Pages.LoginPage;

public class AdminJobTest extends BaseTest {

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
                .enterPassword("admin123").clickLogin();
        dashboardPage
                .verifyDashboard("Dashboard");
        dashboardPage
                .navigateToModule("Admin");
    }

    @Test(priority = 1, description = "TC01 - Verify Job Title Lifecycle: Create, Verify, and Delete")
    public void verifyJobTitle_Lifecycle_Success() {
        adminPage
                .navigateToSection("Job", "Job Titles")
                .clickToAdd()
                .typeInDynamicField("Job Title", "Principal SDET Engineer")
                .typeInDynamicTextArea("Job Description", "Responsible for Test Architecture")
                .typeInDynamicTextArea("Note", "Created by Auto-Test")
                .clickSave()
                .verifySuccessMessage()
                .verifyRecordExists("Principal SDET Engineer")
                .deleteSpecificValue("Principal SDET Engineer")
                .verifySuccessMessage();
    }

    @Test(priority = 2, description = "TC02 - Verify validation error for empty Job Title")
    public void verifyJobTitle_EmptyFields_ShowError() {
        adminPage
                .navigateToSection("Job", "Job Titles")
                .clickToAdd()
                .clickSave()
                .verifyFieldErrorMessage("Job Title", "Required");
    }

    @Test(priority = 3, description = "TC03 - Verify error when creating a duplicate Job Title")
    public void verifyJobTitle_DuplicateEntry_ShowError() {
        adminPage
                .navigateToSection("Job", "Job Titles")
                .clickToAdd()
                .typeInDynamicField("Job Title", "Duplicate Job Title")
                .clickSave()
                .verifySuccessMessage();
        adminPage
                .clickToAdd()
                .typeInDynamicField("Job Title", "Duplicate Job Title")
                .clickSave()
                .verifyFieldErrorMessage("Job Title", "Required");
        adminPage
                .navigateToSection("Job", "Job Titles")
                .deleteSpecificValue("Duplicate Job Title");
    }

    @Test(priority = 4, description = "TC04 - Verify Pay Grade Lifecycle with Currency: Create, Add Currency, Delete")
    public void verifyPayGrade_WithCurrency_Success() {
        adminPage
                .navigateToSection("Job", "Pay Grades")
                .clickToAdd()
                .typeInDynamicField("Name", "Grade 5 - Executive")
                .clickSave()
                .verifyInfoMessage()
                .clickToAdd()
                .clickAndSelectDropdown("Currency", "EUR - Euro")
                .typeInDynamicField("Minimum Salary", "4000")
                .typeInDynamicField("Maximum Salary", "8000")
                .clickSave()
                .verifySuccessMessage();
    }

    @Test(priority = 5, description = "TC05 - Verify validation error for empty Pay Grade Name")
    public void verifyPayGrade_EmptyFields_ShowError() {
        adminPage
                .navigateToSection("Job", "Pay Grades")
                .clickToAdd()
                .clickSave()
                .verifyFieldErrorMessage("Name", "Required");
    }

    @Test(priority = 6, description = "TC06 - Verify error when creating a duplicate Pay Grade")
    public void verifyPayGrade_DuplicateEntry_ShowError() {
        adminPage
                .navigateToSection("Job", "Pay Grades")
                .clickToAdd()
                .typeInDynamicField("Name", "Duplicate Grade")
                .clickSave()
                .verifyInfoMessage();

        adminPage
                .navigateToSection("Job", "Pay Grades")
                .clickToAdd()
                .typeInDynamicField("Name", "Duplicate Grade")
                .clickSave()
                .verifyFieldErrorMessage("Name", "Required");

        adminPage
                .navigateToSection("Job", "Pay Grades")
                .deleteSpecificValue("Duplicate Grade");
    }

    @Test(priority = 7, description = "TC07 - Verify Employment Status Lifecycle: Create and Delete")
    public void verifyEmploymentStatus_Lifecycle_Success() {
        adminPage
                .navigateToSection("Job", "Employment Status")
                .clickToAdd()
                .typeInDynamicField("Name", "Freelance - Project Based")
                .clickSave()
                .verifySuccessMessage()
                .verifyRecordExists("Freelance - Project Based");
    }

    @Test(priority = 8, description = "TC08 - Verify validation error for empty Employment Status Name")
    public void verifyEmploymentStatus_EmptyFields_ShowError() {
        adminPage
                .navigateToSection("Job", "Employment Status")
                .clickToAdd()
                .clickSave()
                .verifyFieldErrorMessage("Name", "Required");
    }

    @Test(priority = 9, description = "TC09 - Verify error when creating a duplicate Employment Status")
    public void verifyEmploymentStatus_DuplicateEntry_ShowError() {
        adminPage
                .navigateToSection("Job", "Employment Status")
                .clickToAdd()
                .typeInDynamicField("Name", "Duplicate Status")
                .clickSave()
                .verifySuccessMessage();

        adminPage
                .clickToAdd()
                .typeInDynamicField("Name", "Duplicate Status")
                .clickSave()
                .verifyFieldErrorMessage("Name", "Required");

        adminPage
                .navigateToSection("Job", "Employment Status")
                .deleteSpecificValue("Duplicate Status");
    }

    @Test(priority = 10, description = "TC10 - Verify updating an existing Job Title")
    public void verifyJobTitle_Update_Success() {
        adminPage
                .navigateToSection("Job", "Job Titles")
                .clickToAdd()
                .typeInDynamicField("Job Title", "Junior QA Automation Tester")
                .clickSave()
                .verifySuccessMessage();
        adminPage
                .clickToEdit("Junior QA Automation Tester")
                .typeInDynamicField("Job Title", "Senior QA Automation Tester")
                .clickSave()
                .verifySuccessMessage();
        adminPage
                .verifyRecordExists("Senior QA Automation Tester")
                .deleteSpecificValue("Senior QA Automation Tester");
    }

    @Test(priority = 11, description = "TC11 - Verify updating Pay Grade Currency Salary")
    public void verifyPayGrade_UpdateCurrency_Success() {
        adminPage
                .navigateToSection("Job", "Pay Grades")
                .clickToAdd()
                .typeInDynamicField("Name", "Grade Update Test")
                .clickSave()
                .verifyInfoMessage();
        adminPage
                .clickToAdd()
                .clickAndSelectDropdown("Currency", "CAD - Canadian Dollar")
                .typeInDynamicField("Minimum Salary", "2000")
                .typeInDynamicField("Maximum Salary", "4000")
                //.clickSecSave()
                .verifySuccessMessage();
        adminPage
                .clickToEdit("Canadian Dollar")
                .typeInDynamicField("Minimum Salary", "3000")
                .clickSave()
                .verifySuccessMessage();
        adminPage
                .navigateToSection("Job", "Pay Grades")
                .deleteSpecificValue("Grade Update Test");
    }

    @Test(priority = 12, description = "TC12 - Verify updating Employment Status Name")
    public void verifyEmploymentStatus_Update_Success() {
        String oldStatus = "Freelance Part Time ";
        String newStatus = "Part Time (Contract)";

        adminPage
                .navigateToSection("Job", "Employment Status")
                .clickToAdd()
                .typeInDynamicField("Name", oldStatus)
                .clickSave()
                .verifySuccessMessage()
                .clickToEdit(oldStatus)
                .typeInDynamicField("Name", newStatus)
                .clickSave()
                .verifySuccessMessage()
                .verifyRecordDeleted(oldStatus)
                .verifyRecordExists(newStatus)
                .deleteSpecificValue(newStatus);
    }

    @Test(priority = 13, description = "TC13 - Verify Job Category Lifecycle: Create, Verify, and Delete")
    public void verifyJobCategory_Lifecycle_Success() {
        adminPage
                .navigateToSection("Job", "Job Categories")
                .clickToAdd()
                .typeInDynamicField("Name", "Professionals - َQA Engineer")
                .clickSave()
                .verifySuccessMessage()
                .verifyRecordExists("Professionals - َQA Engineer");
    }

    @Test(priority = 14, description = "TC14 - Verify updating an existing Job Category")
    public void verifyJobCategory_Update_Success() {
        adminPage
                .navigateToSection("Job", "Job Categories")
                .clickToAdd()
                .typeInDynamicField("Name", "Solutions Architect")
                .clickSave()
                .verifySuccessMessage()
                .clickToEdit("Solutions Architect")
                .typeInDynamicField("Name", "Skilled Solutions Architect")
                .clickSave()
                .verifySuccessMessage()
                .verifyRecordDeleted("Solutions Architect")
                .verifyRecordExists("Skilled Solutions Architect")
                .deleteSpecificValue("Skilled Solutions Architect");
    }

    @Test(priority = 15, description = "TC15 - Verify validation error for empty Job Category Name")
    public void verifyJobCategory_EmptyFields_ShowError() {
        adminPage
                .navigateToSection("Job", "Job Categories")
                .clickToAdd()
                .clickSave()
                .verifyFieldErrorMessage("Name", "Required");
    }

    @Test(priority = 16, description = "TC16 - Verify error when creating a duplicate Job Category")
    public void verifyJobCategory_DuplicateEntry_ShowError() {
        String duplicateName = "Operatives";
        adminPage
                .navigateToSection("Job", "Job Categories")
                .clickToAdd()
                .typeInDynamicField("Name", "Operatives")
                .clickSave()
                .verifySuccessMessage();
        adminPage
                .clickToAdd()
                .typeInDynamicField("Name", "Operatives")
                .clickSave()
                .verifyFieldErrorMessage("Name", "Required");
        adminPage
                .navigateToSection("Job", "Job Categories")
                .deleteSpecificValue("Operatives");
    }

    @Test(priority = 17, description = "TC17 - Verify Work Shift Lifecycle: Create, Verify, and Delete")
    public void verifyWorkShift_Lifecycle_Success() {
        adminPage
                .navigateToSection("Job", "Work Shifts")
                .clickToAdd()
                .typeInDynamicField("Shift Name", "Night Shift - B")
                // .typeInDynamicField("From", "09:00 PM")
                // .typeInDynamicField("To", "05:00 AM")
                .clickSave()
                .verifySuccessMessage()
                .verifyRecordExists("Night Shift - B");

    }

    @Test(priority = 18, description = "TC18 - Verify updating an existing Work Shift")
    public void verifyWorkShift_Update_Success() {
        String oldShift = "Morning Shift";
        String newShift = "Morning Shift Extended";

        adminPage
                .navigateToSection("Job", "Work Shifts")
                .clickToAdd()
                .typeInDynamicField("Shift Name", "Morning Shift")
                .typeInDynamicField("From", "08:00 AM")
                .typeInDynamicField("To", "4:00 PM")
                .clickSave()
                .verifySuccessMessage()
                .clickToEdit("Morning Shift")
                .typeInDynamicField("Shift Name", "Morning Shift Extended")
                .clickSave()
                .verifySuccessMessage()
                .verifyRecordDeleted("Morning Shift")
                .verifyRecordExists("Morning Shift Extended")
                .deleteSpecificValue("Morning Shift Extended");
    }

    @Test(priority = 19, description = "TC19 - Verify validation error for empty Work Shift Name")
    public void verifyWorkShift_EmptyFields_ShowError() {
        adminPage
                .navigateToSection("Job", "Work Shifts")
                .clickToAdd()
                .clickSave()
                .verifyFieldErrorMessage("Shift Name", "Required");
    }

    @Test(priority = 20, description = "TC20 - Verify error when creating a duplicate Work Shift")
    public void verifyWorkShift_DuplicateEntry_ShowError() {
        String duplicateShift = "Standard Day";

        adminPage
                .navigateToSection("Job", "Work Shifts")
                .clickToAdd()
                .typeInDynamicField("Shift Name", "Standard Day")
                .typeInDynamicField("From", "09:00 AM")
                .typeInDynamicField("To", "05:00 PM")
                .clickSave()
                .verifySuccessMessage();

        adminPage
                .clickToAdd()
                .typeInDynamicField("Shift Name", "Standard Day")
                .typeInDynamicField("From", "09:00 AM")
                .typeInDynamicField("To", "05:00 PM")
                .clickSave()
                .verifyFieldErrorMessage("Shift Name", "Required");

        adminPage
                .navigateToSection("Job", "Work Shifts")
                .deleteSpecificValue("Standard Day");
    }
}
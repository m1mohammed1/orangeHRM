package project_orangehrm.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project_orangehrm.Base.BaseTest;
import project_orangehrm.Pages.DashboardPage;
import project_orangehrm.Pages.LeavePage;
import project_orangehrm.Pages.LoginPage;

public class Leave_Configuration_Test extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeavePage leavePage;

    @BeforeMethod(groups = {"foundation", "regression"})
    public void setup() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        leavePage = new LeavePage(driver);

        loginPage
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin();
        dashboardPage
                .verifyDashboard("Dashboard");
        dashboardPage
                .navigateToModule("Leave");
    }

    @Test(priority = 1, groups = {"regression"}, description = "TC01 - Verify Leave Type Lifecycle: Create, Verify, Delete")
    public void verifyLeaveType_Lifecycle_Success() {
        String typeName = "Casual Leave - Test";

        leavePage
                .navigateToSection("Configure", "Leave Types")
                .clickToAdd()
                .typeInDynamicField("Name", typeName)
                .clickToSave()
                .verifySoftSuccessMessage();
        leavePage
                .verifyRecordExists(typeName)
                .deleteSpecificValue(typeName)
                .verifySoftSuccessMessage()
                .verifyRecordDeleted(typeName);
    }

    @Test(priority = 2, groups = {"regression"}, description = "TC02 - Verify Leave Type Duplicate Validation")
    public void verifyLeaveType_Duplicate_Error() {
        String typeName = "US - Vacation";
        leavePage
                .navigateToSection("Configure", "Leave Types")
                .clickToAdd()
                .typeInDynamicField("Name", typeName)
                .clickToSave()
                .verifyFieldErrorMessage("Name", "Already exists");
    }

    @Test(priority = 3, groups = {"regression"}, description = "TC03 - Verify Work Week Configuration Update")
    public void verifyWorkWeek_Update_Success() {
        leavePage
                .navigateToSection("Configure", "Work Week")
                .clickAndSelectDropdown("Saturday", "Non-working Day")
                .clickAndSelectDropdown("Sunday", "Non-working Day")
                .clickToSave()
                .verifySuccessMessage();
    }

    @Test(priority = 4, groups = {"regression"}, description = "TC04 - Verify Holiday Lifecycle: Create, Verify, Delete")
    public void verifyHoliday_Lifecycle_Success() {
        String holidayName = "Automation Day";
        String date = "2024-12-31";

        leavePage
                .navigateToSection("Configure", "Holidays")
                .clickToAdd();
        leavePage
                .typeInDynamicField("Name", holidayName)
                .selectDate("Date", date)
                .clickToSave()
                .verifySuccessMessage()
                .selectDate("From", date)
                .selectDate("From", date)
                .clickToSubmit();
        leavePage
                .verifyRecordExists(holidayName)
                .deleteSpecificValue(holidayName)
                .verifySuccessMessage()
                .verifyRecordDeleted(holidayName);
    }

    @Test(priority = 5, groups = {"regression"}, description = "TC05 - Verify Holiday Validation Error")
    public void verifyHoliday_EmptyFields_Error() {
        leavePage
                .navigateToSection("Configure", "Holidays")
                .clickToAdd()
                .clickToSave()
                .verifyFieldErrorMessage("Name", "Required")
                .verifyFieldErrorMessage("Date", "Required");
    }

    @Test(priority = 6, groups = {"regression"}, description = "TC06 - Verify Leave Period Configuration Update")
    public void verifyLeavePeriod_Update_Success() {
        leavePage
                .navigateToSection("Configure", "Leave Period")
                .clickAndSelectDropdown("Start Month", "January")
                .clickAndSelectDropdown("Start Date", "01")
                .clickToSave()
                .verifySuccessMessage();
    }
}
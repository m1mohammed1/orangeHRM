package project_orangehrm.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project_orangehrm.Base.BaseTest;
import project_orangehrm.Pages.DashboardPage;
import project_orangehrm.Pages.LoginPage;

public class Dashboard_Widgets_Test extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        loginPage.enterUsername("Admin").enterPassword("admin123").clickLogin();
        dashboardPage.verifyDashboard("Dashboard");
    }

    // ==================================================================================
    // SECTION 1: WIDGETS VISIBILITY (Smoke Test)
    // ==================================================================================

    @Test(priority = 1, description = "TC01 - Verify Core Dashboard Widgets are Visible")
    public void verifyWidgets_Visibility() {
        dashboardPage.verifyElementVisible("Time at Work");
        dashboardPage.verifyElementVisible("My Actions");
        dashboardPage.verifyElementVisible("Quick Launch");
        dashboardPage.verifyElementVisible("Employees on Leave Today");
        dashboardPage.verifyElementVisible("Employee Distribution by Subunit");
        dashboardPage.verifyElementVisible("Employee Distribution by Location");
    }

    // ==================================================================================
    // SECTION 2: QUICK LAUNCH (Navigation Test)
    // ==================================================================================

    @Test(priority = 2, description = "TC02 - Verify Quick Launch Shortcuts Redirection")
    public void verifyQuickLaunch_Navigation() {
        // 1. Click 'Assign Leave' Icon
        dashboardPage
                .clickQuickLaunchItem("Assign Leave")
                .verifyPageTitle("Assign Leave");

        // Return to Dashboard
        dashboardPage.navigateToModule("Dashboard");

        // 2. Click 'Leave List' Icon
        dashboardPage
                .clickQuickLaunchItem("Leave List")
                .verifyPageTitle("Leave List");

        // Return
        dashboardPage.navigateToModule("Dashboard");

        // 3. Click 'Timesheets' Icon
        dashboardPage
                .clickQuickLaunchItem("Timesheets")
                .verifyPageTitle("Timesheets");
    }

    // ==================================================================================
    // SECTION 3: TIME AT WORK (Functional Test)
    // ==================================================================================

    @Test(priority = 3, description = "TC03 - Verify Time at Work Stopwatch Integration")
    public void verifyTimeWidget_ClockAction() {
        dashboardPage
                .clickTimeClockButton()
                .verifyPageTitle("Punch");
    }
}
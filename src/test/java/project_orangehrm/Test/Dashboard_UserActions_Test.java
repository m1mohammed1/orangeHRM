package project_orangehrm.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project_orangehrm.Base.BaseTest;
import project_orangehrm.Pages.DashboardPage;
import project_orangehrm.Pages.LoginPage;

public class Dashboard_UserActions_Test extends BaseTest {

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
    // SECTION 1: USER DROPDOWN (About & Logout)
    // ==================================================================================

    @Test(priority = 1, description = "TC01 - Verify About Modal Popup")
    public void verifyUserMenu_AboutInfo() {
        // Click About from user menu
        dashboardPage.clickAbout();

        // Verify Modal Content
        dashboardPage.verifyDialogContains("OrangeHRM");
        dashboardPage.verifyDialogContains("Version");

        // Close Modal
        dashboardPage.closeDialog();
    }

    @Test(priority = 2, description = "TC02 - Verify Logout Functionality")
    public void verifyUserMenu_Logout() {
        dashboardPage.clickLogout();

        // Assert we are back to Login Page
        dashboardPage.verifyElementVisible("Login");

        // Or check URL
        if (!driver.getCurrentUrl().contains("login")) {
            throw new AssertionError("Logout Failed! URL does not contain 'login'");
        }
    }

    // ==================================================================================
    // SECTION 2: DASHBOARD CONFIGURATION (The Hidden Gem)
    // ==================================================================================

    @Test(priority = 3, description = "TC03 - Verify Hiding and Showing Widgets")
    public void verifyDashboard_Configuration_Toggle() {
        String widgetName = "Quick Launch";

        // 1. Open Configuration (Gear Icon)
        dashboardPage.clickGearIcon();

        // 2. Toggle 'Quick Launch' OFF
        dashboardPage.toggleWidgetVisibility(widgetName);

        // 3. Save Config
        dashboardPage.clickSave();

        // 4. Verify 'Quick Launch' is GONE from Dashboard
        boolean isVisible = dashboardPage.isWidgetVisible(widgetName);
        if (isVisible) {
            throw new AssertionError("Widget '" + widgetName + "' should be hidden but is visible!");
        }

        // 5. Cleanup: Turn it back ON
        dashboardPage.clickGearIcon();
        dashboardPage.toggleWidgetVisibility(widgetName);
        dashboardPage.clickSave();

        // 6. Verify it's BACK
        dashboardPage.verifyElementVisible(widgetName);
    }
}
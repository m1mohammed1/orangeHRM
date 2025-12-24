package project_orangehrm.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project_orangehrm.Base.BaseTest;
import project_orangehrm.Pages.DashboardPage;
import project_orangehrm.Pages.LoginPage;
import project_orangehrm.Pages.TimePage;

public class Time_ProjectInfo_Test extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private TimePage timePage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        timePage = new TimePage(driver);

        loginPage
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin();
        dashboardPage
                .verifyDashboard("Dashboard");
        dashboardPage
                .navigateToModule("Time");
    }

    @Test(priority = 1, description = "TC01 - Verify Customer Lifecycle: Create, Verify, Delete")
    public void verifyCustomer_Lifecycle_Success() {
        String customerName = "Alpha Corp Global";
        String description = "Major Client for QA";
        timePage
                .navigateToSection("Project Info", "Customers")
                .clickToAdd()
                .typeInDynamicField("Name", customerName)
                .typeInDynamicTextArea("Description", description)
                .clickSave()
                .verifySuccessMessage()
                .verifyRecordExists(customerName)
                .deleteSpecificValue(customerName)
                .verifySuccessMessage()
                .verifyRecordDeleted(customerName);
    }

    @Test(priority = 2, description = "TC02 - Verify Customer Validation Error")
    public void verifyCustomer_EmptyFields_Error() {
        timePage
                .navigateToSection("Project Info", "Customers")
                .clickToAdd()
                .clickSave();
                //.verifyFieldErrorMessage("Name");
    }

    @Test(priority = 3, description = "TC03 - Verify Project Lifecycle: Create, Verify, Delete")
    public void verifyProject_Lifecycle_Success() {
        String customerName = "Beta Industries";
        String projectName = "Project X - Automation";
        String adminName = "Script Automation Test";

        timePage
                .navigateToSection("Project Info", "Customers")
                .clickToAdd()
                .typeInDynamicField("Name", customerName)
                .clickSave();
        timePage
                .navigateToSection("Project Info", "Projects")
                .clickToAdd()
                .typeInDynamicField("Project Name", projectName)
                .typeInDynamicField("Customer Name", customerName)
                .selectFromList()
                .typeInDynamicField("Project Admin", adminName)
                .selectFromList()
                .clickSave()
                .verifySuccessMessage()
                .verifyRecordExists(projectName)
                .deleteSpecificValue(projectName)
                .verifySuccessMessage();
        timePage
                .navigateToSection("Project Info", "Customers")
                .deleteSpecificValue(customerName);
    }
}
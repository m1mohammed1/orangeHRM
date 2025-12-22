package project_orangehrm.TestCleaning;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project_orangehrm.Base.BaseTest;
import project_orangehrm.Pages.AdminPage;
import project_orangehrm.Pages.DashboardPage;
import project_orangehrm.Pages.LoginPage;

public class AdminTestCleaning extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AdminPage adminPage;

    @BeforeMethod
    public void setUP() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        adminPage = new AdminPage(driver);

        loginPage
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin();
        dashboardPage
                .navigateToModule("Admin");
    }

    @Test(priority = 1, description = "Validate and Cleanup User Account")
    public void cleanUpUserAccount() {
        adminPage
                .verifyAdminPage("Admin")
                .typeInDynamicField("Employee Name", "Script Automation Test")
                .typeInDynamicField("Username", "TestAdmin_QA")
                .searchUser()
                .verifyRecordExists("TestAdmin_QA");
        adminPage
                .deleteSpecificValue("TestAdmin_QA")
                .verifySuccessMessage();
    }


    @Test(priority = 2, description = "Validate and Cleanup Job Title")
    public void cleanUpJobTitle() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Job","Job Titles")
                .verifyRecordExists("Principal SDET Engineer")
                .deleteSpecificValue("Principal SDET Engineer")
                .verifySuccessMessage();
    }

    @Test(priority = 3, description = "Validate and Cleanup Pay Grade")
    public void cleanUpPayGrade() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Job","Pay Grades")
                .verifyRecordExists("Grade 5 - Executive")
                .deleteSpecificValue("Grade 5 - Executive")
                .verifySuccessMessage();
    }


    @Test(priority = 4, description = "Validate and Cleanup Employment Status")
    public void cleanUpEmploymentStatus() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Job","Employment Status")
                .verifyRecordExists("Freelance - Project Based")
                .deleteSpecificValue("Freelance - Project Based")
                .verifySuccessMessage();
    }

    @Test(priority = 5, description = "Validate and Cleanup Job Category")
    public void cleanUpJobCategory() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Job","Job Categories")
                .verifyRecordExists("Professionals - َQA Engineer")
                .deleteSpecificValue("Professionals - َQA Engineer")
                .verifySuccessMessage();
    }

    @Test(priority = 6, description = "Validate and Cleanup Work Shift")
    public void cleanUpWorkShift() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Job","Work Shifts")
                .verifyRecordExists("Night Shift - B")
                .deleteSpecificValue("Night Shift - B")
                .verifySuccessMessage();
    }

    @Test(priority = 7, description = "Validate and Cleanup Location")
    public void cleanUpLocation() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Organization","Locations")
                .typeInDynamicField("Name", "Cairo Innovation Hub")
                .searchUser()
                .verifyRecordExists("Cairo Innovation Hub");
        adminPage
                .deleteSpecificValue("Cairo Innovation Hub")
                .verifySuccessMessage();
    }

/** wait to Edit (Structure) notable to use dynamic locator
    @Test(priority = 8)
    public void test8() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Organization","Locations")
                .typeInDynamicField("Name", "Cairo Innovation Hub")
                .searchUser()
                .verifyRecordExists("Cairo Innovation Hub");
        adminPage
                .deleteSpecificValue("Cairo Innovation Hub")
                .verifySuccessMessage();
    }
    **/


    @Test(priority = 9, description = "Validate and Cleanup Skill")
    public void cleanUpSkill() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Qualifications","Skills")
                .verifyRecordExists("Java Automation");
        adminPage
                .deleteSpecificValue("Backend and Frontend Testing")
                .verifySuccessMessage();
    }

    @Test(priority = 10, description = "Validate and Cleanup Education")
    public void cleanUpEducation() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Qualifications","Education")
                .verifyRecordExists("Master of Science");
        adminPage
                .deleteSpecificValue("Master of Science")
                .verifySuccessMessage();
    }

    @Test(priority = 11, description = "Validate and cleanup License")
    public void cleanUpLicense() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Qualifications","Licenses")
                .verifyRecordExists("ISTQB Foundation");
        adminPage
                .deleteSpecificValue("ISTQB Foundation")
                .verifySuccessMessage();
    }

    @Test(priority = 12, description = "Validate and Cleanup Language")
    public void cleanUpLanguage() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Qualifications","Languages")
                .verifyRecordExists("German-Arabic");
        adminPage
                .deleteSpecificValue("German-Arabic")
                .verifySuccessMessage();
    }

    @Test(priority = 13, description = "Validate and Cleanup Membership")
    public void cleanUpMembership() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Qualifications","Memberships")
                .verifyRecordExists("IEEE Member");
        adminPage
                .deleteSpecificValue("IEEE Member")
                .verifySuccessMessage();
    }

    @Test(priority = 14, description = "Validate and Cleanup Email Subscription")
    public void cleanUpEmailConfiguration() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Configuration","Email Subscriptions")
                .clickToSubscribe("Leave Applications")
                .verifyRecordExists("Automation Subscriber");
        adminPage
                .deleteSpecificValue("Automation Subscriber")
                .verifySuccessMessage();
    }




}

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


    @Test(priority = 1, description = "Validate and Cleanup Job Title")
    public void cleanUpJobTitle() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Job","Job Titles")
                .deleteIfExists("Principal SDET Engineer");
    }

    @Test(priority = 2, description = "Validate and Cleanup Pay Grade")
    public void cleanUpPayGrade() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Job", "Pay Grades")
                .deleteIfExists("Grade 5 - Executive");
    }

    @Test(priority = 2, description = "Cleanup Employment Status - Freelance - Project Based")
    public void cleanUpEmploymentStatus() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Job", "Employment Status")
                .deleteIfExists("Freelance - Project Based");
    }

    @Test(priority = 3, description = "Cleanup Job Category - Professionals - QA Engineer")
    public void cleanUpJobCategory() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Job", "Job Categories")
                .deleteIfExists("Professionals - َQA Engineer");
    }

    @Test(priority = 4, description = "Cleanup Work Shift - Night Shift - B")
    public void cleanUpWorkShift() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Job", "Work Shifts")
                .deleteIfExists("Night Shift - B");
    }

    @Test(priority = 6, description = "Validate and Cleanup Location")
    public void cleanUpLocation() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Organization","Locations")
                .typeInDynamicField("Name", "Cairo Innovation Hub")
                .searchUser()
                .deleteIfExists("Cairo Innovation Hub");
    }

    @Test(priority =8, description = "Validate and Cleanup Skill - Java Automation")
    public void cleanUpSkill() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Qualifications", "Skills")
                .deleteIfExists("Java Automation");
    }

    @Test(priority = 9, description = "Cleanup Education - Master of Science")
    public void cleanUpEducation() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Qualifications", "Education")
                .deleteIfExists("Master of Science");
    }

    @Test(priority = 10, description = "Cleanup License - ISTQB Foundation")
    public void cleanUpLicense() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Qualifications", "Licenses")
                .deleteIfExists("ISTQB Foundation");
    }

    @Test(priority = 11, description = "Cleanup Language - German-Arabic")
    public void cleanUpLanguage() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Qualifications", "Languages")
                .deleteIfExists("German-Arabic");
    }

    @Test(priority = 12, description = "Cleanup Membership - IEEE Member")
    public void cleanUpMembership() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Qualifications", "Memberships")
                .deleteIfExists("IEEE Member");
    }

    @Test(priority = 13, description = "Cleanup Email Subscription - Automation Subscriber")
    public void cleanUpEmailSubscription() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Configuration", "Email Subscriptions")
                .clickToSubscribe("Leave Applications")
                .deleteIfExists("Automation Subscriber");
    }

    @Test(priority = 14, description = "Cleanup Nationality - Automation Tester Nationality")
    public void cleanUpNationality() {
        adminPage
                .verifyAdminPage("Admin")
                .navigateToSection("Nationalities")
                .deleteIfExists("Automation Tester Nationality");
    }
}

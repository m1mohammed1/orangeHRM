package project_orangehrm.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project_orangehrm.Base.BaseTest;
import project_orangehrm.Pages.BuzzPage;
import project_orangehrm.Pages.DashboardPage;
import project_orangehrm.Pages.LoginPage;

public class Buzz_Newsfeed_Test extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private BuzzPage buzzPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        buzzPage = new BuzzPage(driver);

        loginPage.enterUsername("Admin").enterPassword("admin123").clickLogin();
        dashboardPage.navigateToModule("Buzz");
    }

    // ==================================================================================
    // SCENARIO 1: POST LIFECYCLE (Create, Verify, Delete)
    // ==================================================================================

    @Test(priority = 1, description = "TC01 - Verify Post Lifecycle: Create, Check, Delete")
    public void verifyPost_Lifecycle_Success() {
        String postText = "Hello OrangeHRM Team - Automation Test " + System.currentTimeMillis();

        // 1. Create Post
        buzzPage
                .createPost(postText)
                .verifySuccessMessage();

        // 2. Verify Post appears in Feed
        buzzPage.verifyBodyContains(postText);

        // 3. Delete Post (Cleanup)
        buzzPage
                .clickPostOptions(postText)
                .clickDeleteOption()
                .confirmDelete()
                .verifySuccessMessage();
    }

    // ==================================================================================
    // SCENARIO 2: ENGAGEMENT (Like & Comment)
    // ==================================================================================

    @Test(priority = 2, description = "TC02 - Verify Like and Comment Functionality")
    public void verifyEngagement_Success() {
        String text = "Engagement Test";
        String comment = "Great update!";

        // Pre-req: Create a post first
        buzzPage.createPost(text);

        // 1. Like
        buzzPage.clickLikeOnFirstPost();

        // 2. Comment
        buzzPage.addCommentOnFirstPost(comment);

        // 3. Verify Comment Visible
        buzzPage.verifyBodyContains(comment);
    }

    @Test(priority = 3, description = "TC03 - Verify Edit Post Functionality")
    public void verifyPost_Edit_Success() {
        String original = "Original Text";
        String updated = "Updated Text";

        // 1. Create
        buzzPage.createPost(original);

        // 2. Edit
        buzzPage
                .clickPostOptions(original)
                .clickEditOption()
                .editPostContent(updated)
                .clickPostButton()
                .verifySuccessMessage();

        // 3. Verify Update
        buzzPage.verifyBodyContains(updated);
    }
}
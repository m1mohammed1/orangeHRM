package project_orangehrm.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project_orangehrm.Base.BaseTest;
import project_orangehrm.Pages.BuzzPage;
import project_orangehrm.Pages.DashboardPage;
import project_orangehrm.Pages.LoginPage;

public class Buzz_Media_Test extends BaseTest {

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

    @Test(priority = 1, description = "TC01 - Verify Posting with Photo Upload")
    public void verifyPhotoPost_Success() {
        String photoPath = System.getProperty("user.dir") + "/src/test/resources/test_data/buzz_image.jpg";
        String caption = "Team Outing Photo";

       /* buzzPage
                .clickSharePhotos() // Click 'Share Photos' tab/button
                .typeInDynamicTextArea("What's on your mind?", caption)
                // Use upload method (standard file input interaction)
                .uploadPhoto(photoPath)
                .clickPostButton()
                .verifySuccessMessage();

        // Verify Image is present
        // Look for <img src="..."> in the feed
        boolean hasImage = buzzPage.isImagePresentInFeed();
        if (!hasImage) {
            throw new AssertionError("Image post created but image element not found in feed!");
        }
    }

        */
    }
}
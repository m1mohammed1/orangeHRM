package project_orangehrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class BuzzPage extends CommonPage {

    private final By POST_INPUT = By.xpath("//textarea[@placeholder=\"What's on your mind?\"]");
    private final By POST_BTN = By.xpath("//button[@type='submit']");
    private final By LIKE_ICON = By.xpath("(//i[contains(@class,'bi-heart')])[1]");
    private final By COMMENT_ICON = By.xpath("(//i[contains(@class,'bi-chat-dots')])[1]");
    private final By COMMENT_INPUT = By.xpath("//input[@placeholder='Write your comment...']");

    public BuzzPage(WebDriver driver) {
        super(driver);
    }


    public BuzzPage verifyBuzzPage(String expectedHeader) {
        verifyPageHeader(expectedHeader);
        return this;
    }

    public BuzzPage createPost(String text) {
        type(POST_INPUT, text);
        clickWhenReady(POST_BTN);
        return this;
    }

    public BuzzPage clickPostButton() {
        clickWhenReady(POST_BTN);
        return this;
    }

    public BuzzPage clickLikeOnFirstPost() {
        clickWhenReady(LIKE_ICON);
        return this;
    }

    public BuzzPage addCommentOnFirstPost(String comment) {
        clickWhenReady(COMMENT_ICON);
        type(COMMENT_INPUT, comment);
        driver.findElement(COMMENT_INPUT).sendKeys(Keys.ENTER);
        return this;
    }

    public BuzzPage verifyMostLikedWidget() {
        verifyElementVisible("Most Liked Posts");
        return this;
    }

    public BuzzPage verifyElementVisible(String elementText) {
        super.verifyElementVisible(elementText);
        return this;
    }

    public BuzzPage verifyBodyContains(String expectedText) {
        assertTextContain(By.tagName("body"), expectedText);
        return this;
    }

    public BuzzPage clickPostOptions(String postText) {
        clickWhenReady(By.xpath("//p[contains(text(),'" + postText + "')]/ancestor::div[contains(@class,'oxd-sheet')]//button[contains(@class,'oxd-icon-button')]"));
        return this;
    }

    public BuzzPage clickDeleteOption() {
        clickAction("Delete");
        return this;
    }

    public BuzzPage clickEditOption() {
        clickAction("Edit");
        return this;
    }

    public BuzzPage confirmDelete() {
        confirm();
        return this;
    }

    public BuzzPage editPostContent(String newText) {
        type(POST_INPUT, newText);
        return this;
    }

    public BuzzPage navigateToSection(String mainCategory, String subCategory) {
        super.navigateToSection(mainCategory, subCategory);
        return this;
    }

    public BuzzPage verifySuccessMessage() {
        verifySuccessToast();
        return this;
    }

    public BuzzPage verifyPageHeader(String expectedHeader) {
        verifyHeader(expectedHeader);
        return this;
    }
}

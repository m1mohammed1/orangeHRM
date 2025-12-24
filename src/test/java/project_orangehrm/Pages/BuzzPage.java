package project_orangehrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BuzzPage extends CommonPage {

    private final By POST_INPUT = By.xpath("//textarea[contains(@placeholder,'mind')]");
    private final By POST_BTN = By.xpath("//button[@type='submit']");
    private final By COMMENT_INPUT = By.xpath("//input[@placeholder='Write your comment...']");
    private final By DELETE_OPTION = By.xpath("//p[contains(normalize-space(),'Delete')]");
    private final By EDIT_OPTION = By.xpath("//p[contains(normalize-space(),'Edit')]");
    private final By BODY_TAG = By.tagName("body");
    private final By EDIT_MODAL_TEXTAREA = By.xpath("//div[@role='document']//textarea");
    private final By EDIT_MODAL_POST_BTN = By.xpath("//div[@role='document']//button[@type='submit']");
    private final By EMPTY_POST_ERROR = By.xpath("//div[contains(@class,'oxd-buzz-post-input-group')]//span");

    private final String DYNAMIC_POST_OPTIONS = "//div[contains(@class,'oxd-sheet')][descendant::*[contains(normalize-space(),'%s')]]//button[contains(@class,'oxd-icon-button')]";
    private final String DYNAMIC_LIKE_BTN = "//div[contains(@class,'orangehrm-buzz-post')][.//*[contains(normalize-space(),'%s')]]//div[contains(@class,'orangehrm-buzz-post-actions')]//button[i[contains(@class,'bi-heart')]]";
    private final String DYNAMIC_COMMENT_BTN = "//*[contains(normalize-space(),'%s')]/ancestor::div[contains(@class,'oxd-sheet')]//i[contains(@class,'bi-chat-dots')]/parent::button";
    public BuzzPage(WebDriver driver) {
        super(driver);
    }

    public BuzzPage createPost(String text) {
        type(POST_INPUT, text);
        clickWhenReady(POST_BTN);
        return this;
    }

    public BuzzPage clickLikeOnPost(String postText) {
        waitToastDisappear();
        clickJS(getLocator(DYNAMIC_LIKE_BTN, postText));
        return this;
    }

    public BuzzPage addCommentOnPost(String postText, String comment) {
        waitToastDisappear();
        clickJS(getLocator(DYNAMIC_COMMENT_BTN, postText));
        type(COMMENT_INPUT, comment);
        driver.findElement(COMMENT_INPUT).sendKeys(Keys.ENTER);
        return this;
    }

    public BuzzPage verifyBodyContains(String expectedText) {
        assertTextContain(BODY_TAG, expectedText);
        return this;
    }

    public BuzzPage verifyBodyNotContains(String unexpectedText) {
        waitToastDisappear();
        assertTextNotContains(BODY_TAG, unexpectedText, "Post still visible after deletion!");
        return this;
    }

    public BuzzPage clickPostOptions(String postText) {
        waitToastDisappear();
        clickJS(getLocator(DYNAMIC_POST_OPTIONS, postText));
        return this;
    }

    public BuzzPage clickDeleteOption() {
        clickWhenReady(DELETE_OPTION);
        return this;
    }

    public BuzzPage clickEditOption() {
        clickWhenReady(EDIT_OPTION);
        return this;
    }

    public BuzzPage confirmDelete() {
        confirmDeletion();
        return this;
    }

    public BuzzPage cancelDelete() {
        cancel();
        return this;
    }

    public BuzzPage editPostContent(String newText) {
        type(EDIT_MODAL_TEXTAREA, newText);
        clickWhenReady(EDIT_MODAL_POST_BTN);
        return this;
    }

    public BuzzPage verifyEmptyPostError(String expectedMessage) {
        assertTextContain(EMPTY_POST_ERROR, expectedMessage);
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
package project_orangehrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonPage {

    // ==================== Page-Specific Locators ====================
    private final By USERNAME_FIELD = By.cssSelector("input[placeholder='Username']");
    private final By PASSWORD_FIELD = By.cssSelector("input[placeholder='Password']");
    private final By LOGIN_BTN = By.cssSelector("button[type='submit']");
    private final By INVALID_CREDENTIALS_MSG = By.xpath("//p[text()='Invalid credentials']");
    private final By REQUIRED_FIELD_MSG = By.xpath("//span[text()='Required']");
    private final By FORGET_PASSWORD_LINK = By.cssSelector(".orangehrm-login-forgot-header");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage enterUsername(String username) {
        typeText(USERNAME_FIELD, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        typeText(PASSWORD_FIELD, password);
        return this;
    }

    public LoginPage clickLogin() {
        assertVisible(LOGIN_BTN, "Login button is not visible");
        clickWhenReady(LOGIN_BTN);
        return this;
    }

    public LoginPage clickForgetPassword() {
        clickWhenReady(FORGET_PASSWORD_LINK);
        return this;
    }

    public LoginPage verifyInvalidCredentialsError(String expectedText) {
        assertTextContain(INVALID_CREDENTIALS_MSG, expectedText);
        return this;
    }

    public LoginPage verifyRequiredFieldError(String expectedText) {
        assertTextContain(REQUIRED_FIELD_MSG, expectedText);
        return this;
    }
}

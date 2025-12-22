package project_orangehrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage extends CommonPage {

    // ==================== Page-Specific Locators ====================
    private final By USER_DROPDOWN = By.cssSelector(".oxd-userdropdown-tab");
    private final By LOGOUT_LINK = By.xpath("//a[normalize-space()='Logout']");
    private final By ABOUT_LINK = By.xpath("//a[normalize-space()='About']");
    private final By TODO_LIST = By.xpath("//div[contains(@class,'orangehrm-todo-list')]//p");
    private final By TODO_ACTION = By.xpath("(//div[contains(@class,'orangehrm-todo-list')]//div[@role='button'])[1]");
    private final By GEAR_ICON = By.cssSelector(".bi-gear");
    private final By TIME_CLOCK_BTN = By.cssSelector(".oxd-icon-button.oxd-icon-button--solid-main");

    private final String QUICK_LAUNCH_ITEM = "//button[@title='%s']";
    private final String WIDGET_TOGGLE = "//p[text()='%s']/parent::div//span[contains(@class,'oxd-switch-input')]";

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage clickQuickLaunchItem(String itemName) {
        clickWhenReady(By.xpath(String.format(QUICK_LAUNCH_ITEM, itemName)));
        return this;
    }

    public DashboardPage openUserMenu() {
        clickWhenReady(USER_DROPDOWN);
        return this;
    }

    public DashboardPage clickLogout() {
        openUserMenu();
        clickWhenReady(LOGOUT_LINK);
        return this;
    }

    public DashboardPage clickAbout() {
        openUserMenu();
        clickWhenReady(ABOUT_LINK);
        return this;
    }

    public DashboardPage clickGearIcon() {
        clickWhenReady(GEAR_ICON);
        return this;
    }

    public DashboardPage clickTimeClockButton() {
        clickWhenReady(TIME_CLOCK_BTN);
        return this;
    }

    public DashboardPage clickFirstPendingAction() {
        clickWhenReady(TODO_ACTION);
        return this;
    }

    public DashboardPage toggleWidgetVisibility(String widgetName) {
        clickWhenReady(By.xpath(String.format(WIDGET_TOGGLE, widgetName)));
        return this;
    }

   /* public boolean hasPendingActions() {
        return driver.findElements(TODO_LIST).size() > 0;
    }

    */

    public boolean isWidgetVisible(String widgetName) {
        return isElementVisible(widgetName);
    }

    public DashboardPage verifyElementVisible(String elementText) {
        super.verifyElementVisible(elementText);
        return this;
    }

    public DashboardPage verifyPageTitle(String expectedTitle) {
        verifyTitle(expectedTitle);
        return this;
    }

    // ==================== Fluent Wrapper Methods ====================
    public DashboardPage navigateToSection(String mainCategory, String subCategory) {
        super.navigateToSection(mainCategory, subCategory);
        return this;
    }

    public DashboardPage clickSave() {
        save();
        return this;
    }

    public DashboardPage verifySuccessMessage() {
        verifySuccessToast();
        return this;
    }

    public DashboardPage verifyTextContain(By locator, String expectedText) {
        super.verifyTextContain(locator, expectedText);
        return this;
    }

    public DashboardPage verifyDialogContains(String expectedText) {
        verifyDialogText(expectedText);
        return this;
    }

    public DashboardPage closeDialog() {
        dismissDialog();
        return this;
    }
}

package project_orangehrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MaintenancePage extends CommonPage {

    private final By ACCESS_PASSWORD_FIELD = By.name("password");
    private final By VERIFY_BTN = By.xpath("//button[normalize-space()='Confirm']");
    private final By FIRST_CHECK_BOX_BTN = By.cssSelector(".oxd-table-card .oxd-checkbox-input");
    private final By ALL_CHECK_BOX_BTN = By.cssSelector(".oxd-table-header .oxd-checkbox-input");


    public MaintenancePage(WebDriver driver) {
        super(driver);
    }


    public MaintenancePage verifyMaintenancePage(String expectedHeader) {
        verifyHeader(expectedHeader);
        return this;
    }

    public MaintenancePage verifyAccessPassword(String password) {
        conditionalTypeAndClick(ACCESS_PASSWORD_FIELD, password, VERIFY_BTN);
        return this;
    }

    public MaintenancePage clickCancelPassword() {
        cancel();
        return this;
    }

    public MaintenancePage searchUser() {
        submit();
        return this;
    }

    public MaintenancePage clickFirstCheckbox() {
        clickWhenReady(FIRST_CHECK_BOX_BTN);
        return this;
    }

    public MaintenancePage clickSelectAllCheckbox() {
        clickWhenReady(ALL_CHECK_BOX_BTN);
        return this;
    }

    public MaintenancePage clickEmployeeModel(String actionValue) {
        super.clickAction(actionValue);
        return this;
    }


    public MaintenancePage verifyDialogContains(String expectedText) {
        verifyDialogText(expectedText);
        return this;
    }

    public MaintenancePage verifyBodyContains(String expectedText) {
        assertTextContain(By.tagName("body"), expectedText);
        return this;
    }

    public MaintenancePage verifyFieldErrorMessage(String fieldName, String expectedError) {
        verifyFieldError(fieldName);
        return this;
    }

    public MaintenancePage verifyPageTitle(String expectedTitle) {
        verifyTitle(expectedTitle);
        return this;
    }

    public MaintenancePage navigateToSection(String mainCategory, String subCategory) {
        super.navigateToSection(mainCategory, subCategory);
        return this;
    }

    public MaintenancePage navigateToSection(String mainCategory) {
        super.navigateToSection(mainCategory);
        return this;
    }

    public MaintenancePage typeInDynamicField(String fieldName, String text) {
        typeInField(fieldName, text);
        return this;
    }

    public MaintenancePage clickSave() {
        save();
        return this;
    }

    public MaintenancePage selectFromList() {
        selectFirstOption();
        return this;
    }

    public MaintenancePage verifySuccessMessage() {
        verifySuccessToast();
        return this;
    }

    public MaintenancePage verifySearchTable() {
        verifyFilterVisible();
        return this;
    }

    public MaintenancePage verifyTextContain(By locator, String expectedText) {
        super.verifyTextContain(locator, expectedText);
        return this;
    }
}

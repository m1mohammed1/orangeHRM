package project_orangehrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ClaimPage extends CommonPage {


    private final By ACTIVATE_BTN = By.xpath("//button[normalize-space()='Activate']");
    private final By ADD_LOG_BTN = By.xpath("//button[normalize-space()='Add Log']");
    private final By DOWNLOAD_BTN = By.xpath("//button[normalize-space()='Download']");

    public ClaimPage(WebDriver driver) {
        super(driver);
    }

    public ClaimPage navigateToSection(String mainCategory, String subCategory) {
        super.navigateToSection(mainCategory, subCategory);
        return this;
    }

    public ClaimPage navigateToSection(String mainCategory) {
        super.navigateToSection(mainCategory);
        return this;
    }

    public ClaimPage verifyClaimPage(String expectedHeader) {
        verifyHeader(expectedHeader);
        return this;
    }

    public ClaimPage selectCurrency(String currency) {
        selectDropdownOption("Currency", currency);
        return this;
    }

    public ClaimPage clickAddExpense() {
        add();
        return this;
    }

    public ClaimPage clickToSubmit() {
        submit();
        return this;
    }

    public ClaimPage clickActivate() {
        clickWhenReady(ACTIVATE_BTN);
        return this;
    }

    public ClaimPage clickAddLog() {
        clickWhenReady(ADD_LOG_BTN);
        return this;
    }

    public ClaimPage clickDownload() {
        clickWhenReady(DOWNLOAD_BTN);
        return this;
    }

    public ClaimPage clickActionStatus(String actionName) {
        clickAction(actionName);
        return this;
    }

    public ClaimPage clickOnEmployee(String firstName) {
        clickRecord(firstName);
        return this;
    }

    public double getClaimTotalAmount() {
        try {
            String totalText = driver.findElement(
                    By.xpath("//span[contains(@class,'oxd-text--subtitle-1')]")).getText();
            return Double.parseDouble(totalText.replaceAll("[^0-9.]", ""));
        } catch (Exception e) {
            return 0.0;
        }
    }

    public ClaimPage uploadReceipt(String filePath) {
        upload(filePath);
        return this;
    }

    public ClaimPage typeInDynamicField(String fieldName, String text) {
        typeInField(fieldName, text);
        return this;
    }

    public ClaimPage typeInDynamicTextArea(String fieldName, String text) {
        typeInTextArea(fieldName, text);
        return this;
    }

    public ClaimPage clickAndSelectDropdown(String dropdownName, String visibleText) {
        selectDropdownOption(dropdownName, visibleText);
        return this;
    }

    public ClaimPage clickSave() {
        save();
        return this;
    }

    public ClaimPage clickToAdd() {
        add();
        return this;
    }

    public ClaimPage selectFromList() {
        selectFirstOption();
        return this;
    }

    public ClaimPage selectDate(String fieldName, String dateValue) {
        enterDate(fieldName, dateValue);
        return this;
    }

    public ClaimPage searchUser() {
        submit();
        return this;
    }

    public ClaimPage verifyBodyContains(String expectedText) {
        assertTextContain(org.openqa.selenium.By.tagName("body"), expectedText);
        return this;
    }

    public ClaimPage clickSideTab(String tabName) {
        clickTab(tabName);
        return this;
    }

    public ClaimPage clickToEdit(String value) {
        edit(value);
        return this;
    }

    public ClaimPage deleteSpecificValue(String value) {
        delete(value);
        return this;
    }

    public ClaimPage verifySuccessMessage() {
        verifySuccessToast();
        return this;
    }

    public ClaimPage verifyInfoMessage() {
        verifyInfoToast();
        return this;
    }

    public ClaimPage verifyRecordExists(String recordName) {
        verifyRecordVisible(recordName);
        return this;
    }

    public ClaimPage verifyRecordDeleted(String recordName) {
        verifyRecordNotVisible(recordName);
        return this;
    }

    public ClaimPage verifyFieldErrorMessage(String fieldName, String expectedError) {
        verifyFieldError(fieldName);
        return this;
    }

    public ClaimPage verifySearchTable() {
        verifyFilterVisible();
        return this;
    }

    public ClaimPage verifyTextContain(By locator, String expectedText) {
        super.verifyTextContain(locator, expectedText);
        return this;
    }
}

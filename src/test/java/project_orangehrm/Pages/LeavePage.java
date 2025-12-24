package project_orangehrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeavePage extends CommonPage {

    private final By APPROVE_BTN = By.xpath("//button[i[contains(@class, 'bi-check')]]");
    private final By REJECT_BTN = By.xpath("//button[i[contains(@class, 'bi-x')]]");
    private final By CANCEL_BTN = By.xpath("//button[i[contains(@class, 'bi-slash-circle')]]");
    private final By VIEW_DETAILS_BTN = By.xpath("//button[i[contains(@class, 'bi-eye')]]");
    private final By ADD_COMMENT_BTN = By.xpath("//button[i[contains(@class, 'bi-chat-text')]]");

    public LeavePage(WebDriver driver) {
        super(driver);
    }

    public LeavePage verifyLeavePage(String expectedHeader) {
        verifyHeader(expectedHeader);
        return this;
    }

    public LeavePage navigateToSection(String mainCategory, String subCategory) {
        super.navigateToSection(mainCategory, subCategory);
        return this;
    }

    public LeavePage navigateToSection(String mainCategory) {
        super.navigateToSection(mainCategory);
        return this;
    }

    public LeavePage typeInDynamicField(String fieldName, String text) {
        typeInField(fieldName, text);
        return this;
    }

    public LeavePage typeInDynamicTextArea(String fieldName, String text) {
        typeInTextArea(fieldName, text);
        return this;
    }

    public LeavePage clickAndSelectDropdown(String dropdownName, String visibleText) {
        selectDropdownOption(dropdownName, visibleText);
        return this;
    }

    public LeavePage clickToSave() {
        save();
        return this;
    }

    public LeavePage clickToOK() {
        ok();
        return this;
    }

    public LeavePage clickToSubmit(){
        submit();
        return this;
    }

    public LeavePage clickToAdd() {
        add();
        return this;
    }

    public LeavePage clickToReset() {
        reset();
        return this;
    }

    public LeavePage searchUser() {
        submit();
        return this;
    }

    public LeavePage selectFromList() {
        selectFirstOption();
        return this;
    }

    public LeavePage selectDate(String fieldName, String dateValue) {
        enterDate(fieldName, dateValue);
        return this;
    }

    public LeavePage clickCheckbox(String labelText) {
        clickOnCheckbox(labelText);
        return this;
    }

    public LeavePage clickActionStatus(String actionName) {
        clickAction(actionName);
        return this;
    }

    public LeavePage clickConfirm() {
        confirm();
        return this;
    }

    public LeavePage deleteSpecificValue(String value) {
        delete(value);
        return this;
    }

    public LeavePage verifySuccessMessage() {
        verifySuccessToast();
        return this;
    }

    public LeavePage verifyRecordExists(String recordName) {
        verifyRecordVisible(recordName);
        return this;
    }

    public LeavePage verifyRecordDeleted(String recordName) {
        verifyRecordNotVisible(recordName);
        return this;
    }

    public LeavePage verifyFieldErrorMessage(String fieldName, String expectedError) {
        verifyFieldError(fieldName);
        return this;
    }

    public LeavePage verifySearchTable() {
        verifyFilterVisible();
        return this;
    }

    public LeavePage clickApproveLeave() {
        clickWhenReady(APPROVE_BTN);
        return this;
    }

    public LeavePage clickRejectLeave() {
        clickWhenReady(REJECT_BTN);
        return this;
    }

    public LeavePage clickCancelLeave() {
        clickWhenReady(CANCEL_BTN);
        return this;
    }

    public LeavePage clickViewDetails() {
        clickWhenReady(VIEW_DETAILS_BTN);
        return this;
    }

    public LeavePage clickAddComment() {
        clickWhenReady(ADD_COMMENT_BTN);
        return this;
    }

    public LeavePage clickSave() {
        save();
        return this;
    }

    public LeavePage verifyElementVisible(String elementText) {
        super.verifyElementVisible(elementText);
        return this;
    }

    public LeavePage verifyTextContain(By locator, String expectedText) {
        super.verifyTextContain(locator, expectedText);
        return this;
    }
}

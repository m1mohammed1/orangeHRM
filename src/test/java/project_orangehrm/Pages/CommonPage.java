package project_orangehrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project_orangehrm.Base.BasePage;

public class CommonPage extends BasePage {

    private final By PAGE_HEADER = By.cssSelector(".oxd-topbar-header-title");
    private final By PAGE_TITLE = By.tagName("h6");
    private final By SEARCH_FILTER = By.cssSelector(".oxd-table-filter");
    private final By SUBMIT_BTN = By.cssSelector("button[type='submit']");
    private final By RESET_BTN = By.xpath("//button[normalize-space()='Reset']");
    private final By ADD_BTN = By.xpath("//button[normalize-space()='Add']");
    private final By SAVE_BTN = By.xpath("//button[normalize-space()='Save']");
    private final By CANCEL_BTN = By.xpath("//button[normalize-space()='Cancel']");
    private final By CONFIRM_DELETE_BTN = By.xpath("//div[@class='orangehrm-modal-footer']//button[normalize-space()='Yes, Delete']");
    private final By OK_BTN = By.xpath("//button[normalize-space()='Ok']");
    private final By CONFIRM_BTN = By.xpath("//button[normalize-space()='Confirm']");
    private final By SUCCESS_TOAST = By.xpath("//div[contains(@class, 'oxd-toast--success')]");
    private final By INFO_TOAST = By.xpath("//div[contains(@class, 'oxd-toast--info')]");
    private final By ERROR_TOAST = By.xpath("//div[contains(@class, 'oxd-toast--error')]");
    private final By TOGGLE_SWITCH = By.xpath("//span[contains(@class, 'oxd-switch-input')]");
    private final By EDIT_SWITCH_BTN = By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-left']");
    private final By PLUS_BTN = By.xpath("//button[normalize-space()='+']");
    private final By FILE_INPUT = By.cssSelector("input[type='file']");
    private final By DIALOG_SHEET = By.cssSelector(".oxd-dialog-sheet");
    private final By DIALOG_CLOSE = By.cssSelector(".oxd-dialog-close-button");
    private final By DYNAMIC_BTN = By.xpath("//button[normalize-space()='%s']");



    private final String DYNAMIC_PLUS_BTN = "//div[contains(@class, 'oxd-grid-item') and .//label[contains(normalize-space(), '%s')]]//button[@type='button']";
    private final String DYNAMIC_TOGGLE_SWITCH = "//label[contains(., '%s')]/parent::div/following-sibling::div//span[contains(@class, 'oxd-switch-input')]";
    private final String SIDE_MENU_ITEM = "//a[contains(@class,'oxd-main-menu-item')]/span[text()='%s']";
    private final String TOP_BAR_MENU = "//nav[@aria-label='Topbar Menu']//li[contains(normalize-space(), '%s')]";
    private final String DROPDOWN_MENU = "//ul[@role='menu']//a[contains(normalize-space(), '%s')]";
    private final String DYNAMIC_FIELD = "//label[normalize-space()='%s']/../following-sibling::div//input";
    private final String DYNAMIC_DROPDOWN = "//label[normalize-space()='%s']/../following-sibling::div//div[contains(@class,'oxd-select-text')]";
    private final String DYNAMIC_OPTION = "//div[@role='listbox']//span[contains(normalize-space(), '%s')]";
    private final String DYNAMIC_TEXTAREA = "//label[normalize-space()='%s']/../following-sibling::div//textarea";
    private final String DYNAMIC_ERROR_MSG = "//label[normalize-space()='%s']/ancestor::div[contains(@class,'oxd-input-group')]//span";
    private final String DYNAMIC_CHECKBOX = "//label[contains(text(),'%s')]/following-sibling::span[contains(@class,'oxd-checkbox')]";
    private final String DYNAMIC_TABLE_RECORD = "//div[@role='row']//div[normalize-space()='%s']";
    private final String DYNAMIC_SUBSCRIBE_BTN = "//div[normalize-space()='%s']/ancestor::div[@role='row']//button[i[contains(@class, 'bi-person')]]";
    private final String DYNAMIC_EDIT_BTN = "//div[contains(text(),'%s')]/ancestor::div[@role='row']//button[i[contains(@class, 'bi-pencil')]]";
    private final String DYNAMIC_RADIO_BTN = "//label[contains(., '%s')]//span[contains(@class, 'oxd-radio-input')]";
    private final String DYNAMIC_DELETE_BTN = "//div[contains(text(),'%s')]/ancestor::div[@role='row']//button[i[contains(@class, 'bi-trash')]]";
    private final String DYNAMIC_UNIT_DELETE_BTN = "//div[normalize-space()='%s']/ancestor::div[contains(@class, 'oxd-tree-node-content')]//button[i[contains(@class, 'bi-trash')]]";
    private final String DYNAMIC_ROW_INPUT = "//p[contains(text(), '%s')]/ancestor::div[@role='row']//input";
    private final String DYNAMIC_SIDE_TAB = "//div[@role='tablist']//a[contains(normalize-space(), '%s')]";
    private final String DYNAMIC_ACTION_BTN = "//div[normalize-space()='%s']/ancestor::div[@role='row']//button[i[contains(@class, 'bi-eye')]]";
    private final String DYNAMIC_LINK = "//a[contains(text(), '%s')]";
    private final String DYNAMIC_WIDGET = "//p[normalize-space()='%s']";

    public CommonPage(WebDriver driver) {
        super(driver);
    }


    public void navigateToModule(String moduleName) {
        clickWhenReady(By.xpath(String.format(SIDE_MENU_ITEM, moduleName)));
    }

    public CommonPage navigateToSection(String mainCategory, String subCategory) {
        clickWhenReady(By.xpath(String.format(TOP_BAR_MENU, mainCategory)));
        clickWhenReady(By.xpath(String.format(DROPDOWN_MENU, subCategory)));
        return this;
    }

    public CommonPage navigateToSection(String mainCategory) {
        clickWhenReady(By.xpath(String.format(TOP_BAR_MENU, mainCategory)));
        return this;
    }

    public void typeInField(String fieldName, String text) {
        typeText(By.xpath(String.format(DYNAMIC_FIELD, fieldName)), text);
    }

    public void typeInTextArea(String fieldName, String text) {
        typeText(By.xpath(String.format(DYNAMIC_TEXTAREA, fieldName)), text);
    }

    public void type(By locator, String text) {
        WebElement field = fluentWait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(locator));
        field.click();
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        field.sendKeys(Keys.BACK_SPACE);
        field.clear();
        field.sendKeys(text);
    }


    public void selectDropdownOption(String dropdownName, String visibleText) {
        clickWhenReady(By.xpath(String.format(DYNAMIC_DROPDOWN, dropdownName)));
        clickWhenReady(By.xpath(String.format(DYNAMIC_OPTION, visibleText)));
    }

    public void selectOption(String visibleText) {
        clickWhenReady(By.xpath(String.format(DYNAMIC_OPTION, visibleText)));
    }

    public void selectFirstOption() {
        clickWhenReady(By.xpath("//div[@role='listbox']//span"));
    }

    public void save() {
        clickWhenReady(SAVE_BTN);
    }

    public void ok() {
        clickWhenReady(OK_BTN);
    }

    public void add() {
        clickWhenReady(ADD_BTN);
    }

    public void reset() {
        clickWhenReady(RESET_BTN);
    }

    public void submit() {
        clickWhenReady(SUBMIT_BTN);
    }

    public void clickTab(String tabName) {
        clickWhenReady(By.xpath(String.format(DYNAMIC_SIDE_TAB, tabName)));
    }

    public void clickDynamic(String value) {
        clickWhenReady(DYNAMIC_BTN);
    }

    public void clickRadio(String value) {
        clickWhenReady(By.xpath(String.format(DYNAMIC_RADIO_BTN,value)));
    }

    public void clickSubscribe(String value) {
        clickWhenReady(By.xpath(String.format(DYNAMIC_SUBSCRIBE_BTN,value)));
    }

    public void clickAction(String value) {
        clickWhenReady(By.xpath(String.format(DYNAMIC_ACTION_BTN, value)));
    }

    public void clickOnCheckbox(String labelText) {
        clickWhenReady(By.xpath(String.format(DYNAMIC_CHECKBOX, labelText)));
    }

    public void cancel() {
        clickWhenReady(CANCEL_BTN);
    }

    public void confirm() {
        clickWhenReady(CONFIRM_BTN);
    }

    public void dynamicPlusBtn(String value) {
        clickWhenReady(By.xpath(String.format(DYNAMIC_PLUS_BTN, value)));
    }

    public void toggle() {
        clickWhenReady(TOGGLE_SWITCH);
    }

    public void dynamicToggle(String value) {
        clickJS(By.xpath(String.format(DYNAMIC_TOGGLE_SWITCH,value)));
    }

    public void toggleEdit() {
        clickWhenReady(EDIT_SWITCH_BTN);
    }

    public void edit(String value) {
        clickWhenReady(By.xpath(String.format(DYNAMIC_EDIT_BTN, value)));
    }

    public void delete(String value) {
        clickWhenReady(By.xpath(String.format(DYNAMIC_DELETE_BTN, value)));
        clickWhenReady(CONFIRM_DELETE_BTN);
    }

    public void deleteUnit(String value) {
        clickWhenReady(By.xpath(String.format(DYNAMIC_UNIT_DELETE_BTN, value)));
        clickWhenReady(CONFIRM_DELETE_BTN);
    }

    public void clickRecord(String recordName) {
        clickWhenReady(By.xpath(String.format(DYNAMIC_TABLE_RECORD, recordName)));
    }

    public void clickLink(String linkText) {
        clickWhenReady(By.xpath(String.format(DYNAMIC_LINK, linkText)));
    }

    public void setRowValue(String rowIdentifier, String value) {
        driver.findElement(By.xpath(String.format(DYNAMIC_ROW_INPUT, rowIdentifier))).sendKeys(value);
    }

    public void enterDate(String fieldName, String dateValue) {
        typeInField(fieldName, dateValue);
    }

    public void upload(String filePath) {
        driver.findElement(FILE_INPUT).sendKeys(filePath);
    }

    public void verifyDashboard(String expectedHeader) {
        assertTextContain(PAGE_HEADER, expectedHeader);
    }

    public void verifyHeader(String expectedHeader) {
        assertTextContain(PAGE_HEADER, expectedHeader);
    }

    public void verifyTitle(String expectedTitle) {
        assertTextContain(PAGE_TITLE, expectedTitle);
    }

    public CommonPage verifyElementVisible(String elementText) {
        assertVisible(By.xpath(String.format(DYNAMIC_WIDGET, elementText)),
                "Element '" + elementText + "' is not visible");
        return this;
    }

    public CommonPage verifyTextContain(By locator, String expectedText) {
        assertTextContain(locator, expectedText);
        return this;
    }

    public void verifySuccessToast() {
        assertVisible(SUCCESS_TOAST, "Success message (Toast) is not displayed");
    }

    public void verifyInfoToast() {
        assertVisible(INFO_TOAST, "Info message (Toast) is not displayed");
    }

    public void verifyErrorToast() {
        assertVisible(ERROR_TOAST, "Error message (Toast) is not displayed");
    }

    public void verifyRecordVisible(String recordName) {
        assertVisible(By.xpath(String.format(DYNAMIC_TABLE_RECORD, recordName)),
                "Record '" + recordName + "' was not found in the table.");
    }

    public void verifyRecordNotVisible(String recordName) {
        assertNotVisible(By.xpath(String.format(DYNAMIC_TABLE_RECORD, recordName)),
                "Record '" + recordName + "' is still visible after deletion.");
    }

    public void verifyFieldError(String fieldName) {
        assertVisible(By.xpath(String.format(DYNAMIC_ERROR_MSG, fieldName)),
                "Validation error for field '" + fieldName + "' is not displayed.");
    }

    public void verifyFilterVisible() {
        assertVisible(SEARCH_FILTER, "Search table is not visible");
    }

    public void verifyDialogText(String expectedText) {
        assertTextContain(DIALOG_SHEET, expectedText);
    }

    public boolean isElementVisible(String elementText) {
        try {
            return driver.findElement(By.xpath(String.format(DYNAMIC_WIDGET, elementText))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void dismissDialog() {
        clickWhenReady(DIALOG_CLOSE);
    }

    public void clickWhenReady(By locator) {
        super.clickWhenReady(locator);
    }

    public void clickWithScrollJS(By locator) {
        super.clickWithScrollJS(locator);
    }
}

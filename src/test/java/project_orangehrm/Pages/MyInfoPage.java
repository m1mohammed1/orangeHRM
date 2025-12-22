package project_orangehrm.Pages;

import org.openqa.selenium.WebDriver;


public class MyInfoPage extends CommonPage {

    public MyInfoPage(WebDriver driver) {
        super(driver);
    }

    public MyInfoPage verifyMyInfoPage(String expectedHeader) {
        verifyHeader(expectedHeader);
        return this;
    }

    public MyInfoPage navigateToSection(String mainCategory, String subCategory) {
        super.navigateToSection(mainCategory, subCategory);
        return this;
    }

    public MyInfoPage typeInDynamicField(String fieldName, String text) {
        typeInField(fieldName, text);
        return this;
    }

    public MyInfoPage typeInDynamicTextArea(String fieldName, String text) {
        typeInTextArea(fieldName, text);
        return this;
    }

    public MyInfoPage clickAndSelectDropdown(String dropdownName, String visibleText) {
        selectDropdownOption(dropdownName, visibleText);
        return this;
    }

    public MyInfoPage clickSave() {
        save();
        return this;
    }

    public MyInfoPage clickSideTab(String tabName) {
        clickTab(tabName);
        return this;
    }

    public MyInfoPage verifySuccessMessage() {
        verifySuccessToast();
        return this;
    }

    public MyInfoPage verifyFieldErrorMessage(String fieldName) {
        verifyFieldError(fieldName);
        return this;
    }
}

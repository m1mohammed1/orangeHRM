package project_orangehrm.Pages;

import org.openqa.selenium.WebDriver;


public class DirectoryPage extends CommonPage {

    public DirectoryPage(WebDriver driver) {
        super(driver);
    }

    public DirectoryPage verifyDirectoryPage(String expectedHeader) {
        verifyHeader(expectedHeader);
        return this;
    }

    public DirectoryPage navigateToSection(String mainCategory, String subCategory) {
        super.navigateToSection(mainCategory, subCategory);
        return this;
    }

    public DirectoryPage typeInDynamicField(String fieldName, String text) {
        typeInField(fieldName, text);
        return this;
    }

    public DirectoryPage clickAndSelectDropdown(String dropdownName, String visibleText) {
        selectDropdownOption(dropdownName, visibleText);
        return this;
    }

    public DirectoryPage selectFromList() {
        selectFirstOption();
        return this;
    }

    public DirectoryPage searchUser() {
        submit();
        return this;
    }

    public DirectoryPage verifySearchTable() {
        verifyFilterVisible();
        return this;
    }
}

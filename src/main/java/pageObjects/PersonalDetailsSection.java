package pageObjects;

import driverActions.Driver;
import org.openqa.selenium.Keys;
import webElement.CoreWebElement;

public class PersonalDetailsSection extends PIMPage{
    public PersonalDetailsSection(Driver driver) {
        super(driver);
    }

    private CoreWebElement employeeDetailsNavigation(String option){
        return driver.findElementByXpath("//div[@class='orangehrm-edit-employee']//div[normalize-space()='%s']", option);
    }

    private CoreWebElement dropdownByLabel(String label){
        return driver.findElementByXpath("//label[normalize-space()='%s']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']", label);
    }

    private CoreWebElement errorMessageByLabel(String label){
        return driver.findElementByXpath("//label[normalize-space()='%s']/parent::div/following-sibling::span", label);
    }
    public PersonalDetailsSection selectDetailsPart(String option){
        employeeDetailsNavigation(option).click();
        return this;
    }

    public PersonalDetailsSection setText(String label, String value) {
        inputByLabelName(label).setText(value);
        inputByLabelName(label).sendKeyboard(Keys.TAB);
        return this;
    }

    public PersonalDetailsSection selectOptionByLabel(String label, String value) {
        dropdownByLabel(label).setTextByJs(value);
        dropdownByLabel(label).sendKeyboard(Keys.TAB);
        return this;
    }


    public PersonalDetailsSection verifyErrorMessageByLabel(String label, String expectedMessage) {
        driver.verifyEqual(errorMessageByLabel(label), expectedMessage);
        return this;
    }
}

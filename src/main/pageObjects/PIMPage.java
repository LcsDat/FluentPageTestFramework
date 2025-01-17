package pageObjects;

import commons.GlobalConstant;
import driverActions.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import webElement.CoreWebElement;

import java.util.List;

public class PIMPage extends WebPageTopbarBodySection {

    private TableSection tableSection;

    public PIMPage(Driver driver) {
        super(driver);
        tableSection = new TableSection(driver);
    }

    public PIMPage setTextToField(String labelName, String value) {
        inputByLabelName(labelName).setText(value);
        return this;
    }

    private CoreWebElement addButton() {
        return driver.findElementByXpath("//button[normalize-space()='Add']");
    }

    private CoreWebElement employeeNameFieldsInput(String nameField) {
        return driver.findElementByName(nameField);
    }

    private CoreWebElement otherFieldsInput(String nameField) {
        return driver.findElementByXpath(String.format("//label[text()='%s']/parent::div/following-sibling::div/input", nameField));
    }

    private CoreWebElement createLoginDetailsCheckbox() {
        return driver.findElementByCss("input[type='checkbox']");
    }

    private CoreWebElement createLoginDetailsButton() {
        return driver.findElementByCss("span.oxd-switch-input.--label-right");
    }

    private CoreWebElement firstNameErrorMessage() {
        return driver.findElementByXpath(
                "//input[@name='firstName']/parent::div/following-sibling::span");
    }

    private CoreWebElement lastNameErrorMessage() {
        return driver.findElementByXpath(
                "//input[@name='lastName']/parent::div/following-sibling::span");
    }

    private CoreWebElement otherFieldsErrorMessage(String nameField) {
        return driver.findElementByXpath(String.format("//label[text()='%s']/parent::div/following-sibling::span", nameField));
    }

    private CoreWebElement fileInput() {
        return driver.findElementByCss("input[type='file']");
    }

    private CoreWebElement image() {
        return driver.findElementByCss("img.employee-image");
    }

    @Step("Get the image source")
    public String getImageSource() {
        return image().getAttribute("currentSrc");
    }

    @Step("Verify First name error message")
    public PIMPage verifyFirstNameErrorMessage(String expectedErrorMessage) {
        firstNameErrorMessage().waitToBePresented();
        driver.verifyEqual(expectedErrorMessage, firstNameErrorMessage().getText());
        return this;
    }

    @Step("Verify Last name error message")
    public PIMPage verifyLastNameErrorMessage(String expectedErrorMessage) {
        lastNameErrorMessage().waitToBePresented();
        driver.verifyEqual(expectedErrorMessage, lastNameErrorMessage().getText());
        return this;
    }

    @Step("Click to button")
    public PIMPage clickToButton(String buttonName) {
        button(buttonName).click();
        return this;
    }

    public PIMPage clickToAddButton() {
        addButton().click();
        return this;
    }

    @Step("Input text related to Name fields")
    public PIMPage setTextToNameFields(String nameFields, String value) {
        employeeNameFieldsInput(nameFields).setText(value);
        employeeNameFieldsInput(nameFields).sendKeyboard(Keys.TAB);
        return this;
    }

    @Step("Input text related to other fields")
    public PIMPage setTextToOtherFields(String nameField, String value) {
        otherFieldsInput(nameField).setText(value);
        otherFieldsInput(nameField).sendKeyboard(Keys.TAB);
        return this;
    }

    public PIMPage waitForLoadingSpinnerInvisible() {
        loadingSpinner().waitToBeInvisible();
        return this;
    }

    /**
     * Click to the Create Login Details button
     *
     * @param status Set true to enable button and vice versa
     */
    public PIMPage clickCreateLoginDetails(Boolean status) {
        var checkboxStatus = createLoginDetailsCheckbox().getAttribute("_modelValue");
        if (status && checkboxStatus.equals("false")) {
            createLoginDetailsButton().click();
            System.out.println("Enable Create Login Details");
        }
        if (!status && checkboxStatus.equals("true")) {
            createLoginDetailsButton().click();
            System.out.println("Disable Create Login Details");
        }

        return this;
    }

    @Step("Select top bar item")
    public PIMPage selectTopBarItem(String itemName) {
        topBarName(itemName).click();
        return this;
    }

    @Step("Verify other fields error message")
    public PIMPage verifyOtherFieldsErrorMessage(String nameField, String expectedErrorMessage) {
        driver.verifyEqual(otherFieldsErrorMessage(nameField).getText(), expectedErrorMessage);
        return this;
    }

    private List<CoreWebElement> columnHeader(String headerName) {
        return driver.findElementsByXpath("//div[text()='%s']/preceding::div[@role='columnheader']", headerName);
    }

    private CoreWebElement rowById(String employeeId) {
        return driver.findElementByXpath("//div[text()='%s']", employeeId);
    }

    public PIMPage verifyEmployeeInfoInTableById(String id, String headerName, String expectedValue) {
        String idRow = "//div[text()='%s']";

        for (int i = 2; i <= tableSection.getTotalPage(); i++) {
            var baseElement = driver.findElementsByXpath(idRow, id);
            if (baseElement.isEmpty()) tableSection.clickPage(i);
            else break;
        }
        var verifyText = tableSection.getCellText(id, headerName);
        driver.verifyEqual(expectedValue, tableSection.getCellText(id, headerName));

        return this;
    }

    @Step("Upload image")
    public PIMPage uploadImage(String filePath) {
        fileInput().uploadFile(filePath);

        return this;
    }

    @Step("Only one contract file is used, so we need to check if a contract is already uploaded or not." +
            "Also, need to check if the existed contract is to the new contract." +
            "In this case, to differentiate, the contract name should be different")
    public PIMPage uploadContractDetails(String filePath) {
        var splitPath = filePath.split("\\\\");
        var newContractName = splitPath[splitPath.length - 1];
        var contractInput = driver.findElementsByXpath("//label[text()='Contract Details']/parent::div/following-sibling::div/input");
        if (!contractInput.isEmpty()){
            fileInput().uploadFile(filePath);
        } else {
            var replaceOption = driver.findElementByXpath("//label[string()='Replace Current']/span");
            replaceOption.click();
            fileInput().uploadFile(filePath);
        }
        return this;
    }

    public PIMPage verifyImageDisplayed() {
        Assert.assertTrue(image().isDisplayed());
        return this;
    }

    public PIMPage selectEmployeeById(String employeeId) {
        rowById(employeeId).click();
        return this;
    }

    public PersonalDetailsSection getPersonalDetails() {
        return new PersonalDetailsSection(driver);
    }

    public void findEmployeeById(String employeeId) {
        String idRow = "//div[text()='%s']/parent::div/following-sibling::div[7]//button[2]";

        for (int i = 2; i <= tableSection.getTotalPage(); i++) {
            var baseElement = driver.findElementsByXpath(idRow, employeeId);
            if (baseElement.isEmpty()) tableSection.clickPage(i);
            else {
//                baseElement.get(0).scrollByJs();
                baseElement.get(0).moveToElement();
                baseElement.get(0).click();
                break;
            }
        }

    }

    private CoreWebElement dropdownOption(String label) {
        return driver.findElementByXpath("//label[normalize-space()='%s']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']", label);
    }

    public PIMPage setDropdown(String label, String value) {
        dropdownOption(label).setTextByJs(value);
        return this;
    }


    private CoreWebElement employmentContractDetailsCheckbox() {
        return driver.findElementByXpath("//p[normalize-space()='Include Employment Contract Details']/following-sibling::div");
    }

    /**
     * Click to the EmploymentContractDetails button
     *
     * @param status Set true to enable button and vice versa
     */
    public PIMPage clickEmploymentContractDetails(Boolean status) {
        var checkboxStatus = driver.findElementByXpath("//p[normalize-space()='Include Employment Contract Details']/following-sibling::div//input").getAttribute("_modelValue");

        if (status == true) {
            if (checkboxStatus.equals("false")) {
                employmentContractDetailsCheckbox().waitToBePresented();
                employmentContractDetailsCheckbox().click();
            }
        } else {
            if (checkboxStatus.equals("true")) {
                employmentContractDetailsCheckbox().waitToBePresented();
                employmentContractDetailsCheckbox().click();
            }
        }
        return this;
    }
}

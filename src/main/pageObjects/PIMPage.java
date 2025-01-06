import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.util.List;

public class PIMPage extends WebPageTopbarBodySection {

    public PIMPage(Driver driver) {
        super(driver);
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

    private CoreWebElement button(String buttonName) {
        return driver.findElementByXpath(String.format("//button[normalize-space()='%s']", buttonName));
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
    public PIMPage selectTopbarItem(String itemName) {
        topbarItemName(itemName).click();
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

    private CoreWebElement elementFindByIdAndHeaderIndex(String id, String headerName) {
        var index = columnHeader(headerName).size() + 1;
        return driver.findElementByXpath("//div[text()='%s']//ancestor::div[@role='row']//div[@role='cell'][" + index + "]", id);
    }

    public PIMPage verifyEmployeeInfoInTableById(String id, String headerName, String expectedValue) {
        String idRow = "//div[text()='%s']";
        var table = new TableSection(driver);

        for (int i = 2; i <= table.getTotalPage(); i++) {
            var baseElement = driver.findElementsByXpath(idRow, id);
            if (baseElement.isEmpty()) table.clickPage(i);
            else break;
        }
        var verifyText = table.getCellText(id, headerName);
        driver.verifyEqual(expectedValue, table.getCellText(id, headerName));

        return this;
    }
}

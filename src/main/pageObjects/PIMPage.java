import jdk.jshell.spi.SPIResolutionException;

public class PIMPage extends WebPage {

    public PIMPage(Driver driver) {
        super(driver);
    }

    private CoreWebElement addButton() {
        return driver.findElementByXpath("//button[normalize-space()='Add']");
    }

    private CoreWebElement employeeNameFields(String nameField) {
        return driver.findElementByName(nameField);
    }

    private CoreWebElement otherFields(String nameField) {
        return driver.findElementByXpath("//label[text()='" + nameField + "']/parent::div/following-sibling::div/input");
    }

    private CoreWebElement createLoginDetailsCheckbox() {
        return driver.findElementByCss("input[type='checkbox']");
    }

    private CoreWebElement createLoginDetailsButton() {
        return driver.findElementByCss("span.oxd-switch-input.oxd-switch-input--active");
    }

    public PIMPage clickToAddButton() {
        addButton().click();
        return this;
    }

    public PIMPage setTextToNameFields(String nameFields, String value) {
        employeeNameFields(nameFields).setText(value);
        return this;
    }

    public PIMPage setTextToOtherFields(String nameField, String value) {
        otherFields(nameField).setText(value);
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
}

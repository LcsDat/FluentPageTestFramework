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
        return driver.findElementByXpath(nameField);
    }

    private CoreWebElement createLoginDetailsCheckbox(){
        return driver.findElementByCss("input[type='checkbox']");
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

    /**
     * Click to the Create Login Details button
     * @param status Set checkbox status.
     */
    public PIMPage clickCreateLoginDetails(Boolean status){
        var checkboxStatus = createLoginDetailsCheckbox().getCssProperty("checked");
        if(!status.toString().equals(checkboxStatus)){
            createLoginDetailsCheckbox().click();
        } else System.out.println("Already enable or disabled");

        return this;
    }
}

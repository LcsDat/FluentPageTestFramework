public class MyInfoPage extends WebPage {

    public MyInfoPage(Driver driver) {
        super(driver);
    }

    private CoreWebElement firstNameInput() {
        return driver.findElementByName("firstName");
    }

    private CoreWebElement middleNameInput() {
        return driver.findElementByName("middleName");
    }

    private CoreWebElement lastNameInput() {
        return driver.findElementByName("lastName");
    }

    public String getFirstNameValue() {
        return firstNameInput().getCssProperty("value");
    }

    public String getMiddleNameValue() {
        return middleNameInput().getCssProperty("value");
    }

    public String getLastNameValue() {
        return lastNameInput().getCssProperty("value");
    }
}

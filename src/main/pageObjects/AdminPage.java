import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

public class AdminPage extends WebPageTopbarBodySection {
    public AdminPage(Driver driver) {
        super(driver);
    }

    private CoreWebElement jobCurrencyDropdown() {
        return driver.findElementByCss("div.oxd-select-text-input");
    }

    /**
     * This method will schedule working hours for Employee
     * @param fromTime format should be "hh:mm a"
     * @param toTime format should be "hh:mm a"
     * @return
     */
    public AdminPage setWorkingHours(String fromTime, String toTime){
        inputByLabelName("From").setText(fromTime);
        inputByLabelName("To").setText(toTime);
        return this;}

    public AdminPage selectACurrency(String currencyCode) {
        jobCurrencyDropdown().click();
        jobCurrencyDropdown().setText(currencyCode.substring(0,1));
        while(true) {
            String currency = jobCurrencyDropdown().getText();
            if(currency.equals(currencyCode)) {
                jobCurrencyDropdown().sendKeyboard(Keys.ENTER);
                break;
            } else jobCurrencyDropdown().sendKeyboard(Keys.DOWN);
        }
        return this;
    }

    public AdminPage setTextToField(String labelName, String value) {
        inputByLabelName(labelName).setText(value);
        return this;
    }

    @Step("Click to button")
    public AdminPage clickToButton(String buttonName) {
        button(buttonName).click();
        return this;
    }

    @Step("Verify  Employee account info by username")
    public AdminPage verifyEmployeeAccountInfoInTableByUsername(String username, String headerName, String expectedValue) {
        String idRow = "//div[text()='%s']";
        var table = new TableSection(driver);

        for (int i = 2; i <= table.getTotalPage(); i++) {
            var baseElement = driver.findElementsByXpath(idRow, username);
            if (baseElement.isEmpty()) table.clickPage(i);
            else break;
        }
        var verifyText = table.getCellText(username, headerName);
        driver.verifyEqual(expectedValue, table.getCellText(username, headerName));

        return this;
    }

    @Step("Select top bar item")
    public AdminPage selectTopBarItem(String itemName) {
        topBarName(itemName).click();
        return this;
    }

    @Step("Select an item in dropdown menu")
    public AdminPage selectDropDownItemName(String itemName) {
        dropDownItemName(itemName).click();
        return this;
    }


}

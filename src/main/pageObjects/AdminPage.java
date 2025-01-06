import io.qameta.allure.Step;

public class AdminPage extends WebPageNavigationSection{
    public AdminPage(Driver driver) {
        super(driver);
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
}

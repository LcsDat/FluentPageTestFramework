public abstract class WebPageTopbarBodySection extends WebPage {
    public WebPageTopbarBodySection(Driver driver) {
        super(driver);
    }

    protected CoreWebElement topBarName(String topBarName) {
        return driver.findElementByXpath("//nav[@aria-label='Topbar Menu']//child::li[normalize-space()='" + topBarName + "']");
    }

    protected CoreWebElement dropDownItemName(String itemName) {
        return driver.findElementByXpath("//ul[@class='oxd-dropdown-menu']//a[normalize-space()='Job Titles']", itemName);
    }

    public abstract Object selectTopBarItem(String itemName);

}

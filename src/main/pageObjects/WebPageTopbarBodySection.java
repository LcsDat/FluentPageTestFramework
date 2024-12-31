public class WebPageTopbarBodySection extends WebPage {
    public WebPageTopbarBodySection(Driver driver) {
        super(driver);
    }

    protected CoreWebElement topbarItemName(String itemName) {
        return driver.findElementByXpath("//nav[@aria-label='Topbar Menu']//child::li[normalize-space()='" + itemName + "']");
    }

    public Object selectTopbarItem(String itemName){
        topbarItemName(itemName).click();
        return new Object();
    }
}

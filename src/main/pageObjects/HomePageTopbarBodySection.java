public class HomePageTopbarBodySection extends WebPage {
    public HomePageTopbarBodySection(Driver driver) {
        super(driver);
    }

    private CoreWebElement topbarItemName(String itemName) {
        return driver.findElementByXpath("//nav[@aria-label='Topbar Menu']//child::li[normalize-space()='" + itemName + "']");
    }

    public void selectTopbarItem(String itemName){
        topbarItemName(itemName).click();
    }
}

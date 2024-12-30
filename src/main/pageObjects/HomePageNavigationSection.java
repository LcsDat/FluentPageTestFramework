public class HomePageNavigationSection extends WebPage {
    public HomePageNavigationSection(Driver driver) {
        super(driver);
    }

    private CoreWebElement pageOptions(String pages) {

        return driver.findElementByXpath("//nav[@aria-label='Sidepanel']//child::span[text()='" + pages + "']");
    }

    public void selectPage(String pages) {
        pageOptions(pages).click();
    }
}

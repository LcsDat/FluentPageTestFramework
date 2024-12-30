public class HomePageNavigationSection extends WebPage{
    public HomePageNavigationSection(Driver driver) {
        super(driver);
    }

    private CoreWebElement pageOptions(String pages){
        return driver.findElementByXpath(pages);
    }

    public void selectPage(String pages){
        pageOptions(pages).click();
    }
}

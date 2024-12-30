public class HomePage extends WebPage {

    private static final String DASHBOARD_HEADER = "//h6";
    private static final String ADMIN_MENU_OPTION = "//span[text()='Admin']";

    private CoreWebElement dashboardHeader() {
        return driver.findElementByXpath("//h6");
    }

    private CoreWebElement adminMenuOption() {
        return driver.findElementByXpath("//span[text()='Admin']");
    }

    public HomePage(Driver driver) {
        super(driver);
    }

    public HomePage verifyDashboardDisplayed() {
        driver.verifyTrue(dashboardHeader().isDisplayed());
        return this;
    }

    public HomePage clickAdminMenuOption() {
        adminMenuOption().click();
        return this;
    }

    public HomePageNavigationSection getNavigationSection() {
        return new HomePageNavigationSection(driver);
    }

    public HomePageTopbarBodySection getTopBarSection() {
        return new HomePageTopbarBodySection(driver);
    }
}

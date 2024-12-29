public class HomePage extends BasePage{

    private static final String DASHBOARD_HEADER = "//h6";
    private static final String ADMIN_MENU_OPTION = "//span[text()='Admin']";

    public HomePage(Driver driver, CoreVerification coreVerification) {

        super(driver,coreVerification);
    }

    public HomePage verifyDashboardDisplayed() {
        coreVerification.verifyTrue(driver.findElement(Locator.XPATH, DASHBOARD_HEADER).isDisplayed());
        System.out.println("pass dashboard page");
        return this;
    }

    public HomePage clickAdminMenuOption() {
        driver.findElement(Locator.XPATH, ADMIN_MENU_OPTION).click();
        return this;
    }
}

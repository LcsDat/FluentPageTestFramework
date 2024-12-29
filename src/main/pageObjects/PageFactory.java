public class PageFactory {
    private static PageFactory pageFactory;
//    private Driver driver;

    private PageFactory() {
    }
//    public PageFactory(Driver driver){this.driver = driver;}

    public static synchronized PageFactory getInstance() {
        if (pageFactory == null) {
            pageFactory = new PageFactory();
        }
        return pageFactory;
    }

    public LoginPage getLoginPage(Driver driver, CoreVerification coreVerification) {
        return new LoginPage(driver, coreVerification);
    }

    public HomePage getHomePage(Driver driver, CoreVerification coreVerification) {
        return new HomePage(driver, coreVerification);
    }
}

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

    public LoginPage getLoginPage(Driver driver) {
        return new LoginPage(driver);
    }

    public HomePage getHomePage(Driver driver) {
        return new HomePage(driver);
    }

    public PIMPage getPimPage(Driver driver){
        return new PIMPage(driver);
    }
}

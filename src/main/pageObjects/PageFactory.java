public class PageFactory {
    private static PageFactory pageFactory;

    public static PageFactory getInstance(){
        if(pageFactory == null){
            pageFactory = new PageFactory();
        }
        return pageFactory;
    }

    public LoginPage getLoginPage(Driver driver){
        return new LoginPage(driver);
    }
}

public class WebPage<WebT extends WebPage> {
    protected Driver driver;

    public WebPage(Driver driver) {
        this.driver = driver;
    }

    protected CoreWebElement loadingSpinner(){
        return driver.findElementByCss("div.oxd-loading-spinner");
    }

}

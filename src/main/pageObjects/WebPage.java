public abstract class WebPage {
    protected Driver driver;

    public WebPage(Driver driver) {
        this.driver = driver;
    }

    protected CoreWebElement loadingSpinner() {
        return driver.findElementByCss("div.oxd-loading-spinner");
    }

    protected CoreWebElement successfullSaveMessage() {
        return driver.findElementByCss("p.oxd-text--toast-message");
    }

    public WebPageNavigationSection getNavigationSection() {
        return new WebPageNavigationSection(driver);
    }

    public TableSection getTableSection() {
        return new TableSection(driver);
    }


}

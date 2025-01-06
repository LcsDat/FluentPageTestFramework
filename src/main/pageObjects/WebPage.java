import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

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

    @Step("Use Navigation menu")
    public WebPageNavigationSection getNavigationSection() {
        return new WebPageNavigationSection(driver);
    }

    public TableSection getTableSection() {
        return new TableSection(driver);
    }

}

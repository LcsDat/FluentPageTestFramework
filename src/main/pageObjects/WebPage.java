package pageObjects;

import driverActions.Driver;
import io.qameta.allure.Step;
import webElement.CoreWebElement;

public abstract class WebPage {
    protected Driver driver;

    public WebPage(Driver driver) {
        this.driver = driver;
    }

    protected CoreWebElement button(String buttonName) {
        return driver.findElementByXpath(String.format("//button[normalize-space()='%s']", buttonName));
    }

    protected CoreWebElement loadingSpinner() {
        return driver.findElementByCss("div.oxd-loading-spinner");
    }

    protected CoreWebElement successfullSaveMessage() {
        return driver.findElementByCss("p.oxd-text--toast-message");
    }

    protected CoreWebElement inputByLabelName(String labelName) {
        return driver.findElementByXpath("//label[normalize-space()='%s']/parent::div/following-sibling::div//input", labelName);
    }

    @Step("Use Navigation menu")
    public WebPageNavigationSection getNavigationSection() {
        return new WebPageNavigationSection(driver);
    }

    public TableSection getTableSection() {
        return new TableSection(driver);
    }

}

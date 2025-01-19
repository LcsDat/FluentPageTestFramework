package pageObjects;

import driverActions.Driver;
import io.qameta.allure.Step;
import webElement.CoreWebElement;

public class WebPageNavigationSection extends WebPage {
    public WebPageNavigationSection(Driver driver) {
        super(driver);
    }

    private CoreWebElement pageOptions(String pages) {

        return driver.findElementByXpath("//nav[@aria-label='Sidepanel']//child::span[text()='" + pages + "']");
    }

    @Step("Select a page")
    public void selectPage(String pages) {
        pageOptions(pages).click();
    }
}

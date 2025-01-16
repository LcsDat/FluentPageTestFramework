package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementFindingStrategy {

    public static By getById(String locatorValue) {
        return By.id(locatorValue);
    }

    public static By getByName(String locatorValue) {
        return By.name(locatorValue);
    }

    public static By getByClassname(String locatorValue) {
        return By.className(locatorValue);
    }

    public static By getByXpath(String locatorValue) {
        return By.xpath(locatorValue);
    }

    public static By getByCss(String locatorValue) {
        return By.cssSelector(locatorValue);
    }
}

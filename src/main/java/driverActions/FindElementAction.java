package driverActions;

import org.openqa.selenium.By;
import webElement.CoreWebElement;

import java.util.List;

public interface FindElementAction {
    By getBy(Locator locatorStrategy, String locatorValue);
    CoreWebElement findElement(Locator locatorStrategy, String locatorValue);
    List<CoreWebElement> findElements(Locator locatorStrategy, String locatorValue);
}

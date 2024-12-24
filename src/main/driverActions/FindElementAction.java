import org.openqa.selenium.By;

public interface FindElementAction {
    By getByLocator(Locator locatorStrategy, String locatorValue);
}

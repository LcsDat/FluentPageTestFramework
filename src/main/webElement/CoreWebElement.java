import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CoreWebElement implements ElementAction, Wait {
    private WebElement webElement;
    private WebDriver driver;

    public CoreWebElement(WebDriver webDriver, WebElement webElement, Locator locator, String locatorValue) {
        this.webElement = webElement;
        this.driver = webDriver;
    }

    @Override
    public void click() {
        webElement.click();
    }

    @Override
    public void setText(String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    @Override
    public String getAttribute(String attributeValue) {
        return webElement.getDomAttribute(attributeValue);
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

}

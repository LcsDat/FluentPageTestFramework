import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoreWebElement implements ElementAction, Wait {
    private WebElement webElement;
    private WebDriver webDriver;
    private By by;

    public CoreWebElement(WebDriver webDriver,WebElement webElement, By by) {
        this.webDriver = webDriver;
        this.webElement = webElement;
        this.by = by;
    }

    @Override
    public void click() {
        waitToClick();
        webElement.click();
    }

    @Override
    public void setText(String text) {
        webElement.clear();
        if(!webElement.getAttribute("value").isEmpty()) {
            webElement.sendKeys(Keys.CONTROL + "a");
            webElement.sendKeys(Keys.DELETE);
        }
        webElement.sendKeys(text);
    }

    /**
     * Get the attribute value of the element, which is properties tab of Dev tool.
     * Some will return null.
     * @param attributeValue the property name
     * @return
     */
    @Override
    public String getAttribute(String attributeValue) {
        return webElement.getAttribute(attributeValue);
    }

    @Override
    public String getCssProperty(String cssValue) {
        return webElement.getCssValue(cssValue);
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public void waitToClick() {
        new WebDriverWait(webDriver, GlobalConstant.LONG_DURATION).until(ExpectedConditions.elementToBeClickable(by));
    }

    @Override
    public void waitToBePresented() {
        new WebDriverWait(webDriver, GlobalConstant.LONG_DURATION).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @Override
    public void waitToBeInvisible() {
        new WebDriverWait(webDriver, GlobalConstant.LONG_DURATION).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}

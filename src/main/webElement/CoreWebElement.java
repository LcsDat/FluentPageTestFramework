import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoreWebElement implements ElementAction, Wait, jsExecutorAction {
    private WebElement webElement;
    private WebDriver webDriver;
    private By by;
    private JavascriptExecutor javascriptExecutor;

    public CoreWebElement(WebDriver webDriver,WebElement webElement, By by) {
        this.webDriver = webDriver;
        this.webElement = webElement;
        this.by = by;
        this.javascriptExecutor = (JavascriptExecutor) webDriver;
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

    public void sendKeyboard(Keys keys){
        webElement.sendKeys(keys);
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
    public void uploadFile(String filePath) {
        webElement.sendKeys(filePath);
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
        new WebDriverWait(webDriver, GlobalConstant.LONG_DURATION).until(ExpectedConditions.invisibilityOf(webElement ));
    }

    @Override
    public void setTextByJs(String value) {
        System.out.println(webElement.getAttribute("innerText"));
        javascriptExecutor.executeScript("arguments[0].innerText = '" + value + "'", webElement);
    }
}

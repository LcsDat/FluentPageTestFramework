package driverActions;

import assertions.Verification;
import commons.GlobalConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import webElement.CoreWebElement;
import webElement.ElementFindingStrategy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Driver implements FindElementAction, Navigation, Options, Control, Verification {
    public WebDriver getWebDriver() {
        return webDriver;
    }

    private WebDriver webDriver;

    private static Driver driver;

    private Driver() {
    }

    public static synchronized Driver getInstance() {
        if (driver == null) driver = new Driver();
        return driver;
    }


    public By getBy(Locator locatorStrategy, String locatorValue) {
        By by;
        switch (locatorStrategy) {
            case NAME -> by = By.name(locatorValue);
            case ID -> by = By.id(locatorValue);
            case ClASSNAME -> by = By.className(locatorValue);
            case CSS -> by = By.cssSelector(locatorValue);
            case XPATH -> by = By.xpath(locatorValue);
            default -> throw new NoSuchElementException("Invalid value");
        }
        return by;
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    @Override
    public CoreWebElement findElement(Locator locatorStrategy, String locatorValue) {
        var nativeElement = webDriver.findElement(getBy(locatorStrategy, locatorValue));

        return new CoreWebElement(webDriver, nativeElement, getBy(locatorStrategy, locatorValue));
    }

    public CoreWebElement findElementById(String locatorValue) {
        var idStrategy = ElementFindingStrategy.getById(locatorValue);
        var nativeElement = webDriver.findElement(idStrategy);

        return new CoreWebElement(webDriver, nativeElement, idStrategy);
    }

    public CoreWebElement findElementByName(String locatorValue) {
        var nameStrategy = ElementFindingStrategy.getByName(locatorValue);
        var nativeElement = webDriver.findElement(nameStrategy);

        return new CoreWebElement(webDriver, nativeElement, nameStrategy);
    }

    public CoreWebElement findElementByClassname(String locatorValue) {
        var classNameStrategy = ElementFindingStrategy.getByClassname(locatorValue);
        var nativeElement = webDriver.findElement(classNameStrategy);

        return new CoreWebElement(webDriver, nativeElement, classNameStrategy);
    }

    public CoreWebElement findElementByXpath(String locatorValue) {
        var xpathStrategy = ElementFindingStrategy.getByXpath(locatorValue);
        var nativeElement = webDriver.findElement(xpathStrategy);

        return new CoreWebElement(webDriver, nativeElement, xpathStrategy);
    }

    public CoreWebElement findElementByXpath(String locatorValue, String... varargs) {
        var xpathStrategy = ElementFindingStrategy.getByXpath(String.format(locatorValue, varargs));
        var nativeElement = webDriver.findElement(xpathStrategy);

        return new CoreWebElement(webDriver, nativeElement, xpathStrategy);
    }

    public CoreWebElement findElementByCss(String locatorValue) {
        var cssStrategy = ElementFindingStrategy.getByCss(locatorValue);
        var nativeElement = webDriver.findElement(cssStrategy);

        return new CoreWebElement(webDriver, nativeElement, cssStrategy);
    }

    public CoreWebElement findElementByCss(String locatorValue, String... varargs) {
        var cssStrategy = ElementFindingStrategy.getByCss(String.format(locatorValue, varargs));
        var nativeElement = webDriver.findElement(cssStrategy);

        return new CoreWebElement(webDriver, nativeElement, cssStrategy);
    }

    @Override
    public List<CoreWebElement> findElements(Locator locatorStrategy, String locatorValue) {
        var nativeElements = webDriver.findElements(getBy(locatorStrategy, locatorValue));
        var listCoreElements = new ArrayList<CoreWebElement>();
        for (var nativeElement : nativeElements) {
            listCoreElements.add(new CoreWebElement(webDriver, nativeElement, getBy(locatorStrategy, locatorValue)));
        }
        return listCoreElements;
    }

    public List<CoreWebElement> findElementsById(String locatorValue) {
        var idStrategy = ElementFindingStrategy.getById(locatorValue);
        var byIdElements = webDriver.findElements(idStrategy);
        var listCoreElements = new ArrayList<CoreWebElement>();
        for (var nativeElement : byIdElements) {
            listCoreElements.add(new CoreWebElement(webDriver, nativeElement, idStrategy));
        }
        return listCoreElements;
    }

    public List<CoreWebElement> findElementsByName(String locatorValue) {
        var nameStrategy = ElementFindingStrategy.getByName(locatorValue);
        var nativeElements = webDriver.findElements(nameStrategy);
        var listCoreElements = new ArrayList<CoreWebElement>();
        for (var nativeElement : nativeElements) {
            listCoreElements.add(new CoreWebElement(webDriver, nativeElement, nameStrategy));
        }
        return listCoreElements;
    }

    public List<CoreWebElement> findElementsByClassname(String locatorValue) {
        var classnameStrategy = ElementFindingStrategy.getByClassname(locatorValue);
        var nativeElements = webDriver.findElements(classnameStrategy);
        var listCoreElements = new ArrayList<CoreWebElement>();
        for (var nativeElement : nativeElements) {
            listCoreElements.add(new CoreWebElement(webDriver, nativeElement, classnameStrategy));
        }
        return listCoreElements;
    }

    public List<CoreWebElement> findElementsByXpath(String locatorValue) {
        var xpathStrategy = ElementFindingStrategy.getByXpath(locatorValue);
        var nativeElements = webDriver.findElements(xpathStrategy);
        var listCoreElements = new ArrayList<CoreWebElement>();
        for (var nativeElement : nativeElements) {
            listCoreElements.add(new CoreWebElement(webDriver, nativeElement, xpathStrategy));
        }
        return listCoreElements;
    }

    public List<CoreWebElement> findElementsByXpath(String locatorValue, String... varargs) {
        var xpathStrategy = ElementFindingStrategy.getByXpath(String.format(locatorValue, varargs));
        var nativeElements = webDriver.findElements(xpathStrategy);
        var listCoreElements = new ArrayList<CoreWebElement>();
        for (var nativeElement : nativeElements) {
            listCoreElements.add(new CoreWebElement(webDriver, nativeElement, xpathStrategy));
        }
        return listCoreElements;
    }

    public List<CoreWebElement> findElementsByCss(String locatorValue) {
        var cssStrategy = ElementFindingStrategy.getByCss(locatorValue);
        var nativeElements = webDriver.findElements(cssStrategy);
        var listCoreElements = new ArrayList<CoreWebElement>();
        for (var nativeElement : nativeElements) {
            listCoreElements.add(new CoreWebElement(webDriver, nativeElement, cssStrategy));
        }
        return listCoreElements;
    }

    @Override
    public void goToUrl(String URL) {
        webDriver.get(URL);
    }

    @Override
    public void setImplicitTimeout(Duration duration) {
        webDriver.manage().timeouts().implicitlyWait(duration);
    }

    @Override
    public void maximizeWindow() {
        webDriver.manage().window().maximize();
    }


    @Override
    public void startBrowser(Browser browser) {
        WebDriver driver;
        switch (browser) {
            case CHROME -> webDriver = new ChromeDriver();
            case FIREFOX -> webDriver = new FirefoxDriver();
            case EDGE -> webDriver = new EdgeDriver();
        }
        maximizeWindow();
        setImplicitTimeout(GlobalConstant.LONG_DURATION);
    }

    public void startBrowser(String browserName) {
        Browser browser = Browser.valueOf(browserName.toUpperCase());

        switch (browser) {
            case CHROME -> webDriver = new ChromeDriver();
            case FIREFOX -> webDriver = new FirefoxDriver();
            case EDGE -> webDriver = new EdgeDriver();
        }
        maximizeWindow();
        setImplicitTimeout(GlobalConstant.LONG_DURATION);
    }

    @Override
    public void close() {
        webDriver.close();
    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public void verifyTrue(boolean condition) {
        Assert.assertTrue(condition);
    }

    @Override
    public void verifyFalse(boolean condition) {
        Assert.assertFalse(condition);
    }

    @Override
    public <expectedT> void verifyEqual(expectedT actual, expectedT expected) {
        Assert.assertEquals(actual, expected);
    }

    /**
     * To verify an element undisplayed. This method will re-configure the implicit wait timeout
     * which will reduce the time returning condition, also testing run time.
     *
     * @param locatorStrategy The strategy to locate the locator
     * @param locatorValue    The locator value
     * @param implicitTimeout set the implicit timeout
     */
    public void verifyUndisplayed(Locator locatorStrategy, String locatorValue, Duration implicitTimeout) {
        boolean isDisplayed;

        try {
            webDriver.manage().timeouts().implicitlyWait(implicitTimeout);
            isDisplayed = webDriver.findElement(getBy(locatorStrategy, locatorValue)).isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }

        webDriver.manage().timeouts().implicitlyWait(GlobalConstant.LONG_DURATION);
        Assert.assertFalse(isDisplayed);
    }

    public void verifyValueInTable(List<CoreWebElement> headerElements, String locatorValue, String expectedValue, String... varargs) {
        var index = headerElements.size();
        var element = driver.findElementByXpath(locatorValue + "[" + (index + 1) + "]", varargs);
        verifyEqual(expectedValue, element.getText());

    }
}

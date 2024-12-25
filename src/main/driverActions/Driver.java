import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Driver implements FindElementAction, Navigation, Options, Control {
    private WebDriver webDriver;
    private static Driver driver;

    public static Driver getInstance() {
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

        return new CoreWebElement(webDriver, nativeElement, locatorStrategy, locatorValue);
    }

    @Override
    public List<CoreWebElement> findElements(Locator locatorStrategy, String locatorValue) {
        var nativeElements = webDriver.findElements(getBy(locatorStrategy, locatorValue));
        var listCoreElements = new ArrayList<CoreWebElement>();
        for (var nativeElement : nativeElements) {
            listCoreElements.add(new CoreWebElement(webDriver, nativeElement, locatorStrategy, locatorValue));
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
        switch (browser) {
            case CHROME -> webDriver = new ChromeDriver();
            case FIREFOX -> webDriver = new FirefoxDriver();
            case EDGE -> webDriver = new EdgeDriver();
        }
        maximizeWindow();
        setImplicitTimeout(GlobalConstant.DURATION);
    }

    @Override
    public void close() {
        webDriver.close();
    }
}

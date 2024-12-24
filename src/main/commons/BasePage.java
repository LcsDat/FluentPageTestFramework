import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BasePage implements PageActions{

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private By getByLocator(Locator strategy, String locator){
        By by = null;

//        if (strategy.equals(Locator.XPATH)) return By.xpath(locator);
//        if (strategy.equals(Locator.CSS)) return By.cssSelector(locator);
//        if (strategy.equals(Locator.ID)) return By.id(locator);
//        if (strategy.equals(Locator.ClASSNAME)) return By.className(locator);
        switch (strategy){
            case ID: {
                by = By.id(locator);
                break;
            }
            case CSS: {
                by = By.cssSelector(locator);
                break;
            }
            case XPATH: {
                by = By.xpath(locator);
                break;
            }
            case ClASSNAME:  {
                by = By.className(locator);
                break;
            }
            case NAME: {
                by = By.name(locator);
                break;
            }
            default:
                System.out.println("Invalid locator");
        }
        return by;
    }


    @Override
    public BasePage click(Locator strategy, String locator) {
        driver.findElement(getByLocator(strategy, locator)).click();
        return this;
    }

    @Override
    public BasePage setText(Locator strategy, String locator, String value) {
        driver.findElement(getByLocator(strategy, locator)).sendKeys(value);
        return this;
    }

    @Override
    public BasePage openBrowser(String url) {
        driver.get(url);
        return this;
    }

    public boolean isElementDisplay(Locator strategy, String locator){
        boolean isDisplayed;
        try {
            isDisplayed = driver.findElement(getByLocator(strategy, locator)).isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public String getElementText(Locator strategy, String locator){
        return driver.findElement(getByLocator(strategy, locator)).getText();
    }

    public BasePage clearText(Locator strategy, String locator){
        driver.findElement(getByLocator(strategy, locator)).clear();
        return this;
    }
}

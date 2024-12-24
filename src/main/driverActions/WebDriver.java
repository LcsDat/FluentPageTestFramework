import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class WebDriver extends Driver{
    private org.openqa.selenium.WebDriver webDriver;

    public WebDriver(org.openqa.selenium.WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public By getByLocator(Locator locatorStrategy, String locatorValue) {
        By by = null;
        try {
            switch (locatorStrategy){
                case ID -> by = By.id(locatorValue);

                case NAME -> by = By.name(locatorValue);

                case ClASSNAME -> by = By.className(locatorValue);

                case XPATH -> by = By.xpath(locatorValue);

                case CSS -> by = By.cssSelector(locatorValue);

            }
        } catch (NoSuchElementException e) {
            System.out.println("Invalid locator value");
        }
        return  by;
    }

    public WebElement findElement(Locator locatorStrategy, String locatorValue){
        return webDriver.findElement(getByLocator(locatorStrategy, locatorValue));
    }
}

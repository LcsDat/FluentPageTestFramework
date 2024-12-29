import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.time.Duration;

public class CoreVerification implements Verification {

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
     * @param locator The locator strategy
     * @param locatorValue The locator value
     * @param implicitTimeout set the implicit timeout
     */
    public void verifyUndisplayed(Driver driver, Locator locator, String locatorValue, Duration implicitTimeout) {
        boolean isDisplayed;

        try {
            driver.setImplicitTimeout(implicitTimeout);
            isDisplayed = driver.findElement(locator,locatorValue).isDisplayed();
        } catch (NoSuchElementException e){
            isDisplayed = false;
        }

        Assert.assertFalse(isDisplayed);
    }
}

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected Driver driver;

    @Parameters({"browser", "url"})
    @BeforeSuite
    public void beforeSuite(String browser, String URL) {
        driver = Driver.getInstance();
        driver.startBrowser(browser);
        driver.goToUrl(URL);
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }
}

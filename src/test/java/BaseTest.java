import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest extends CoreVerification{
    protected Driver driver;
//    protected PageFactory pageFactory;
//    Page page;

    @Parameters({"browser", "url"})
    @BeforeSuite
    public void beforeSuite(String browser, String URL) {
        driver = Driver.getInstance();
//        pageFactory = new PageFactory();
//        page = pageFactory.getLoginPage(driver);
//        driver = Driver.getInstance();
//        pageFactory = new PageFactory(driver);
        driver.startBrowser(browser);
        driver.goToUrl(URL);
//        loginPage = pageFactory.getLoginPage(driver);
//        homePage = pageFactory.getHomePage();
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }
}

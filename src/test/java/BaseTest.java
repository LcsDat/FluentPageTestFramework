import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import commons.FileUtil;
import commons.GlobalConstant;
import driverActions.Driver;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.AfterSuite;
import pageObjects.LoginPage;
import pageObjects.PageFactory;

import java.io.IOException;
import java.util.Locale;

public class BaseTest {
    protected Driver driver;

//    @Description("Test Suite Setup")
//    @Step("Driver initialization and URL navigation")
//    @Parameters({"browser", "url"})
//    @BeforeSuite
//    public void beforeSuite(String browser, String URL) {
//        quickAdminLogin(browser,URL);
//    }

//    @Description("Test Suite Tear down")
//    @AfterSuite(alwaysRun = true)
//    public void afterSuite() {
//
//        Allure.step("Quit all browsers");
//        killBrowserDriver();
//    }

    protected Faker gentFaker(Locale locale) {
        return new Faker(locale);
    }

    protected Faker getFaker() {
        return new Faker();
    }

    protected String getRandomString(String regex) {
        FakeValuesService fvs = new FakeValuesService(new Locale("en"), new RandomService());
        return fvs.regexify(regex);
    }

    protected FakeValuesService getFakerValueService() {
        return new FakeValuesService(new Locale("en"), new RandomService());
    }

    protected void sleepInSecond(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Step("Quick login using Admin credentials")
    protected void quickAdminLogin(String browser, String URL) {
        Allure.step("Check and clean test output folder");
        FileUtil.deleteFiles(GlobalConstant.TEST_OUTPUT_PATH);
        driver = Driver.getInstance();
        driver.startBrowser(browser);
        driver.goToUrl(URL);
        LoginPage loginPage = PageFactory.getInstance().getLoginPage(driver);
        loginPage.setTextUsername("hideyashy").setTextPassword("#Onimusha00").clickLogin();
    }

    @Step("Quick login using Admin credentials")
    protected void quickAdminLogin() {
        LoginPage loginPage = PageFactory.getInstance().getLoginPage(driver);
        loginPage.setTextUsername("hideyashy").setTextPassword("#Onimusha00").clickLogin();
    }

    @Step("Close the browser")
    protected void closeBrowser() {
        driver.close();
    }

    @Step("Kill the browser")
    protected void killBrowserDriver() {
        String cmd = null;
        try {
            String osName = GlobalConstant.OS_NAME.toLowerCase();

            String driverInstanceName = driver.getWebDriver().toString().toLowerCase();

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

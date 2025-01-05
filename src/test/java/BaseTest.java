import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.Locale;

public class BaseTest {
    protected Driver driver;

    @Parameters({"browser", "url"})
    @BeforeSuite
    public void beforeSuite(String browser, String URL) {
        FileUtil.deleteFiles(GlobalConstant.TEST_OUTPUT_PATH);
        driver = Driver.getInstance();
        driver.startBrowser(browser);
        driver.goToUrl(URL);
        quickAdminLogin();
    }

//    @AfterSuite
//    public void afterSuite() {
//        driver.close();
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

    protected void sleepInSecond(long second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    protected void quickAdminLogin(){
        LoginPage loginPage = PageFactory.getInstance().getLoginPage(driver);
        loginPage.setTextUsername("hideyashy").setTextPassword("#Onimusha00").clickLogin();
    }

}

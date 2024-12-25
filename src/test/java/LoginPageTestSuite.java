import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginPageTestSuite {
    Driver driver;
    LoginPage loginPage;

    @Parameters({"browser","url"})
    @BeforeTest
    public void beforeTest(String browser, String URL) {
        driver = Driver.getInstance();
        driver.startBrowser(browser);
        driver.goToUrl(URL);
    }

    @Test
    public void TC01_VerifyHeaderAndLogo() {
        loginPage = PageFactory.getInstance().getLoginPage(driver);

        loginPage.verifyLogoDisplayed()
                .verifyLogoTitle();
    }

    @Test
    public void TC02_LoginWhenMissingCredentials() {
        loginPage.clickLogin()
                .verifyUsernameErrorMessageInfo()
                .verifyPasswordErrorMessageInfo()
                .setTextUsername("hideyashy")
                .verifyUsernameErrorMessUndisplayed()
                .setTextPassword("hideyashy")
                .verifyPasswordErrorMessUndisplayed();
    }

    @Test
    public void TC03_LoginWithInvalidCredentials() {
        loginPage.clickLogin().verifyLoginErrorDisplayed();
    }

    @Test
    public void TC04_LoginWithValidCredentials() {
        loginPage.setTextUsername("hideyashy").setTextPassword("#Onimusha00").clickLogin();
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTestSuite {
    Driver driver;
    LoginPage loginPage;

    @BeforeTest
    public void beforeTest(){
        driver = Driver.getInstance();
        driver.startBrowser(Browser.CHROME);
        loginPage = PageFactory.getInstance().getLoginPage(driver);
    }

    @Test
    public void TC01_VerifyHeaderAndLogo() {
        driver.goToUrl("http://localhost:90");

        loginPage.verifyLogoDisplayed()
                .verifyLogoTitle();
    }

    @Test
    public void TC02_LoginWhenMissingCredentials(){
        loginPage.clickLogin()
                .verifyUsernameErrorMessageInfo()
                .verifyPasswordErrorMessageInfo()
                .setTextUsername("hideyashy")
                .verifyUsernameErrorMessUndisplayed()
                .setTextPassword("hideyashy")
                .verifyPasswordErrorMessUndisplayed();
    }

    @Test
    public void TC03_LoginWithInvalidCredentials(){
        loginPage.clickLogin().verifyLoginErrorDisplayed();
    }

    @Test
    public void TC04_LoginWithValidCredentials(){
        loginPage.setTextUsername("hideyashy").setTextPassword("#Onimusha00").clickLogin();
    }

    @AfterTest
    public void afterTest(){
        driver.close();
    }
}

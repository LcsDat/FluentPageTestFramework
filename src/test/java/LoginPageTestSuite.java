import io.qameta.allure.Step;
import org.testng.annotations.*;


public class LoginPageTestSuite extends BaseTest {
    LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        loginPage = PageFactory.getInstance().getLoginPage(driver);
    }

    @Test
    public void TC01_VerifyHeaderAndLogo() {
        loginPage.verifyLogoDisplayed()
                .verifyLogoTitle();
    }

    @Step("hello world")
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
}

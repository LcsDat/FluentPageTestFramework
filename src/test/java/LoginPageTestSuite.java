import org.testng.annotations.*;


public class LoginPageTestSuite extends BaseTest {
    //    Driver driver;
    LoginPage loginPage;
//    Page loginPage;

    @BeforeClass
    public void beforeClass() {
//        loginPage = pageFactory.getLoginPage(driver);
        loginPage = PageFactory.getInstance().getLoginPage(driver, new CoreVerification());
    }
//    @Parameters({"browser","url"})
//    @BeforeSuite
//    public void beforeTest(String browser, String URL) {
//        driver = Driver.getInstance();
//        driver.startBrowser(browser);
//        driver.goToUrl(URL);
//    }

    @Test
    public void TC01_VerifyHeaderAndLogo() {
//        loginPage = pageFactory.getLoginPage(driver);
        System.out.println("first tc in Login Suite:" + driver);
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
        System.out.println("last case in Login Suite" +driver);

    }

//    @AfterSuite
//    public void afterTest() {
//        driver.close();
//    }
}

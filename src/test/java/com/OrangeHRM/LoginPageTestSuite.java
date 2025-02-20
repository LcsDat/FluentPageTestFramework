package com.OrangeHRM;

import commons.GlobalConstant;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import pageObjects.PageFactory;


public class LoginPageTestSuite extends BaseTest {
    LoginPage loginPage;

    @Description("Page Initialization")
    @BeforeClass
    public void beforeClass() {
        loginPage = PageFactory.getInstance().getLoginPage(driver);
    }

    @Description("Login Page: Verify Header and Logo are displayed")
    @Severity(SeverityLevel.MINOR)
    @Owner(GlobalConstant.OWNER)
    @Tag("Functional") @Tag("Login")
    @Test(testName = "Login")
    public void TC01() {
        loginPage.verifyLogoDisplayed()
                .verifyLogoTitle();
    }

    @Description("Login Page: Login with invalid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Owner(GlobalConstant.OWNER)
    @Tag("Functional") @Tag("Login")
    @Test(testName = "Login")
    public void TC02() {
        Allure.step("Click login without input credentials");
        loginPage.clickLogin()
                .verifyUsernameErrorMessageInfo()
                .verifyPasswordErrorMessageInfo();

        Allure.step("Input username");
        loginPage.setTextUsername("hideyashy")
                .verifyUsernameErrorMessUndisplayed();

        Allure.step("Input password");
        loginPage.setTextPassword("hideyashy")
                .verifyPasswordErrorMessUndisplayed();
    }

    @Description("Login Page: Login with wrong password")
    @Severity(SeverityLevel.MINOR)
    @Owner(GlobalConstant.OWNER)
    @Tag("Functional") @Tag("Login")
    @Test(testName = "Login")
    public void TC03() {
        loginPage.clickLogin().verifyLoginErrorDisplayed();
    }

    @Description("Login Page: Login with valid credentials")
    @Severity(SeverityLevel.NORMAL)
    @Owner(GlobalConstant.OWNER)
    @Tag("Functional") @Tag("Login")
    @Test(testName = "Login")
    public void TC04() {
        Allure.step("Input username");
        loginPage.setTextUsername("hideyashy");
        Allure.step("Input password");
        loginPage.setTextPassword("#Onimusha00").clickLogin();
    }
}

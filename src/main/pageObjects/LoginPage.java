import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class LoginPage extends WebPage {
    private final String USERNAME_INPUT = "username";
    private final String PASSWORD_INPUT = "password";
    private final String LOGIN_BUTTON = "[type*='submit']";
    private final String ORANGE_LOGO = ".orangehrm-login-logo";
    private final String ORANGE_LOGO_TITLE = "h5";
    private final String USERNAME_ERROR_MESSAGE = "//label[text()='Username']/ancestor::div[contains(@class,'input') and contains(@class,'bottom')]/child::span";
    private final String PASSWORD_ERROR_MESSAGE = "//label[text()='Password']/ancestor::div[contains(@class,'input') and contains(@class,'bottom')]/child::span";
    private final String LOGIN_ERROR = "div[role='alert']";


    private CoreWebElement usernameInput() {
        return driver.findElementByName("username");
    }

    private CoreWebElement passwordInput() {
        return driver.findElementByName("password");
    }

    private CoreWebElement loginButton() {
        return driver.findElementByCss("[type*='submit']");
    }

    private CoreWebElement orangeHRMLogo() {
        return driver.findElementByCss(".orangehrm-login-logo");
    }

    private CoreWebElement orangeHRMLogoTitle() {
        return driver.findElementByCss("h5");
    }

    private CoreWebElement usernameErrorMessage() {
        return driver.findElementByXpath("//label[text()='Username']/ancestor::div[contains(@class,'input') and contains(@class,'bottom')]/child::span");
    }

    private CoreWebElement passwordErrorMessage() {
        return driver.findElementByXpath("//label[text()='Password']/ancestor::div[contains(@class,'input') and contains(@class,'bottom')]/child::span");
    }

    private CoreWebElement loginError() {
        return driver.findElementByCss("div[role='alert']");
    }

    public LoginPage(Driver driver) {

        super(driver);
    }

    @Step("Set text to Username")
    public LoginPage setTextUsername(String value) {
        usernameInput().setText(value);
        return this;
    }

    public LoginPage setTextPassword(String value) {
        Allure.step("Set text to Password", step -> {step.parameter("Password", "**********");});
        passwordInput().setText(value);
        return this;
    }

    @Step("Click to Login button")
    public LoginPage clickLogin() {
        loginButton().click();
        return this;
    }

    public boolean isLogoDisplayed() {
        return orangeHRMLogo().isDisplayed();
    }

    public boolean isLoginErrorDisplayed() {
        return loginError().isDisplayed();
    }

    public String getLogoTitle() {
        return orangeHRMLogoTitle().getText();
    }

    public String getUsernameErrorMessage() {
        return usernameErrorMessage().getText();
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage().getText();
    }

    @Step("Logo is displayed")
    public LoginPage verifyLogoDisplayed() {
        driver.verifyTrue(isLogoDisplayed());
        return this;
    }

    @Step("Title is displayed")
    public LoginPage verifyLogoTitle() {
        driver.verifyEqual(getLogoTitle(), "Login");
        return this;
    }

    @Step("Username is required to login")
    public LoginPage verifyUsernameErrorMessageInfo() {
        driver.verifyEqual(getUsernameErrorMessage(), "Required");
        return this;
    }

    @Step("Password is required to login")
    public LoginPage verifyPasswordErrorMessageInfo() {
        driver.verifyEqual(getPasswordErrorMessage(), "Required");
        return this;
    }

    @Step("Error message is removed when Username is filled")
    public LoginPage verifyUsernameErrorMessUndisplayed() {
        driver.verifyUndisplayed(Locator.XPATH, USERNAME_ERROR_MESSAGE, GlobalConstant.SHORT_DURATION);
        return this;
    }

    @Step("Error message is removed when Password is filled")
    public LoginPage verifyPasswordErrorMessUndisplayed() {
        driver.verifyUndisplayed(Locator.XPATH, PASSWORD_ERROR_MESSAGE, GlobalConstant.SHORT_DURATION);
        return this;
    }

    @Step("Login error is displayed")
    public LoginPage verifyLoginErrorDisplayed() {
        driver.verifyTrue(isLoginErrorDisplayed());
        return this;
    }
}

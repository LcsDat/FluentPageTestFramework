import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends Page {
    private final String USERNAME_INPUT = "username";
    private final String PASSWORD_INPUT = "password";
    private final String LOGIN_BUTTON = "[type*='submit']";
    private final String ORANGE_LOGO = ".orangehrm-login-logo";
    private final String ORANGE_LOGO_TITLE = "h5";
    private final String USERNAME_ERROR_MESSAGE = "//label[text()='Username']/ancestor::div[contains(@class,'input') and contains(@class,'bottom')]/child::span";
    private final String PASSWORD_ERROR_MESSAGE = "//label[text()='Password']/ancestor::div[contains(@class,'input') and contains(@class,'bottom')]/child::span";
    private final String LOGIN_ERROR = "div[role='alert']";


    public LoginPage(Driver driver) {
        super(driver);
    }

    public LoginPage setTextUsername(String value) {
        driver.findElement(Locator.NAME, USERNAME_INPUT).setText(value);
        return this;
    }

    public LoginPage setTextPassword(String value) {
        driver.findElement(Locator.NAME, PASSWORD_INPUT).setText(value);
        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(Locator.CSS, LOGIN_BUTTON).click();
        return this;
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(Locator.CSS, ORANGE_LOGO).isDisplayed();
    }

    public String getLogoTitle() {
        return driver.findElement(Locator.CSS, ORANGE_LOGO_TITLE).getText();
    }

    public boolean isUsernameErrorMessageDisplayed() {
        boolean isDisplayed;
        try {
            isDisplayed = driver.findElement(Locator.XPATH, USERNAME_ERROR_MESSAGE).isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public boolean isPasswordErrorMessageDisplayed() {
        boolean isDisplayed;
        try {
            isDisplayed = driver.findElement(Locator.XPATH, PASSWORD_ERROR_MESSAGE).isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public String getUsernameErrorMessage() {
        return driver.findElement(Locator.XPATH, USERNAME_ERROR_MESSAGE).getText();
    }

    public String getPasswordErrorMessage() {
        return driver.findElement(Locator.XPATH, PASSWORD_ERROR_MESSAGE).getText();
    }

    public LoginPage verifyLogoDisplayed() {
        assertTrue(driver.findElement(Locator.CSS, ORANGE_LOGO).isDisplayed());
        return this;
    }

    public LoginPage verifyLogoTitle() {
        assertEquals(getLogoTitle(), "Login");
        return this;
    }

    public LoginPage verifyUsernameErrorMessageInfo() {
        assertEquals(getUsernameErrorMessage(), "Required");
        return this;
    }

    public LoginPage verifyPasswordErrorMessageInfo() {
        assertEquals(getPasswordErrorMessage(), "Required");
        return this;
    }

    public LoginPage verifyUsernameErrorMessUndisplayed() {
        assertFalse(isUsernameErrorMessageDisplayed());
        return this;
    }

    public LoginPage verifyPasswordErrorMessUndisplayed() {
        assertFalse(isPasswordErrorMessageDisplayed());
        return this;
    }

    public LoginPage verifyLoginErrorDisplayed(){
        assertTrue(driver.findElement(Locator.CSS, LOGIN_ERROR).isDisplayed());
        return this;
    }
}

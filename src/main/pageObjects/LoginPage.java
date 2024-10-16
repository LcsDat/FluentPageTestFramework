import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage click(Locator strategy, String locator) {
        return (LoginPage) super.click(strategy,locator);
    }

    @Override
    public LoginPage setText(Locator strategy, String locator, String value) {
        return (LoginPage) super.setText(strategy, locator, value);
    }

    public LoginPage verifyBrandingIsDisplayed(Locator strategy, String locator){
        return this;
    }
}

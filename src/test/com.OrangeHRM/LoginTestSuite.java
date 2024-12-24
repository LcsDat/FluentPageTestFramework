import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTestSuite {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void TC01_VerifyHeaderAndLogo(){
        loginPage.openBrowser("http://localhost:90");
        Assert.assertTrue(loginPage.isElementDisplay(Locator.CSS,"h5"));
        Assert.assertEquals(loginPage.getElementText(Locator.CSS,"h5"),"Login");
    }

    @Test
    public void TC02_LoginWhenMissingCredentials(){
        loginPage.click(Locator.CSS,"button");
        Assert.assertEquals(loginPage.getElementText(Locator.XPATH,"//label[text()='Username']/ancestor::div[contains(@class,'input') and contains(@class,'bottom')]/child::span"),"Required");
        Assert.assertEquals(loginPage.getElementText(Locator.XPATH,"//label[text()='Password']/ancestor::div[contains(@class,'input') and contains(@class,'bottom')]/child::span"),"Required");
        loginPage.setText(Locator.NAME,"username","hideyashy");
        Assert.assertFalse(loginPage.isElementDisplay(Locator.XPATH,"//label[text()='Username']/ancestor::div[contains(@class,'input') and contains(@class,'bottom')]/child::span"));
        loginPage.setText(Locator.NAME,"password","hideyashy");
        Assert.assertFalse(loginPage.isElementDisplay(Locator.XPATH,"//label[text()='Password']/ancestor::div[contains(@class,'input') and contains(@class,'bottom')]/child::span"));
    }

    @Test
    public void TC03_LoginWithInvalidCredentials(){
        loginPage.click(Locator.CSS,"button");
        Assert.assertTrue(loginPage.isElementDisplay(Locator.CSS,"div[role='alert']"));
        Assert.assertEquals(loginPage.getElementText(Locator.CSS,"p.oxd-alert-content-text"),"Invalid credentials");
    }

    @Test
    public void TC04_LoginWithValidCredentials(){
        loginPage.clearText(Locator.NAME,"username").clearText(Locator.NAME,"password").setText(Locator.NAME,"username","hideyashy").setText(Locator.NAME,"password","#Onimusha00").click(Locator.CSS,"button");
        System.out.println("hello");
    }

//    @AfterTest
//    public void afterTest(){
//        driver.close();
//    }
}

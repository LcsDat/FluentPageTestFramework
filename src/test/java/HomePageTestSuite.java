import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTestSuite extends BaseTest{
    HomePage homePage;
//Page homePage;

    @Test
    public void demo() throws InterruptedException {
        driver = Driver.getInstance();
        homePage = PageFactory.getInstance().getHomePage(driver, new CoreVerification());
        System.out.println("after init home page: " +driver);
        homePage.verifyDashboardDisplayed().clickAdminMenuOption();
        Thread.sleep(2000);
    }
}

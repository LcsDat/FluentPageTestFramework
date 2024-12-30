import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTestSuite extends BaseTest{
    HomePage homePage;

    @BeforeClass
    public void beforeClass(){
//        driver = Driver.getInstance();
        homePage = PageFactory.getInstance().getHomePage(Driver.getInstance());
    }

    @Test
    public void TC01_Ad() throws InterruptedException {

        homePage.verifyDashboardDisplayed().clickAdminMenuOption();
        Thread.sleep(2000);
    }
}

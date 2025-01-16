import io.qameta.allure.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.PIMPage;
import pageObjects.PageFactory;
import pageObjects.PersonalDetailsSection;

public class EmployeeInfoTestSuite extends BaseTest{
    HomePage homePage;
    PIMPage pimPage;
    PersonalDetailsSection personalDetailsSection;

    @Parameters({"browser", "url"})
    @Description("Page Initialization and prepare test data")
    @BeforeClass
    public void beforeClass(String browser, String url) {
        quickAdminLogin(browser, url);
        homePage = PageFactory.getInstance().getHomePage(driver);
        pimPage = PageFactory.getInstance().getPimPage(driver);
    }

    @AfterClass
    public void beforeClass() {
        closeBrowser();
    }

    @Test
    public void TC01_Add_Job(){
        homePage.getNavigationSection().selectPage("PIM");
        pimPage.selectEmployeeById("employeeId")
                .getPersonalDetails()
                .selectDetailsPart("Job")
                .setText("Joined Date", "a")
                .verifyErrorMessageByLabel("Joined Date","Should be a valid date in yyyy-mm-dd format")
                ;

    }
}

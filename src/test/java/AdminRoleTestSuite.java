import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminRoleTestSuite extends BaseTest {
    HomePage homePage;
    PIMPage pimPage;

    @BeforeClass
    public void beforeClass() {
        homePage = PageFactory.getInstance().getHomePage(Driver.getInstance());
    }

    @Test
    public void TC01_Create_Employee() {
        homePage.getNavigationSection().selectPage("PIM");
        pimPage = PageFactory.getInstance().getPimPage(Driver.getInstance());
        pimPage.clickToAddButton()
                .setTextToNameFields("firstName", "Uyen")
                .setTextToNameFields("middleName", "Tu")
                .setTextToNameFields("lastName","Ta")
                .clickCreateLoginDetails(true)
                .setTextToOtherFields("Username","phoebe1")
                .setTextToOtherFields("Password","#Onimusha00")
                .setTextToOtherFields("Confirm Password", "#Onimusha00");
    }

    @Test
    public void TC02_Create_Account_In_PIM_Page() {
        homePage.getNavigationSection().selectPage("My Info");
    }

    public void TC03_Create_Account_In_Admin_Page() {
        homePage.getNavigationSection().selectPage("My Info");
    }
}

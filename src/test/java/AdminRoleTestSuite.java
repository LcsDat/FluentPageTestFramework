import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminRoleTestSuite extends BaseTest {
    HomePage homePage;
    PIMPage pimPage;

    String alphaNumeric = "[[A-Za-z0-9]]";
    String nongAlphaNumeric = "[^A-Za-z0-9]";
    String validFirstName;
    String validMiddleName;
    String validLastName;
    String validEmployeeID;

    @BeforeClass
    public void beforeClass() {
        driver = Driver.getInstance();
        homePage = PageFactory.getInstance().getHomePage(driver);
        pimPage = PageFactory.getInstance().getPimPage(driver);

        validFirstName = getFaker().name().firstName();
        validMiddleName = getFaker().name().firstName();
        validLastName = getFaker().name().lastName();
        validEmployeeID = getFakerValueService().bothify("?????#####");
    }

    @Test
    public void TC01_Add_Employee_With_Invalid_Info() {
        homePage.getNavigationSection().selectPage("PIM");
//        pimPage = PageFactory.getInstance().getPimPage(Driver.getInstance());
        pimPage.clickToButton("Add")
                .waitForLoadingSpinnerInvisible()
                .clickToButton("Save")
                .verifyFirstNameErrorMessage("Required")
                .verifyLastNameErrorMessage("Required")
                .setTextToNameFields("firstName",
                        getRandomString(alphaNumeric + "{23}" + nongAlphaNumeric + "{11}"))
                .verifyFirstNameErrorMessage("Should not exceed 30 characters")
                .setTextToNameFields("lastName",
                        getRandomString(alphaNumeric + "{23}" + nongAlphaNumeric + "{11}"))
                .verifyLastNameErrorMessage("Should not exceed 30 characters")
                .setTextToOtherFields("Employee Id",
                        getRandomString(alphaNumeric + "{11}"))
                .verifyOtherFieldsErrorMessage("Employee Id", "Should not exceed 10 characters");

    }

    @Test
    public void TC02_Add_Employee_With_Valid_Info_And_Without_Credentials() {

        pimPage.setTextToNameFields("firstName", validFirstName)
                .setTextToNameFields("middleName", validMiddleName)
                .setTextToNameFields("lastName", validLastName)
                .setTextToOtherFields("Employee Id", validEmployeeID)
                .clickToButton("Save")
                .waitForLoadingSpinnerInvisible()
                .selectTopbarItem("Employee List")
                .verifyEmployeeInfoInTableById("3859","First (& Middle) Name", "Dat77206")
                .verifyEmployeeInfoInTableById("3859","Last Name", "Le87504");
    }

    public void TC03_Create_Account_In_Admin_Page() {
        homePage.getNavigationSection().selectPage("My Info");
    }
}

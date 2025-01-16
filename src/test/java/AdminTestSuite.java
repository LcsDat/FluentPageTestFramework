import commons.GlobalConstant;
import commons.RegexPattern;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.AdminPage;
import pageObjects.HomePage;
import pageObjects.PIMPage;
import pageObjects.PageFactory;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminTestSuite extends BaseTest {
    HomePage homePage;
    PIMPage pimPage;
    AdminPage adminPage;

    String alphaNumeric = "[A-Za-z0-9]";

    String validFirstName;
    String validMiddleName;
    String validLastName;
    String validEmployeeID;

    String validFirstName1;
    String validMiddleName1;
    String validLastName1;
    String validEmployeeID1;

    String validUsername;
    String validPassword;

    @Parameters({"browser", "url"})
    @Description("Page Initialization and prepare test data")
    @BeforeClass
    public void beforeClass(String browser, String url) {
        quickAdminLogin(browser, url);
        homePage = PageFactory.getInstance().getHomePage(driver);
        pimPage = PageFactory.getInstance().getPimPage(driver);
        adminPage = PageFactory.getInstance().getAdminPage(driver);

        validFirstName = getFaker().name().firstName();
        validMiddleName = getFaker().name().firstName();
        validLastName = getFaker().name().lastName();
        validEmployeeID = getFakerValueService().bothify("?????#####");

        validFirstName1 = getFaker().name().firstName();
        validMiddleName1 = getFaker().name().firstName();
        validLastName1 = getFaker().name().lastName();
        validEmployeeID1 = getFakerValueService().bothify("?????#####");

        validUsername = getFakerValueService().bothify("???????#####");
        validPassword = getRandomString(RegexPattern.VALID_Password);

    }

//    @AfterClass
//    public void beforeClass() {
//        closeBrowser();
//    }

//    @Description("PIM Page: Add Employee with invalid info")
//    @Severity(SeverityLevel.NORMAL)
//    @Owner(GlobalConstant.OWNER)
//    @Tag("Functional")
//    @Tag("Amin")
//    @Test(testName = "Add Employee")
//    public void TC01_Add_Employee() {
//        homePage.getNavigationSection().selectPage("PIM");
//        pimPage.clickToButton("Add")
//                .waitForLoadingSpinnerInvisible()
//                .clickToButton("Save")
//                .verifyFirstNameErrorMessage("Required")
//                .verifyLastNameErrorMessage("Required")
//                .setTextToNameFields("firstName",
//                        getRandomString(RegexPattern.EXCEED_40Chars))
//                .verifyFirstNameErrorMessage("Should not exceed 30 characters")
//                .setTextToNameFields("lastName",
//                        getRandomString(RegexPattern.EXCEED_40Chars))
//                .verifyLastNameErrorMessage("Should not exceed 30 characters")
//                .setTextToOtherFields("Employee Id",
//                        getRandomString(alphaNumeric + "{11}"))
//                .verifyOtherFieldsErrorMessage("Employee Id", "Should not exceed 10 characters");
//
//    }
//
//    @Description("PIM Page: Add Employee without creating account")
//    @Severity(SeverityLevel.NORMAL)
//    @Owner(GlobalConstant.OWNER)
//    @Tag("Functional")
//    @Tag("Amin")
//    @Test(testName = "Add Employee")
//    public void TC02_Add_Employee() {
//
//        homePage.getNavigationSection().selectPage("PIM");
//        pimPage.clickToButton("Add")
//                .setTextToNameFields("firstName", validFirstName)
//                .setTextToNameFields("middleName", validMiddleName)
//                .setTextToNameFields("lastName", validLastName)
//                .setTextToOtherFields("Employee Id", validEmployeeID)
//                .clickToButton("Save")
//                .waitForLoadingSpinnerInvisible()
//                .selectTopBarItem("Employee List")
//                .verifyEmployeeInfoInTableById(validEmployeeID, "First (& Middle) Name", validFirstName + " " + validMiddleName)
//                .verifyEmployeeInfoInTableById(validEmployeeID, "Last Name", validLastName);
//    }
//
//    @Description("PIM Page: Create Employee Account With Invalid Credentials")
//    @Severity(SeverityLevel.CRITICAL)
//    @Owner(GlobalConstant.OWNER)
//    @Tag("Functional")
//    @Tag("Amin")
//    @Test(testName = "Add Employee")
//    public void TC03_Add_Employee() {
//        Allure.step("Input valid info to First, Middle, Last and Employee Id");
//        pimPage.selectTopBarItem("Add Employee")
//                .setTextToNameFields("firstName", validFirstName1)
//                .setTextToNameFields("middleName", validMiddleName1)
//                .setTextToNameFields("lastName", validLastName1)
//                .setTextToOtherFields("Employee Id", validEmployeeID1);
//        Allure.step("Enable Create Login Details");
//        pimPage.clickCreateLoginDetails(true)
//                .clickToButton("Save");
//
//        Allure.step("Username and Password is required");
//        pimPage.verifyOtherFieldsErrorMessage("Username", "Required")
//                .verifyOtherFieldsErrorMessage("Password", "Required");
//
//        Allure.step("Username too short");
//        pimPage.setTextToOtherFields("Username", "a")
//                .verifyOtherFieldsErrorMessage("Username", "Should be at least 5 characters");
//
//        Allure.step("Username too long");
//        pimPage.setTextToOtherFields("Username", getRandomString(RegexPattern.EXCEED_40Chars))
//                .verifyOtherFieldsErrorMessage("Username", "Should not exceed 40 characters");
//
//        Allure.step("Password too short");
//        pimPage.setTextToOtherFields("Password", "a");
//        sleepInSecond(1);
//        pimPage.verifyOtherFieldsErrorMessage("Password",
//                "Should have at least 8 characters");
//
//        Allure.step("Password miss upper case");
//        pimPage.setTextToOtherFields("Password", getRandomString(RegexPattern.NO_UpperCase));
//        sleepInSecond(1);
//        pimPage.verifyOtherFieldsErrorMessage("Password",
//                "Your password must contain minimum 1 upper-case letter");
//
//        Allure.step("Password miss lower case");
//        pimPage.setTextToOtherFields("Password", getRandomString(RegexPattern.NO_LowerCase));
//        sleepInSecond(1);
//        pimPage.verifyOtherFieldsErrorMessage("Password",
//                "Your password must contain minimum 1 lower-case letter");
//
//        Allure.step("Password miss number");
//        pimPage.setTextToOtherFields("Password", getRandomString(RegexPattern.NO_Number));
//        sleepInSecond(1);
//        pimPage.verifyOtherFieldsErrorMessage("Password",
//                "Your password must contain minimum 1 number");
//
//        Allure.step("Password miss special characters");
//        pimPage.setTextToOtherFields("Password", getRandomString(RegexPattern.NO_Special));
//        sleepInSecond(1);
//        pimPage.verifyOtherFieldsErrorMessage("Password",
//                "Your password must contain minimum 1 special character");
//
//        Allure.step("Password too long");
//        pimPage.setTextToOtherFields("Password", getRandomString(RegexPattern.EXCEED_64Chars));
//        sleepInSecond(1);
//        pimPage.setTextToOtherFields("Password", getRandomString(RegexPattern.EXCEED_64Chars));
//        pimPage.verifyOtherFieldsErrorMessage("Password",
//                "Should not exceed 64 characters");
//
//        Allure.step("Password and Confirm Password do not match");
//        pimPage.setTextToOtherFields("Password", getRandomString(RegexPattern.VALID_Password))
//                .setTextToOtherFields("Confirm Password", "b");
//        pimPage.verifyOtherFieldsErrorMessage("Confirm Password",
//                "Passwords do not match");
//    }
//
//
//    @Description("PIM Page: Create Employee Account With Valid Credentials")
//    @Severity(SeverityLevel.NORMAL)
//    @Owner(GlobalConstant.OWNER)
//    @Tag("Functional")
//    @Tag("Amin")
//    @Test(testName = "Add Employee")
//    public void TC04_Add_Employee() {
//        pimPage.setTextToOtherFields("Username", validUsername)
//                .setTextToOtherFields("Password", validPassword)
//                .setTextToOtherFields("Confirm Password", validPassword);
//
//        String defaultImageSrc = pimPage.getImageSource();
//
//        pimPage.uploadImage(GlobalConstant.IMAGE_PATH + File.separator + "Lion.jpg")
//                .clickToButton("Save")
//                .waitForLoadingSpinnerInvisible();
//
//        String uploadedImageSrc = pimPage.getImageSource();
//
//        Allure.step("Verify image source is changed after uploading image");
//        Assert.assertNotEquals(defaultImageSrc, uploadedImageSrc);
//
//        pimPage.getNavigationSection().selectPage("Admin");
//
//        adminPage.verifyEmployeeAccountInfoInTableByUsername(
//                        validUsername, "User Role", "ESS")
//                .verifyEmployeeAccountInfoInTableByUsername(
//                        validUsername, "Employee Name", validFirstName1 + " " + validLastName1);
//    }

    @Description("PIM Page: Edit Job Information For Employee")
    @Severity(SeverityLevel.NORMAL)
    @Owner(GlobalConstant.OWNER)
    @Tag("Functional")
    @Tag("Amin")
    @Test
    public void TC05_Job_Info() {
        DateTimeFormatter dtF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime lcDT = LocalDateTime.now();

        homePage.getNavigationSection().selectPage("PIM");
//        adminPage.getNavigationSection().selectPage("PIM");
        pimPage.findEmployeeById("0003");
        pimPage.getPersonalDetails().selectDetailsPart("Job");
//        pimPage.setTextToField("Joined Date", lcDT.plusMonths(-1).format(dtF))
             pimPage   .setDropdown("Job Title", "Data Analyst");
//                .setDropdown("Job Category", "Office")
//                .setDropdown("Location", "A")
//                .setDropdown("Employment Status", "Full-time Contract");
        sleepInSecond(4);
        pimPage.clickEmploymentContractDetails(true)
                .setTextToField("Contract Start Date", lcDT.format(dtF))
                .setTextToField("Contract End Date", lcDT.plusYears(1).format(dtF))
                .uploadImage(GlobalConstant.IMAGE_PATH + File.separator + "Lion.jpg")
                .clickToButton("Save");
    }
}
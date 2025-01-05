import org.testng.annotations.Test;

public class AdminRoleTestSuite extends BaseTest {
    HomePage homePage;
    PIMPage pimPage;

    String alphaNumeric = "[A-Za-z0-9]";
    String nonAlphaNumeric = "[^A-Za-z0-9]";
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

    String invalidShortUsername;
    String invalidLongUsername;
    String invalidShortPasswordLength;
    String invalidLongPasswordLength;
    String missUpperCasePassword;
    String missNumberPassword;
    String missSpecialCharacterPassword;

//    @BeforeClass
    @Test
    public void beforeClass() {
        driver = Driver.getInstance();
        homePage = PageFactory.getInstance().getHomePage(driver);
        pimPage = PageFactory.getInstance().getPimPage(driver);

        validFirstName = getFaker().name().firstName();
        validMiddleName = getFaker().name().firstName();
        validLastName = getFaker().name().lastName();
        validEmployeeID = getFakerValueService().bothify("?????#####");

        validFirstName1 = getFaker().name().firstName();
        validMiddleName1 = getFaker().name().firstName();
        validLastName1 = getFaker().name().lastName();
        validEmployeeID1 = getFakerValueService().bothify("?????#####");

        invalidShortUsername = "a";
        invalidLongUsername = getRandomString(alphaNumeric + "{41}");
        invalidShortPasswordLength = "#";
        invalidLongPasswordLength = getRandomString("ABC"+"[A-Z]{20}[0-9]{20}[a-z]{10}" + nonAlphaNumeric +"{15}");
        missUpperCasePassword = getRandomString("[^A-Z]{20}");
        missNumberPassword = getRandomString("[^0-9]{20}");
        missSpecialCharacterPassword = getRandomString("[A-Za-z0-9]{20}");

        validUsername = getFaker().name().username();
        validUsername = getFaker().internet().password();

        System.out.println("long pw " +invalidLongPasswordLength);
        System.out.println("long user " +invalidLongUsername);
        System.out.println(missNumberPassword);
        System.out.println(missUpperCasePassword);
        System.out.println(missSpecialCharacterPassword);
    }

//    @Test
//    public void TC01_Add_Employee_With_Invalid_Info() {
//        homePage.getNavigationSection().selectPage("PIM");
//        pimPage.clickToButton("Add")
//                .waitForLoadingSpinnerInvisible()
//                .clickToButton("Save")
//                .verifyFirstNameErrorMessage("Required")
//                .verifyLastNameErrorMessage("Required")
//                .setTextToNameFields("firstName",
//                        getRandomString(alphaNumeric + "{23}" + nongAlphaNumeric + "{11}"))
//                .verifyFirstNameErrorMessage("Should not exceed 30 characters")
//                .setTextToNameFields("lastName",
//                        getRandomString(alphaNumeric + "{23}" + nongAlphaNumeric + "{11}"))
//                .verifyLastNameErrorMessage("Should not exceed 30 characters")
//                .setTextToOtherFields("Employee Id",
//                        getRandomString(alphaNumeric + "{11}"))
//                .verifyOtherFieldsErrorMessage("Employee Id", "Should not exceed 10 characters");
//
//    }
//
//    @Test()
//    public void TC02_Add_Employee_With_Valid_Info_And_Without_Credentials() {
//
//        homePage.getNavigationSection().selectPage("PIM");
//        pimPage.clickToButton("Add")
//                .setTextToNameFields("firstName", validFirstName)
//                .setTextToNameFields("middleName", validMiddleName)
//                .setTextToNameFields("lastName", validLastName)
//                .setTextToOtherFields("Employee Id", validEmployeeID)
//                .clickToButton("Save")
//                .waitForLoadingSpinnerInvisible()
//                .selectTopbarItem("Employee List")
//                .verifyEmployeeInfoInTableById(validEmployeeID, "First (& Middle) Name", validFirstName + " " + validMiddleName)
//                .verifyEmployeeInfoInTableById(validEmployeeID, "Last Name", validLastName);
//    }
//
//    @Test
//    public void TC03_Add_Employee_With_Valid_Info_And_With_Invalid_Credentials() {
//        pimPage.selectTopbarItem("Add Employee")
//                .setTextToNameFields("firstName", validFirstName1)
//                .setTextToNameFields("middleName", validMiddleName1)
//                .setTextToNameFields("lastName", validLastName1)
//                .setTextToOtherFields("Employee Id", validEmployeeID1)
//                .clickCreateLoginDetails(true)
//                .clickToButton("Save")
//                .verifyOtherFieldsErrorMessage("Username", "Required")
//                .verifyOtherFieldsErrorMessage("Password", "Required")
//                .setTextToOtherFields("Username", invalidShortUsername)
//                .verifyOtherFieldsErrorMessage("Username", "Should be at least 5 characters")
//                .setTextToOtherFields("Username", invalidLongUsername)
//                .verifyOtherFieldsErrorMessage("Username", "Should not exceed 40 characters");
//
//        pimPage.setTextToOtherFields("Password", invalidShortPasswordLength);
//        sleepInSecond(1);
//        pimPage.verifyOtherFieldsErrorMessage("Password", "Should have at least 8 characters");
//        pimPage.setTextToOtherFields("Password", missUpperCasePassword);
//        sleepInSecond(1);
//        pimPage.verifyOtherFieldsErrorMessage("Password", "Your password must contain minimum 1 upper-case letter");
//        pimPage.setTextToOtherFields("Password", missNumberPassword);
//        sleepInSecond(1);
//        pimPage.verifyOtherFieldsErrorMessage("Password", "Your password must contain minimum 1 number");
//        pimPage.setTextToOtherFields("Password", missSpecialCharacterPassword);
//        sleepInSecond(1);
//        pimPage.verifyOtherFieldsErrorMessage("Password", "Your password must contain minimum 1 special character");
//        pimPage.setTextToOtherFields("Password", invalidLongPasswordLength);
//        sleepInSecond(1);
//        pimPage.verifyOtherFieldsErrorMessage("Password", "Should not exceed 64 characters");
//        pimPage.setTextToOtherFields("Password", validPassword)
//                .setTextToOtherFields("Confirm Password", invalidShortPasswordLength);
//        sleepInSecond(1);
//        pimPage.verifyOtherFieldsErrorMessage("Confirm Password", "Passwords do not match");
//    }
}
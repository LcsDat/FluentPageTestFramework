package com.OrangeHRM;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.AdminPage;
import pageObjects.HomePage;
import pageObjects.PageFactory;

public class JobMasterData extends BaseTest {
    HomePage homePage;
    AdminPage adminPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browser, String URL) {
        quickAdminLogin(browser, URL);
        homePage = PageFactory.getInstance().getHomePage(driver);
        adminPage = PageFactory.getInstance().getAdminPage(driver);
    }

    @Test
    public void JobMasterData01() throws InterruptedException {
        homePage.getNavigationSection().selectPage("Admin");
        adminPage.selectTopBarItem("Job")
                .selectDropDownItemName("Job Titles")
                .clickToButton("Add")
                .setTextToField("Job Title", "Factory Engineer 6")
                .clickToButton("Save")
                .waitForLoadingSpinnerInvisible();
        adminPage.selectTopBarItem("Job")
                .selectDropDownItemName("Pay Grades")
                .clickToButton("Add")
                .setTextToField("Name", "Level 785")
                .clickToButton("Save")
                .clickToButton("Add")
                .selectACurrency("ALL - Albanian Lek")
                .setTextToField("Minimum Salary", "4000")
                .setTextToField("Maximum Salary", "40000")
                .clickToSaveCurrency()
                .selectTopBarItem("Job")
                .selectDropDownItemName("Employment Status")
                .clickToButton("Add")
                .setTextToField("Name", "Retireddddddd")
                .selectTopBarItem("Job")
                .selectDropDownItemName("Work Shifts")
                .clickToButton("Add")
                .waitForLoadingSpinnerInvisible()
                .setTextToField("Shift Name", "Shift 11")
                .setWorkingHours("10:00 AM", "06:00 PM");
        adminPage.clickToButton("Save");
        adminPage.clickToButton("Save");

    }
}

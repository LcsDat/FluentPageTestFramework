package com.YouTube;

import commons.GlobalConstant;
import driverActions.Browser;
import driverActions.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class Register {
    Driver driver;
    Select select;

    @Test
    void guestMode() throws InterruptedException {
        driver = Driver.getInstance();
        driver.startBrowser(Browser.FIREFOX);
        driver.maximizeWindow();
        driver.setImplicitTimeout(Duration.ofSeconds(20));
        driver.goToUrl("https://www.youtube.com/");


        driver.findElementByXpath("//a[@aria-label='Sign in' and not(@aria-disabled='false')]")
                .click();
        driver.findElementByXpath("//span[text()='Create account']")
                .click();
        driver.findElementByXpath("//span[text()='For my personal use']")
                .click();
        driver.findElementByCss("#firstName")
                .setText("Selenium");
        driver.findElementByCss("#lastName")
                .setText("Playwright");
        driver.findElementByXpath("//span[text()='Next']/parent::button")
                .click();

        driver.findElementById("month").defaultSelectByValue("2");

        driver.findElementById("day").setText("2");
        driver.findElementById("year").setText("1989");

        driver.findElementById("gender").defaultSelectByText("Male");

        driver.findElementByXpath("//span[text()='Next']/parent::button")
                .click();

        driver.findElementByXpath("//button[text()='Get a Gmail address instead']").click();
        driver.findElementByXpath("//div[@aria-posinset='1']").waitToClick();
        driver.findElementByXpath("//div[@aria-posinset='1']").click();
        driver.findElementByXpath("//span[text()='Next']/parent::button")
                .click();

        driver.findElementByXpath("//input[@name='Passwd']").waitToClick();
        driver.findElementByXpath("//input[@name='Passwd']").setText("#abcdef123456");
        Thread.sleep(3000);
        driver.findElementByXpath("//input[@name='PasswdAgain']").waitToClick();
        driver.findElementByXpath("//input[@name='PasswdAgain']").setText("#abcdef123456");
        Thread.sleep(3000);
        driver.findElementByXpath("//span[text()='Next']/parent::button")
                .click();
    }

}

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {

    @Test
    public void hihi() throws IOException, ParseException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(GlobalConstant.LONG_DURATION);
        driver.manage().window().maximize();
        driver.get("http://localhost:90/");
        driver.findElement(By.name("username")).sendKeys("hideyashy");
        driver.findElement(By.name("password")).sendKeys("#Onimusha00");
        driver.findElement(By.cssSelector("button")).click();
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Job']")).click();
//        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Pay Grades']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        driver.findElement(
                By.xpath("//label[text()='Name']/parent::div/following-sibling::div/input"))
                .sendKeys("aaaa");
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        WebElement e = driver.findElement(By.cssSelector("div.oxd-select-text-input"));
        js.executeScript("arguments[0].innerText = 'AOR - Angolan New Kwanza'", e);
        Thread.sleep(2000);
        driver.findElement(
                By.xpath("//label[text()='Minimum Salary']/parent::div/following-sibling::div/input"))
                .sendKeys("1");
        driver.findElement(
                By.xpath("//label[text()='Maximum Salary']/parent::div/following-sibling::div/input"))
                .sendKeys("2");
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
    }
}

package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class Attachment {
    public static FileInputStream fileScreenshot(WebDriver driver) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));
        } catch (IOException e) {

        }

        return fileInputStream;
    }
}

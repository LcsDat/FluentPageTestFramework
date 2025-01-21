package commons;

import driverActions.Driver;
import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import utils.Attachment;

public class AllureListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {


        Allure.addAttachment(result.getName(), Attachment.fileScreenshot(Driver.getInstance().getWebDriver()));
    }
}

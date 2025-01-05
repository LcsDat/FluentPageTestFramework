import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Demo {

    public static void main(String[] args) throws IOException {
        System.out.println(GlobalConstant.TEST_OUTPUT_PATH);
        File file = new File("./allure-results");
        FileUtils.cleanDirectory(file);
    }
}

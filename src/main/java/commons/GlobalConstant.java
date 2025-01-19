package commons;

import java.io.File;
import java.time.Duration;

public class GlobalConstant {
    public static final Duration LONG_DURATION = Duration.ofSeconds(10);
    public static final Duration SHORT_DURATION = Duration.ofSeconds(3);
    public static final String TEST_OUTPUT_PATH = System.getProperty("user.dir") + File.separator + "allure-results";
    public static final String IMAGE_PATH = System.getProperty("user.dir") + File.separator + "Image";
    public static final String OWNER = "Hideyashy";
    public static final String OS_NAME = System.getProperty("os.name");

}

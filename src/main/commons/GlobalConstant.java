import java.io.File;
import java.time.Duration;

public class GlobalConstant {
    public static final Duration LONG_DURATION = Duration.ofSeconds(15);
    public static final Duration SHORT_DURATION = Duration.ofSeconds(3);
    public static final String TEST_OUTPUT_PATH = System.getProperty("user.dir") + File.separator + "allure-results";
    public static final String IMAGE_PATH = System.getProperty("user.dir") + File.separator + "Image";
}

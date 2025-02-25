import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class DemoSomething {
    public void passwordExample() {
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        console.printf("Testing password%n");
        char[] passwordArray = console.readPassword("Enter your secret password: ");
        console.printf("Password entered was: %s%n", new String(passwordArray));

    }

    public static void main(String[] args) throws ParseException, IOException {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.youtube.com/");
//
//        driver.findElement(By.cssSelector("form.ytSearchboxComponentSearchForm > input")).sendKeys("Say trong nu cuoi");
//        driver.findElement(By.cssSelector("form.ytSearchboxComponentSearchForm > input")).sendKeys(Keys.ENTER);
//
//        driver.findElement(By.xpath("//a[contains(@title,'TĂNG DUY TÂN x DRUM7 | SAY TRONG NỤ CƯỜI')]")).click();

        ProcessBuilder builder = new ProcessBuilder();
        builder.command("cmd.exe", "/c", "start");
//        builder.directory(new File(System.getProperty("user.home")));
        System.out.println(System.getProperty("os.name"));
        Process process = builder.start();
        builder.command("cmd.exe", "/c", "cd D:\\Work\\Automation");
        process = builder.start();
//        var processs = new ProcessBuilder("cmd", "/c", "DIR")
//                .redirectOutput(ProcessBuilder.Redirect.INHERIT)
//                .start();
        System.out.println(System.getProperty("user.home"));
    }

}

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.io.Console;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

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

    public static void main(String[] args) throws ParseException {
        String date_s = " 2011-01-18 00:00:00.0";
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        Date date = dt.parse(date_s);
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dt1.format(date));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        LocalDateTime a = LocalDateTime.now();
        var b = a.plusYears(1);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

}

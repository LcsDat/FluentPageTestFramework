import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.io.File;
import java.util.Arrays;
import java.util.Locale;

public class DemoSomething {
    public static void main(String[] args) {
        FakeValuesService fk = new FakeValuesService(new Locale("en"), new RandomService());

        System.out.println(fk.regexify("[A-Za-z0-9]{40}"));
        fk.bothify("");
    }
}

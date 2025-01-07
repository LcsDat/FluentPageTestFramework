import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {

    public static void main(String[] args) throws IOException, ParseException {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");

        Date a = dateFormat.parse("18:00 PM");
        System.out.println(a);
    }
}

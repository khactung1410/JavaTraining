package DateTimeFormatExample;


import java.text.SimpleDateFormat;
import java.util.*;
public class DateTimeFormatExample {
    public static void main(String[] args) {
        Locale locale = new Locale("En","EN");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE,MMMMM dd yyyy",locale);
        Calendar calendar = Calendar.getInstance();
        System.out.println(dateFormat.format(calendar.getTime()));
    }
}

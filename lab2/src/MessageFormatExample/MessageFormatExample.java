/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.0
 */
package MessageFormatExample;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
public class MessageFormatExample {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("EEEEE, dd MMMMM yyyy",new Locale("en","en"));
        String message = MessageFormat.format("Hello{0}! Today is {1} " , " tung", dateFormat.format(Calendar.getInstance().getTime()));
        System.out.println(message);
    }
}

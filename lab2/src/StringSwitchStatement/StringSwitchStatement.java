/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringSwitchStatement;

import java.util.Calendar;
import static java.util.Calendar.DATE;
import java.util.Locale;

public class StringSwitchStatement {
    static String getTypeOfDay(Calendar calendar){
    String type = calendar.getDisplayName(
                Calendar.DAY_OF_WEEK,Calendar.SHORT,new Locale("vi"));
    
    switch(type){
        case "Th 2":
            return "start of work week";
        case "Th 3":
            return "mid week";
        case "Th 4":
            return "thu 4 ne!!!";
        case "Th 7":
            return "end of work week";
        case "CN" :
            return "weekend";
    }
    return "Unknown";
    }
    public static void main(String[] args) {
        StringSwitchStatement statement = new StringSwitchStatement();
        Calendar calendar = Calendar.getInstance();
        System.out.println("Today is "+StringSwitchStatement.getTypeOfDay(calendar));
        
        calendar.set(Calendar.DATE,calendar.get(DATE)+1);
        System.out.println("Tomorrow is "+ getTypeOfDay(calendar));
    }
}

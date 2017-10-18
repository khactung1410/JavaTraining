
import java.util.Calendar;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MTBEBAN
 */
public enum VnDay {
    THU_HAI,THU_BA,CHU_NHAT,THU_BAY,KHONG_BIET;
    
    static VnDay valueOf(Calendar){
        String type = Calendar.getDisplay(Calendar.DAY_OF_WEEK,Calendar.SHORT,new Locale("vi"));     
        switch(type){
            case "Th2":return THU_HAI;
            case "Th7":return THU_BAY;
            case "CN":return CHU_NHAT;
        }
        return KHONG_BIET;
    }
}

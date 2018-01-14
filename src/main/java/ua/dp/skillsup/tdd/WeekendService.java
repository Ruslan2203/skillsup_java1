package ua.dp.skillsup.tdd;


import java.time.*;
import java.util.Calendar;


public class WeekendService {

    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_WEEK);

    public WeekendService() {
        this.day = day;
    }

    public WeekendService(int day){
        this.day=day;
    }

    public boolean isWorking(){
        if ((day==calendar.get(Calendar.SATURDAY))||day==calendar.get(Calendar.SUNDAY))
            return true;

        else  return false;
    }



}

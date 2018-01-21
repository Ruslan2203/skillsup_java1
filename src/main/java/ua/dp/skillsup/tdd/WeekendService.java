package ua.dp.skillsup.tdd;


import java.time.*;
import java.util.Calendar;


public class WeekendService {

    LocalDate localDate;

    public WeekendService(LocalDate localDate) {
        this.localDate = localDate;
    }
    public boolean isWeekend(){
        if (localDate.getDayOfWeek()==DayOfWeek.SATURDAY||
                localDate.getDayOfWeek()==DayOfWeek.SUNDAY)
            return true;

        else  return false;
    }


}

package com.graemehbrown.simplestockmarket.Utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date getBeginningOfRange(int durationInMinutesToCalculate) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -durationInMinutesToCalculate);
        Date beginningOfRange = cal.getTime();
        return beginningOfRange;
    }
}



package com.coder.codermanager.Date;

import java.util.Calendar;

/**
 * Created by Rey on 2018/9/14.
 */

public class MyDate {

    private static Calendar calender;
    private int year;
    private int month;
    private int day;

    private static MyDate Instance;

    private MyDate() {

    }

    public static MyDate getInstance() {

        if (Instance == null) {
            synchronized (MyDate.class) {
                if (Instance == null) {
                    Instance = new MyDate();
                    calender = Calendar.getInstance();
                }
            }
        }
        return Instance;
    }


    public int year() {
        return year = calender.get(Calendar.YEAR);
    }

    public int month() {
        return month = calender.get(Calendar.MONTH);
    }

    public int day() {
        return day = calender.get(Calendar.DAY_OF_MONTH);
    }
}

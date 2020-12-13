package main.java.mock;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DaysBetweenDates {

    public static int daysBetweenDates(String date1, String date2) {

        String[] d1 = date1.split("-");
        String[] d2 = date2.split("-");

        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();

        cal1.set(Integer.parseInt(d1[0]), Integer.parseInt(d1[1]), Integer.parseInt(d1[1]));
        cal2.set(Integer.parseInt(d2[0]), Integer.parseInt(d2[1]), Integer.parseInt(d2[1]));
        return daysBetween(cal1.getTime(),cal2.getTime());

    }

    public static int daysBetween(Date d1, Date d2) {
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static void main(String[] args) {
        System.out.println(daysBetweenDates("2020-01-15", "2019-12-31"));
    }
}

package com.sonal.adhoc;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateUtil {

    public static LocalDate convertToLocalDate(Date date) {
	Instant instant = date.toInstant();
	ZonedDateTime zdt = instant.atZone(ZoneId.of("America/Los_Angeles"));
	LocalDate localDate = zdt.toLocalDate();
	return localDate;
    }
    
    public static LocalDateTime convertToLocalDateTime(Date date) {
	Instant instant = date.toInstant();
	ZonedDateTime zdt = instant.atZone(ZoneId.of("America/Los_Angeles"));
	LocalDateTime localDate = zdt.toLocalDateTime();
	return localDate;
    }
    
    public static LocalDateTime convertToLocalDateTime(Date date, Integer hour , Integer minute) {
   	Instant instant = date.toInstant();
   	ZonedDateTime zdt = instant.atZone(ZoneId.of("America/Los_Angeles"));
   	LocalDate localDate = zdt.toLocalDate();
   	LocalTime localTime = LocalTime.of(hour, minute);
   	LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
   	
   	return localDateTime;
       }
    
    public static LocalDateTime calculateJobEndTime(Date date, Integer hour , Integer minute , Integer jobDuration){
	
	Instant instant = date.toInstant();
   	ZonedDateTime zdt = instant.atZone(ZoneId.of("America/Los_Angeles"));
   	LocalDate localDate = zdt.toLocalDate();
   	
   	Integer endTimeInMins  = (hour * 60) + minute + jobDuration;
   	
   	Integer endHour = endTimeInMins / 60;
   	Integer endMinute = endTimeInMins % 60;
   	LocalTime localTime = LocalTime.of(endHour, endMinute);
   	LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
   	return localDateTime;
    }
    
    public static Date createNewDateRange(String date, Integer hr, Integer min){
	
	String[] dateSplit = date.split("/");
	
	LocalDateTime startlocalDatetime = LocalDateTime.of(Integer.valueOf(dateSplit[2]), Integer.valueOf(dateSplit[0]), Integer.valueOf(dateSplit[1]), hr, min);
	
	
	return convertToDate(startlocalDatetime);
	
    }

    static public Date convertToDate(LocalDateTime ldt) {
	ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("America/Los_Angeles"));
	GregorianCalendar cal = GregorianCalendar.from(zdt);
	return cal.getTime();
    }

    public static Date getCurrentDateWithOutTime() {

	Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("America/Los_Angeles")));
	cal.setTime(getCurrentDateWithTime());
	cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	cal.set(Calendar.MILLISECOND, 0);

	return cal.getTime();
    }

    public static Date getCurrentDateWithTime() {
	
	LocalDateTime ldt = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
	Date dateTime = convertToDate(ldt);
	return dateTime;
    }
    
    public static LocalDateTime getCurrentLocalDateTime() {

	LocalDateTime ldt = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));

	return ldt;
    }
    

    public static Date stripTimeFromDate(Date date) {

	Calendar cal = Calendar.getInstance();
	cal.setTimeZone(TimeZone.getTimeZone(ZoneId.of("America/Los_Angeles")));
	cal.setTime(date);
	cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	cal.set(Calendar.MILLISECOND, 0);
	return cal.getTime();
    }
    
    public static Date resetToEndHourOfDate(Date date) {

	Calendar cal = Calendar.getInstance();
	cal.setTimeZone(TimeZone.getTimeZone(ZoneId.of("America/Los_Angeles")));
	cal.setTime(date);
	cal.set(Calendar.HOUR_OF_DAY, 23);
	cal.set(Calendar.MINUTE, 59);
	cal.set(Calendar.SECOND, 59);
	cal.set(Calendar.MILLISECOND, 999);
	return cal.getTime();
    }
    
    public static String stripTimeFromDateNFormat(Date date) {

	Calendar cal = Calendar.getInstance();
	cal.setTimeZone(TimeZone.getTimeZone(ZoneId.of("America/Los_Angeles")));
	cal.setTime(date);
	cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	cal.set(Calendar.MILLISECOND, 0);
	Date dateWithoutTime = cal.getTime();
	SimpleDateFormat ft = new SimpleDateFormat("EEE, d MMM yyyy");
	
	return ft.format(dateWithoutTime);
    }


    
    public static String convert24To12hrsFormat(String timeIn24hrsFormat) throws ParseException {

        DateFormat f1 = new SimpleDateFormat("HH");
        Date d = f1.parse(timeIn24hrsFormat);
        DateFormat f2 = new SimpleDateFormat("h:mm a");
        String timeIn12hrsFormat = f2.format(d).toLowerCase();
        return timeIn12hrsFormat;
    }
    
    public static int compareDates(Date date1, Date date2) {
	return stripTimeFromDate(date1).compareTo(stripTimeFromDate(date2));
    }
}

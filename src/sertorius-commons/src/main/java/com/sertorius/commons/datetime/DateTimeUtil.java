package com.sertorius.commons.datetime;

import com.sertorius.commons.util.lang.Commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * TODO comment<br>
 * 
 * @author caesar
 */
public final class DateTimeUtil {

    /**
     * Private constructor for <code>DateTimeUtil</code>
     */
    private DateTimeUtil() {
        super();
    }
    

    
    /**
     * TODO comment<br>
     * 
     * @param date
     * @param dateFormat
     * @return
     */
    public static String getDateAsString(final Date date, final DateTimeFormat dateFormat) {
        if (date == null || dateFormat == null) return null;
        return (new SimpleDateFormat(dateFormat.getFormat())).format(date);
    }

    
    
    /**
     * TODO comment<br>
     * 
     * @param stringDate
     * @param dateFormat
     * @return
     */
    public static Date getDateFromString(final String stringDate, final DateTimeFormat dateFormat) {
        if (Commons.isEmpty(stringDate) || dateFormat == null) return null;
        
        Date date = null;
        
        try {
            date = (new SimpleDateFormat(dateFormat.getFormat())).parse(stringDate);
        }
        catch (ParseException e) {
            // Nothing to do here...
        }
        
        return date;
    }

    
    
    /**
     * TODO comment<br>
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isTheSameDate(final Date date1, final Date date2) {
        if (date1 == null || date2 == null) return false;
        
        final Calendar cal1 = Calendar.getInstance();
        final Calendar cal2 = Calendar.getInstance();

        cal1.setTime(date1);
        cal2.setTime(date2);

        if (cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH)
            && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
            && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {
            return true;
        }

        return false;
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param date1
     * @param date2
     * @param timeZone
     * @return
     */
    public static boolean isTheSameDate(final Date date1, final Date date2, final TimeZone timeZone) {
        if (date1 == null || date2 == null) return false;
        
        final Calendar cal1 = Calendar.getInstance(timeZone);
        final Calendar cal2 = Calendar.getInstance(timeZone);

        cal1.setTime(date1);
        cal2.setTime(date2);

        if (cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH)
            && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
            && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {
            return true;
        }

        return false;
    }
    
    
    
    public static boolean isTheSameDateTime(final Date date1, final Date date2) {
        if (date1 == null || date2 == null) return false;
        
        return date1.equals(date2);
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param date
     * @return
     */
    public static Calendar convertDateToCalendar(final Date date) {
        if (date == null) return null;
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param date
     * @param timeZone
     * @return
     */
    public static Calendar convertDateToCalendar(final Date date, final TimeZone timeZone) {
        if (date == null) return null;
        
        Calendar cal = Calendar.getInstance(timeZone);
        cal.setTime(date);
        return cal;
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @return
     */
    public static Date getYerstaday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @return
     */
    public static Date getTomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param days
     * @return
     */
    public static Date getDateFromNow(final int days) {
        if (days == 0) return new Date();
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}

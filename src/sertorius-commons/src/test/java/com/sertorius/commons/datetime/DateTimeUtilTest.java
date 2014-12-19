package com.sertorius.commons.datetime;

import static org.junit.Assert.*;

import com.sertorius.commons.datetime.DateTimeFormat;
import com.sertorius.commons.datetime.DateTimeUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;


public class DateTimeUtilTest {
    
    private String todayAsString;
    
    private Date today;
    private Date yerstaday;
    private Date tomorrow;
    
    private int thisDay;
    private int thisMonth;
    private int thisYear;
    

    
    @Before
    public void before() {
        this.today = new Date();
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        this.yerstaday = cal.getTime();
        
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        this.tomorrow = cal.getTime();
        
        this.thisDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        this.thisMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        this.thisYear = Calendar.getInstance().get(Calendar.YEAR);
        
        this.todayAsString = thisYear + "-" + thisMonth + "-" + thisDay;
    }

    
    
    @Test
    public final void testGetDateAsString() {
        String stringDate = DateTimeUtil.getDateAsString(today, DateTimeFormat.YYYYMMDDHHMMSS);
        
        assertTrue(stringDate.contains(todayAsString));
        assertNull(DateTimeUtil.getDateAsString(today, null));
    }

    
    
    @Test
    public final void testGetDateFromString() {
        Date date1 = DateTimeUtil.getDateFromString("10/02/2009", DateTimeFormat.DDMMYYYY);
        Date date2 = DateTimeUtil.getDateFromString("10/02/2009 11:15:00", DateTimeFormat.DDMMYYYYHHMMSS);
        Date date3 = DateTimeUtil.getDateFromString("2009-10-02 11:15:00", DateTimeFormat.YYYYMMDDHHMMSS);
        
        assertEquals("10/02/2009", DateTimeUtil.getDateAsString(date1, DateTimeFormat.DDMMYYYY));
        assertEquals("10/02/2009 11:15:00", DateTimeUtil.getDateAsString(date2, DateTimeFormat.DDMMYYYYHHMMSS));
        assertEquals("2009-10-02 11:15:00", DateTimeUtil.getDateAsString(date3, DateTimeFormat.YYYYMMDDHHMMSS));
    }

    
    
    @Test
    public final void testIsTheSameDate() {
        assertFalse(DateTimeUtil.isTheSameDate(today, tomorrow));
        assertTrue(DateTimeUtil.isTheSameDate(today, today));
        assertTrue(DateTimeUtil.isTheSameDate(today, today, TimeZone.getDefault()));
    }

    
    
    @Test
    public final void testConvertDateToCalendar() {
        Calendar todayCalendar = DateTimeUtil.convertDateToCalendar(today);
        
        assertEquals(this.thisDay, todayCalendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(this.thisMonth, todayCalendar.get(Calendar.MONTH) + 1);
        assertEquals(this.thisYear, todayCalendar.get(Calendar.YEAR));
    }

    
    
    @Test
    public final void testGetYerstaday() {
        String yerstaday1 = DateTimeUtil.getDateAsString(this.yerstaday, DateTimeFormat.YYYYMMDD);
        String yerstaday2 = DateTimeUtil.getDateAsString(DateTimeUtil.getYerstaday(), DateTimeFormat.YYYYMMDD);
        assertEquals(yerstaday1, yerstaday2);
    }

    
    
    @Test
    public final void testGetTomorrow() {
        String tomorrow1 = DateTimeUtil.getDateAsString(this.tomorrow, DateTimeFormat.YYYYMMDD);
        String tomorrow2 = DateTimeUtil.getDateAsString(DateTimeUtil.getTomorrow(), DateTimeFormat.YYYYMMDD);
        assertEquals(tomorrow1, tomorrow2);
    }

    
    
    @Test
    public final void testGetDateFromNow() {
        Date futureDate = DateTimeUtil.getDateFromNow(1);
        Date pastDate = DateTimeUtil.getDateFromNow(-1);
        
        assertEquals(this.tomorrow, futureDate);
        assertEquals(this.yerstaday, pastDate);
    }
}

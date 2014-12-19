package com.sertorius.commons.datetime;

import static org.junit.Assert.*;

import com.sertorius.commons.datetime.DateRange;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;


public class DateRangeTest {
    
    private Date today;
    private Date yerstaday;
    private Date tomorrow;
    private Date weekAgo;
    

    
    @Before
    public void before() {
        this.today = new Date();
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        this.yerstaday = cal.getTime();
        
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        this.tomorrow = cal.getTime();
        
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        this.weekAgo = cal.getTime();
    }
    
    
    
    @Test
    public final void testDateRange() {
        DateRange dateRange = new DateRange(this.yerstaday, this.today);
        assertNotNull(dateRange.getStart());
        assertNotNull(dateRange.getEnd());
    }

    
    
    @Test
    public final void testIncludes() {
        DateRange dateRange = new DateRange(this.yerstaday, this.tomorrow);
        assertTrue(dateRange.includes(this.today));
        assertTrue(dateRange.includes(this.yerstaday));
        assertTrue(dateRange.includes(this.tomorrow));
        assertFalse(dateRange.includes(this.weekAgo));
    }

    
    
    @Test
    public final void testGetStart() {
        DateRange dateRange = new DateRange(this.yerstaday, this.today);
        assertEquals(this.yerstaday, dateRange.getStart());
    }

    
    
    @Test
    public final void testGetEnd() {
        DateRange dateRange = new DateRange(this.yerstaday, this.tomorrow);
        assertEquals(this.tomorrow, dateRange.getEnd());
    }

    
    
    @Test
    public final void testToString() {
        DateRange dateRange = new DateRange(this.yerstaday, this.tomorrow);
        assertTrue(dateRange.toString().contains(this.yerstaday.toString()));
        assertTrue(dateRange.toString().contains(this.tomorrow.toString()));
    }
}

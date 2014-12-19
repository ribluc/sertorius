package com.sertorius.commons.datetime;

import com.sertorius.commons.util.lang.Commons;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents a date range parameter<br>
 * 
 * @author caesar
 */
public final class DateRange implements Serializable {

    private static final long serialVersionUID = 8638500595047318611L;
    
    private final Date start;
    private final Date end;


    
    /**
     * Constructor for <code>DateRange</code>.<br>
     *
     * @param start The start <code>Date</code>
     * @param end The end <code>Date</code>
     */
    public DateRange(final Date start, final Date end) {
        this.start = start;
        this.end = end;
    }
    
    
    
    /**
     * Check if the given date is between the range<br>
     *
     * @param arg The <code>Date</code> to be checked
     * @return <tt>true</tt> if the date is included in the range
     */
    public boolean includes(final Date arg) {
        if (Commons.anyNull(arg, this.start, this.end)) return false;

        return (arg.equals(this.start)) ||
            (arg.equals(this.end)) ||
            (arg.after(this.start) && arg.before(this.end));
    }

    

    // ----- Getters/Setters
    
    public final Date getStart() {
        return this.start;
    }

    public final Date getEnd() {
        return this.end;
    }

    

    // ----- Class Methods
    
    @Override
    public String toString() {
        return new StringBuilder()
            .append("[")
            .append(DateRange.class.getName())
            .append("={start=")
            .append(this.start)
            .append(", end=")
            .append(this.end)
            .append("}]")
            .toString();
    }
}

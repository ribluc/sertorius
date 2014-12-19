package com.sertorius.commons.util.lang;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Collection;
import java.util.Map;

/**
 * TODO comment<br>
 * 
 * @author caesar
 */
public final class Commons {

    /**
     * Private Constructor for <code>Commons</code><br>
     */
    private Commons() {
        super();
    }


    
    /**
     * TODO comment<br>
     *
     * @param obj
     * @return
     */
    public static boolean isNull(final Object obj) {
        return (obj == null);
    }

    
    
    /**
     * TODO comment<br>
     *
     * @param obj
     * @return
     */
    public static boolean isNotNull(final Object obj) {
        return !isNull(obj);
    }


    
    /**
     * TODO comment<br>
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(final String value) {
        return ((value == null) || (value.trim().isEmpty()));
    }

    
    
    /**
     * TODO comment<br>
     * <br>
     *
     * @param strBuilder
     * @return
     */
    public static boolean isEmpty(final StringBuilder strBuilder) {
        return ((strBuilder == null) || (strBuilder.toString().trim().isEmpty()));
    }

    
    
    /**
     * TODO comment<br>
     *
     * @param <T>
     * @param array
     * @return
     */
    public static <T> boolean isEmpty(final T array[]) {
        return ((array == null) || (array.length <= 0));
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param collection
     * @return
     */
    public static boolean isEmpty(final Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param map
     * @return
     */
    public static boolean isEmpty(final Map<String, String> map) {
        return (map == null || map.isEmpty());
    }

    
    
    /**
     * TODO comment<br>
     *
     * @param value
     * @return
     */
    public static boolean isNotEmpty(final String value) {
        return !isEmpty(value);
    }

    
    
    /**
     * TODO comment<br>
     *
     * @param strBuilder
     * @return
     */
    public static boolean isNotEmpty(final StringBuilder strBuilder) {
        return !isEmpty(strBuilder);
    }

    
    
    /**
     * TODO comment<br>
     *
     * @param <T>
     * @param array
     * @return
     */
    public static <T> boolean isNotEmpty(final T array[]) {
        return !isEmpty(array);
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(final Collection<?> collection) {
        return (collection != null && !collection.isEmpty());
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param map
     * @return
     */
    public static boolean isNotEmpty(final Map<String, String> map) {
        return (map != null && !map.isEmpty());
    }


    
    /**
     * TODO comment<br>
     *
     * @param <T>
     * @param args
     * @return
     */
    public static <T> boolean anyNull(final T...args) {
        if (isEmpty(args)) return true;

        for (T t : args) {
            if (isNull(t)) return true;
        }

        return false;
    }

    
    
    /**
     * TODO comment<br>
     *
     * @param args
     * @return
     */
    public static boolean anyEmpty(final String... args) {
        if (isNull(args)) return true;

        for (String str : args) {
            if (isEmpty(str)) return true;
        }

        return false;
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param value
     * @return
     */
    public static String getSafeString(final String value) {
        if (value == null) return "";
        return value;
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param value
     * @return
     */
    public static Integer getSafeInteger(final Integer value) {
        if (value == null) return Integer.valueOf(0);
        return value;
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param value
     * @return
     */
    public static Long getSafeLong(final Long value) {
        if (value == null) return Long.valueOf(0);
        return value;
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param value
     * @return
     */
    public static Integer getIntegerFromString(final String value) {
        if (Commons.isNotNumeric(value)) return Integer.valueOf(0);
        return Integer.valueOf(value);
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param value
     * @return
     */
    public static Long getLongFromString(final String value) {
        if (Commons.isNotNumeric(value)) return Long.valueOf(0);
        return Long.valueOf(value);
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param value
     * @return
     */
    public static boolean isNumeric(final String value) {
        if (Commons.isEmpty(value)) return false;
        
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        
        formatter.parse(value, pos);
        
        return (value.length() == pos.getIndex());
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param value
     * @return
     */
    public static boolean isNotNumeric(final String value) {
        return !Commons.isNumeric(value);
    }
}

package com.sertorius.commons.util.lang;

import static org.junit.Assert.*;

import com.sertorius.commons.util.lang.Commons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CommonsTest {
    
    private final String NULL_VALUE = null;
    private final String FOO_VALUE = "foo";
    private final Object FOO_OBJECT = new Object();
    private final String NUMERIC_STRING = "1";
    private final String ANOTHER_NUMERIC_STRING = "1.0";
    private final String EMPTY_STRING = "";
    private final String EMPTY_STRING_WITH_SPACE = " ";
    
    
    
    @Before
    public void before() {
    }
    
    
    
    @After
    public void after() {
    }

    
    
    @Test
    public final void testIsNull() {
        assertTrue(Commons.isNull(NULL_VALUE));
        assertFalse(Commons.isNull(FOO_VALUE));
    }

    
    
    @Test
    public final void testIsNotNull() {
        assertTrue(Commons.isNotNull(FOO_VALUE));
        assertFalse(Commons.isNotNull(NULL_VALUE));
    }

    
    
    @Test
    public final void testIsEmptyString() {
        assertTrue(Commons.isEmpty(EMPTY_STRING));
        assertTrue(Commons.isEmpty(EMPTY_STRING_WITH_SPACE));
        assertFalse(Commons.isEmpty(FOO_VALUE));
    }

    
    
    @Test
    public final void testIsEmptyStringBuilder() {
        StringBuilder fooBuilder = new StringBuilder();
        assertTrue(Commons.isEmpty(fooBuilder));
        
        StringBuilder nullBuilder = null;
        assertTrue(Commons.isEmpty(nullBuilder));
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("foo");
        assertFalse(Commons.isEmpty(stringBuilder));
    }

    
    
    @Test
    public final void testIsEmptyTArray() {
        Integer[] intArray = {1, 2};
        assertFalse(Commons.isEmpty(intArray));
        
        Integer[] intEmptyArray = {};
        assertTrue(Commons.isEmpty(intEmptyArray));
        
        Integer[] intNullArray = null;
        assertTrue(Commons.isEmpty(intNullArray));
    }

    
    
    @Test
    public final void testIsEmptyCollectionOfQ() {
        Collection<String> nullCollection = null;
        assertTrue(Commons.isEmpty(nullCollection));
        
        List<String> stringList = new ArrayList<String>();
        stringList.add("foo");
        assertFalse(Commons.isEmpty(stringList));
        
        List<String> emptyStringList = new ArrayList<String>();
        assertTrue(Commons.isEmpty(emptyStringList));
        
        Map<String, String> stringMap = new HashMap<String, String>();
        stringMap.put("1", "foo");
        assertFalse(Commons.isEmpty(stringMap));
    }

    
    
    @Test
    public final void testIsNotEmptyString() {
        assertTrue(Commons.isNotEmpty(FOO_VALUE));
        assertFalse(Commons.isNotEmpty(NULL_VALUE));
    }

    
    
    @Test
    public final void testIsNotEmptyStringBuilder() {
        StringBuilder fooBuilder = new StringBuilder();
        assertFalse(Commons.isNotEmpty(fooBuilder));
        
        StringBuilder nullBuilder = null;
        assertFalse(Commons.isNotEmpty(nullBuilder));
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("foo");
        assertTrue(Commons.isNotEmpty(stringBuilder));
    }

    
    
    @Test
    public final void testIsNotEmptyTArray() {
        Integer[] intArray = {1, 2};
        assertTrue(Commons.isNotEmpty(intArray));
        
        Integer[] intEmptyArray = {};
        assertFalse(Commons.isNotEmpty(intEmptyArray));
        
        Integer[] intNullArray = null;
        assertFalse(Commons.isNotEmpty(intNullArray));
    }

    
    
    @Test
    public final void testIsNotEmptyCollectionOfQ() {
        Collection<String> nullCollection = null;
        assertFalse(Commons.isNotEmpty(nullCollection));
        
        List<String> stringList = new ArrayList<String>();
        stringList.add("foo");
        assertTrue(Commons.isNotEmpty(stringList));
        
        List<String> emptyStringList = new ArrayList<String>();
        assertFalse(Commons.isNotEmpty(emptyStringList));
        
        Map<String, String> stringMap = new HashMap<String, String>();
        stringMap.put("1", "foo");
        assertTrue(Commons.isNotEmpty(stringMap));
    }

    
    
    @Test
    public final void testAnyNull() {
        assertTrue(Commons.anyNull(NULL_VALUE, FOO_OBJECT));
        assertFalse(Commons.anyNull(FOO_OBJECT));
    }

    
    
    @Test
    public final void testAnyEmpty() {
        assertTrue(Commons.anyEmpty(FOO_VALUE, NULL_VALUE, EMPTY_STRING));
        assertTrue(Commons.anyEmpty(NULL_VALUE, EMPTY_STRING));
        assertFalse(Commons.anyEmpty(FOO_VALUE));
    }

    
    
    @Test
    public final void testGetSafeString() {
        assertEquals(EMPTY_STRING, Commons.getSafeString(NULL_VALUE));
        assertEquals(EMPTY_STRING, Commons.getSafeString(EMPTY_STRING));
        assertEquals(EMPTY_STRING_WITH_SPACE, Commons.getSafeString(EMPTY_STRING_WITH_SPACE));
        assertEquals(FOO_VALUE, Commons.getSafeString(FOO_VALUE));
    }

    
    
    @Test
    public final void testGetSafeInteger() {
        Integer invalidInteger = null;
        assertEquals(Integer.valueOf(0), Commons.getSafeInteger(invalidInteger));
        
        Integer validInteger = Integer.valueOf(1);
        assertEquals(Integer.valueOf(1), Commons.getSafeInteger(validInteger));
    }

    
    
    @Test
    public final void testGetSafeLong() {
        Long invalidLong = null;
        assertEquals(Long.valueOf(0), Commons.getSafeLong(invalidLong));
        
        Long validLong = Long.valueOf(1);
        assertEquals(Long.valueOf(1), Commons.getSafeLong(validLong));
    }

    
    
    @Test
    public final void testGetIntegerFromString() {
        assertEquals(Integer.valueOf(0), Commons.getIntegerFromString(NULL_VALUE));
        assertEquals(Integer.valueOf(0), Commons.getIntegerFromString(FOO_VALUE));
        assertEquals(Integer.valueOf(1), Commons.getIntegerFromString(NUMERIC_STRING));
    }

    
    
    @Test
    public final void testGetLongFromString() {
        assertEquals(Long.valueOf(0), Commons.getLongFromString(NULL_VALUE));
        assertEquals(Long.valueOf(0), Commons.getLongFromString(FOO_VALUE));
        assertEquals(Long.valueOf(1), Commons.getLongFromString(NUMERIC_STRING));
    }

    
    
    @Test
    public final void testIsNumeric() {
        assertTrue(Commons.isNumeric(NUMERIC_STRING));
        assertTrue(Commons.isNumeric(ANOTHER_NUMERIC_STRING));
        assertFalse(Commons.isNumeric(FOO_VALUE));
        assertFalse(Commons.isNumeric(NULL_VALUE));
    }

    
    
    @Test
    public final void testIsNotNumeric() {
        assertTrue(Commons.isNotNumeric(FOO_VALUE));
        assertTrue(Commons.isNotNumeric(NULL_VALUE));
        assertFalse(Commons.isNotNumeric(NUMERIC_STRING));
        assertFalse(Commons.isNotNumeric(ANOTHER_NUMERIC_STRING));
    }
}

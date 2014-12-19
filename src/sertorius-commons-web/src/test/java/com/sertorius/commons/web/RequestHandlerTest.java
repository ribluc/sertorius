package com.sertorius.commons.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.sertorius.commons.CharEncondig;
import com.sertorius.commons.RequestHandler;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;


public class RequestHandlerTest {
    
    @Test
    public final void testGetIPAddress() {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("username")).thenReturn("me");
        when(request.getParameter("password")).thenReturn("secret");
        
        //PrintWriter writer = new PrintWriter("somefile.txt");
        //when(response.getWriter()).thenReturn(writer);
        
        System.out.println(RequestHandler.getIPAddress(request));

        //new MyServlet().doPost(request, response);

        //verify(request, atLeast(1)).getParameter("username"); // only if you want to verify username was called...
        //writer.flush(); // it may not have been flushed yet...
        //assertTrue(FileUtils.readFileToString(new File("somefile.txt"), "UTF-8").contains("My Expected String"));
    }

    
    
    @Test
    public final void testGetStringValueHttpServletRequestString() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getParameter("foo")).thenReturn("Foo");
        when(request.getParameter("bar")).thenReturn(null);
        
        assertEquals("Foo", RequestHandler.getStringValue(request, "foo"));
        assertEquals(null, RequestHandler.getStringValue(request, "bar"));
        assertEquals(null, RequestHandler.getStringValue(request, "invalidParam"));
    }

    
    
    @Test
    public final void testGetStringValueHttpServletRequestStringCharEncondigCharEncondig() throws UnsupportedEncodingException {
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getParameter("foo")).thenReturn("Foo");
        when(request.getParameter("bar")).thenReturn(null);
        
        assertEquals("Foo", RequestHandler.getStringValue(request, "foo", CharEncondig.ISO_8859_1, CharEncondig.UTF8));
        assertEquals(null, RequestHandler.getStringValue(request, "bar", CharEncondig.ISO_8859_1, CharEncondig.UTF8));
        
        assertEquals("Foo", RequestHandler.getStringValue(request, "foo", CharEncondig.UTF8, CharEncondig.ISO_8859_1));
        assertEquals(null, RequestHandler.getStringValue(request, "bar", CharEncondig.UTF8, CharEncondig.ISO_8859_1));
    }

    
    
    @Test
    public final void testGetLongValue() {
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getParameter("longParam")).thenReturn("1");
        when(request.getParameter("stringParam")).thenReturn("foo");
        when(request.getParameter("nullParam")).thenReturn(null);
        
        assertEquals(Long.valueOf(1), RequestHandler.getLongValue(request, "longParam"));
        assertEquals(null, RequestHandler.getLongValue(request, "stringParam"));
        assertEquals(null, RequestHandler.getLongValue(request, "nullParam"));
    }

    
    
    @Test
    public final void testGetLongOrZeroValue() {
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getParameter("longParam")).thenReturn("1");
        when(request.getParameter("stringParam")).thenReturn("foo");
        when(request.getParameter("nullParam")).thenReturn(null);
        
        assertEquals(Long.valueOf(1), RequestHandler.getLongOrZeroValue(request, "longParam"));
        assertEquals(Long.valueOf(0), RequestHandler.getLongOrZeroValue(request, "stringParam"));
        assertEquals(Long.valueOf(0), RequestHandler.getLongOrZeroValue(request, "nullParam"));
    }

    
    
    @Test
    public final void testGetIntegerValue() {
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getParameter("intParam")).thenReturn("1");
        when(request.getParameter("stringParam")).thenReturn("foo");
        when(request.getParameter("nullParam")).thenReturn(null);
        
        assertEquals(Integer.valueOf(1), RequestHandler.getIntegerValue(request, "intParam"));
        assertEquals(null, RequestHandler.getIntegerValue(request, "stringParam"));
        assertEquals(null, RequestHandler.getIntegerValue(request, "nullParam"));
    }

    
    
    @Test
    public final void testGetIntegerOrZeroValue() {
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getParameter("intParam")).thenReturn("1");
        when(request.getParameter("stringParam")).thenReturn("foo");
        when(request.getParameter("nullParam")).thenReturn(null);
        
        assertEquals(Integer.valueOf(1), RequestHandler.getIntegerOrZeroValue(request, "intParam"));
        assertEquals(Integer.valueOf(0), RequestHandler.getIntegerOrZeroValue(request, "stringParam"));
        assertEquals(Integer.valueOf(0), RequestHandler.getIntegerOrZeroValue(request, "nullParam"));
    }
    
    
    
    @Test
    public final void testCoalesceIntegerValue() {
        
    }

    
    
    @Test
    public final void testGetJSONData() {
        String jsonInput = "{\"id\": 1, \"name\": \"John\"}";
        
        Foo foo = new Foo(Long.valueOf(1), "John");
        
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getParameter("validJSONParam")).thenReturn(jsonInput);
        
        Foo parsedFoo = (Foo) RequestHandler.getJSONData(request, "validJSONParam", Foo.class);
        
        assertEquals(foo.getId(), parsedFoo.getId());
        assertEquals(foo.getName(), parsedFoo.getName());
    }
    
    
    
    @Test
    public final void testGetInvalidJSONData() {
        String jsonInput = "{}";
        String emptyString = "";
        String invalidJSON = "foo";
        
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getParameter("emptyJSONParam")).thenReturn(jsonInput);
        when(request.getParameter("invalidJSONParam")).thenReturn(invalidJSON);
        when(request.getParameter("emptyStringParam")).thenReturn(emptyString);
        when(request.getParameter("nullJSONParam")).thenReturn(null);
        
        Foo invalidFoo = (Foo) RequestHandler.getJSONData(request, "emptyJSONParam", Foo.class);
        Foo invalidFoo3 = (Foo) RequestHandler.getJSONData(request, "emptyStringParam", Foo.class);
        Foo nullFoo = (Foo) RequestHandler.getJSONData(request, "nullJSONParam", Foo.class);
        
        assertEquals(null, invalidFoo.getId());
        assertEquals(null, invalidFoo.getName());
    }
}

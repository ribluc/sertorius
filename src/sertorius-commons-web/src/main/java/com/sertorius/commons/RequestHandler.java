package com.sertorius.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sertorius.commons.util.lang.Commons;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO comment<br>
 * 
 * @author caesar
 */
public final class RequestHandler {
    
    /**
     * TODO comment<br>
     * 
     * @param request
     * @return
     */
    public static final String getIPAddress(final HttpServletRequest request) {
        if (request == null) return null;
        
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) ipAddress = request.getRemoteAddr();
        
        return ipAddress;
    }
    

    
    public static final String getStringValue(final HttpServletRequest request, final String parameter) {
        return (String) request.getParameter(parameter);
    }
    
    
    
    public static final String getStringValue(
        final HttpServletRequest request,
        final String parameter,
        final CharEncondig fromEncoding,
        final CharEncondig toEncoding) throws UnsupportedEncodingException {
        
        if (request.getParameter(parameter) == null) return null;
        if (fromEncoding == null || toEncoding == null) return null;
        
        return new String(request.getParameter(parameter).getBytes(fromEncoding.getStringValue()), toEncoding.getStringValue());
    }
    
    
    
    public static final Long getLongValue(final HttpServletRequest request, final String parameter) {
        final String val = (String) request.getParameter(parameter);
        if (Commons.isNumeric(val)) return Long.valueOf(val);
        return null;
    }
    
    
    
    public static final Long getLongOrZeroValue(final HttpServletRequest request, final String parameter) {
        final String val = (String) request.getParameter(parameter);
        if (Commons.isNumeric(val)) return Long.valueOf(val);
        return Long.valueOf(0);
    }
    
    
    
    public static final Integer getIntegerValue(final HttpServletRequest request, final String parameter) {
        final String val = (String) request.getParameter(parameter);
        if (Commons.isNumeric(val)) return Integer.valueOf(val);
        return null;
    }
    
    
    
    public static final Integer getIntegerOrZeroValue(final HttpServletRequest request, final String parameter) {
        final String val = (String) request.getParameter(parameter);
        if (Commons.isNumeric(val)) return Integer.valueOf(val);
        return Integer.valueOf(0);
    }
    
    
    
    public static final Integer coalesceIntegerValue(final HttpServletRequest request, final String parameter, final int coalValue) {
        final String val = (String) request.getParameter(parameter);
        if (Commons.isNumeric(val)) return Integer.valueOf(val);
        return coalValue;
    }
    
    
    
    public static final Object getJSONData(final HttpServletRequest request, final String parameter, final Class<?> clazz) {
        final String val = (String) request.getParameter(parameter);
        
        if (Commons.isEmpty(val)) return null;
        
        final ObjectMapper mapper = new ObjectMapper();
        
        InputStream is = null;
        BufferedReader br = null;
        
        try {
            is = new ByteArrayInputStream(val.getBytes());
            br = new BufferedReader(new InputStreamReader(is));
     
            Object obj = mapper.readValue(br, clazz);
            
            return obj;
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        finally {
            if (is != null) try { is.close(); } catch (Exception eis) { }
            if (br != null) try { br.close(); } catch (Exception ebr) { }
        }
    }
}

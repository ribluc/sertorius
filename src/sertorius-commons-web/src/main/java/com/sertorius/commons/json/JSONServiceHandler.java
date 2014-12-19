package com.sertorius.commons.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * TODO comment<br>
 * 
 * @author luciano
 */
public class JSONServiceHandler {
    
    private static final int CACHE_DURATION_IN_SECOND = 60 * 5;
    private static final long CACHE_DURATION_IN_MS = CACHE_DURATION_IN_SECOND * 1000;
    

    
    /**
     * TODO comment<br>
     * 
     * @author caesar
     */
    public enum ResultCode {
        SERVICE_SUCCESS(1),
        SERVICE_ERROR(2),
        SERVICE_EXCEPTION(3),
        AUTHENTICATION_ERROR(4),
        VALIDATION_ERROR(5),
        SESSION_ERROR(6);
        
        private final int code;
        
        ResultCode(final int code) {
            this.code = code;
        }

        public int getIntValue() {
            return this.code;
        }
        
        public static ResultCode fromInt(final int value) {
            for (ResultCode cs : values()) {
                if (cs.getIntValue() == value) return cs;
            }
            return null;
        }
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param response
     * @param resultData
     * @throws IOException
     */
    public static final void getSimpleJSONServiceResult(
        final HttpServletResponse response,
        final Object resultData) throws IOException {
        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        
        final ObjectMapper mapper = new ObjectMapper();
        
        response.getWriter().print(mapper.writeValueAsString(resultData));
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param response
     * @param resultCode
     * @throws IOException
     */
    public static final void getJSONServiceResult(
        final HttpServletResponse response,
        final ResultCode resultCode) throws IOException {
        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        
        //TODO: Check escape chars (disableHtmlEscaping)
        final ObjectMapper mapper = new ObjectMapper();
        
        response.getWriter().print(mapper.writeValueAsString(new ServiceResult(resultCode.getIntValue())));
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param response
     * @param resultCode
     * @param resultData
     * @throws IOException
     */
    public static final void getJSONServiceResult(
        final HttpServletResponse response,
        final ResultCode resultCode,
        final Object resultData) throws IOException {
        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        
        final ObjectMapper mapper = new ObjectMapper();
        
        response.getWriter().print(mapper.writeValueAsString(new ServiceResult(resultCode.getIntValue(), resultData)));
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param response
     * @param resultCode
     * @param resultData
     * @throws IOException
     */
    public static final void getCachedJSONServiceResult(
        final HttpServletResponse response,
        final ResultCode resultCode,
        final Object resultData) throws IOException {
        
        final long now = System.currentTimeMillis();
        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Cache-Control", "max-age=" + CACHE_DURATION_IN_SECOND);
        response.addHeader("Cache-Control", "must-revalidate");
        response.setDateHeader("Last-Modified", now);
        response.setDateHeader("Expires", now + CACHE_DURATION_IN_MS);
        
        final ObjectMapper mapper = new ObjectMapper();
        
        response.getWriter().print(mapper.writeValueAsString(new ServiceResult(resultCode.getIntValue(), resultData)));
    }
}

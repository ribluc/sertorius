package com.sertorius.commons.json;

import java.io.Serializable;

/**
 * TODO comment<br>
 * 
 * @author caesar
 */
public class ServiceResult implements Serializable {

    private static final long serialVersionUID = -8070852196123227764L;
    
    private int resultCode;
    private Object resultData;
    

    
    /**
     * Constructor for <code>ServiceResult</code>
     */
    public ServiceResult() {
        super();
    }
    
    
    
    public ServiceResult(final int code) {
        this.resultCode = code;
    }
    
    
    
    /**
     * Constructor for <code>ServiceResult</code>
     * 
     * @param code
     * @param data
     */
    public ServiceResult(final int code, final Object data) {
        this.resultCode = code;
        this.resultData = data;
    }
    

    
    // ----- Getters/Setters
    
    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(final int resultCode) {
        this.resultCode = resultCode;
    }

    public Object getResultData() {
        return this.resultData;
    }

    public void setResultData(final Object resultData) {
        this.resultData = resultData;
    }
}

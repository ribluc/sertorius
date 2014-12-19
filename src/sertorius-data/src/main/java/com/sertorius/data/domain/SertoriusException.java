package com.sertorius.data.domain;

/**
 * Generic exception<br>
 * 
 * @author caesar
 */
public class SertoriusException extends Exception {

    private static final long serialVersionUID = -7863437137055708515L;



    /**
     * Constructor for <code>SertoriusException</code>
     */
    public SertoriusException() {
        super();
    }

    
    
    /**
     * Constructor for <code>SertoriusException</code>
     * 
     * @param message
     */
    public SertoriusException(final String message) {
        super(message);
    }

    
    
    /**
     * Constructor for <code>SertoriusException</code>
     * 
     * @param throwable
     */
    public SertoriusException(final Throwable throwable) {
        super(throwable);
    }

    
    
    /**
     * Constructor for <code>SertoriusException</code>
     * 
     * @param message
     * @param throwable
     */
    public SertoriusException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}

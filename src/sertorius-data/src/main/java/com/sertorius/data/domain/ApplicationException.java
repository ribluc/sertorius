package com.sertorius.data.domain;

/**
 * Generic application exception<br>
 * 
 * @author caesar
 */
public class ApplicationException extends SertoriusException {

    private static final long serialVersionUID = -7872197936763631683L;



    /***
     * Constructor for <code>ApplicationException</code>
     */
    public ApplicationException() {
        super();
    }

    
    
    /***
     * Constructor for <code>ApplicationException</code>
     * 
     * @param message
     */
    public ApplicationException(final String message) {
        super(message);
    }

    
    
    /***
     * Constructor for <code>ApplicationException</code>
     * 
     * @param throwable
     */
    public ApplicationException(final Throwable throwable) {
        super(throwable);
    }
    
    

    /***
     * Constructor for <code>ApplicationException</code>
     * 
     * @param message
     * @param throwable
     */
    public ApplicationException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}

package com.sertorius.data.dao;

/**
 * Generic exception for DAO class<br>
 * 
 * @author caesar
 */
public class DAOException extends Exception {

    private static final long serialVersionUID = 2435144401292674032L;



    /**
     * Constructor for <code>DAOException</code>
     */
    public DAOException() {
        super();
    }

    
    
    /**
     * Constructor for <code>DAOException</code>
     * 
     * @param message
     */
    public DAOException(final String message) {
        super(message);
    }

    
    
    /**
     * Constructor for <code>DAOException</code>
     * 
     * @param throwable
     */
    public DAOException(final Throwable throwable) {
        super(throwable);
    }

    
    
    /**
     * Constructor for <code>DAOException</code>
     * 
     * @param message
     * @param throwable
     */
    public DAOException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}

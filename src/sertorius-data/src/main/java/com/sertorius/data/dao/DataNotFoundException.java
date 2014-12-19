package com.sertorius.data.dao;

/**
 * Exception for data not found<br>
 * Used when an entity is not found in the data store<br>
 * 
 * @author caesar
 */
public class DataNotFoundException extends DAOException {

    private static final long serialVersionUID = 647928485746307478L;
    
    // Identifier to the data not found
    private String dataNotFound;

    
    
    /**
     * Constructor for <code>DataNotFoundException</code>
     */
    public DataNotFoundException() {
        super();
    }

    
    
    /**
     * Constructor for <code>DataNotFoundException</code>
     * 
     * @param message
     */
    public DataNotFoundException(final String message) {
        super(message);
    }

    
    
    /**
     * Constructor for <code>DataNotFoundException</code>
     * 
     * @param message
     * @param dataNotFound
     */
    public DataNotFoundException(final String message, final String dataNotFound) {
        super(message);
        this.dataNotFound = dataNotFound;
    }

    
    
    /**
     * Constructor for <code>DataNotFoundException</code>
     * 
     * @param throwable
     */
    public DataNotFoundException(final Throwable throwable) {
        super(throwable);
    }

    
    
    /**
     * Constructor for <code>DataNotFoundException</code>
     * 
     * @param message
     * @param throwable
     */
    public DataNotFoundException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    
    
    /**
     * Constructor for <code>DataNotFoundException</code>
     * 
     * @param message
     * @param dataNotFound
     * @param throwable
     */
    public DataNotFoundException(final String message, final String dataNotFound, final Throwable throwable) {
        super(message, throwable);
        this.dataNotFound = dataNotFound;
    }

    
    
    /**
     * Returns the data not found. Can be a record, object or entry
     * 
     * @return The data not found identifier
     */
    public final String getDataNotFound() {
        if (this.dataNotFound == null) return "";
        return this.dataNotFound;
    }

    
    
    /**
     * TODO comment<br>
     * 
     * @param dataNotFound
     */
    public final void setDataNotFound(final String dataNotFound) {
        this.dataNotFound = dataNotFound;
    }
}

package com.sertorius.data.domain;

/**
 * TODO comment<br>
 * 
 * @author caesar
 */
public class ObjectNotFoundException extends SertoriusException {

    private static final long serialVersionUID = -7951726078787909066L;
    
    private Class<?> className;

    
    
    /**
     * Constructor for <code>ObjectNotFoundException</code>.<br>
     * 
     * @param className
     */
    public ObjectNotFoundException(final Class<?> className) {
        this.className = className;
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @return
     */
    public String getClassName() {
        return this.className.getName();
    }
    
    
    
    @Override
    public String getMessage() {
        return "ObjectNotFoundException: " + this.getClassName();
    }
}

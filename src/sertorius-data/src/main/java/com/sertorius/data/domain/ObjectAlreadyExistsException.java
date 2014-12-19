package com.sertorius.data.domain;

/**
 * TODO comment<br>
 * 
 * @author caesar
 */
public class ObjectAlreadyExistsException extends SertoriusException {

    private static final long serialVersionUID = 7816438768847910573L;
    
    private Class<?> target;
    private String attributeName;
    private String attributeValue;
    
    
    
    /**
     * Constructor for <code>ObjectAlreadyExistsException</code>.<br>
     * 
     * @param target Class indicating the Object that already exists
     * @param attributeName Name of the identifier attribute from Object
     * @param attributeValue Value of the identifier attribute from Object
     */
    public ObjectAlreadyExistsException(final Class<?> target, final String attributeName, final String attributeValue) {
        this.target = target;
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @return
     */
    public final String getObjectName() {
        return this.target.getName();
    }
    
    
    
    /**
     * Returns the name of the identifier attribute<br>
     * 
     * @return The name of the identifier attribute
     */
    public String getAttributeName() {
        return this.attributeName;
    }
    
    
    
    /**
     * Returns the value of the identifier attribute<br>
     * 
     * @return The value of the identifier attribute
     */
    public String getAttributeValue() {
        return this.attributeValue;
    }
    
    
    
    @Override
    public String getMessage() {
        return new StringBuilder()
          .append("ObjectAlreadyExistsException->")
          .append("target=")
          .append(this.getObjectName())
          .append(",attributeName=")
          .append(this.getAttributeName())
          .append(",attributeValue=")
          .append(this.getAttributeValue())
          .toString();
    }
}

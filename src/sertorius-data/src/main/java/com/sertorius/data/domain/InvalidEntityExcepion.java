package com.sertorius.data.domain;

import java.text.MessageFormat;

/**
 * TODO comment<br>
 * 
 * @author caesar
 */
public class InvalidEntityExcepion extends SertoriusException {

    private static final long serialVersionUID = -9202099414171458954L;

    private static final String exceptionMessage = "{1} is a not valid Entity";
    
    private DomainEntity entity;
    private String rule;
    
    
    
    /**
     * TODO comment<br>
     * 
     * @return
     */
    private final Object[] getMessageParameters() {
        final Object[] parameters = { this.entity.getClass().getName() };
        return parameters;
    }
    
    
    
    /**
     * Constructor for <code>InvalidEntityExcepion</code>.<br>
     * 
     * @param entity
     */
    public InvalidEntityExcepion(final DomainEntity entity) {
        this.entity = entity;
    }
    
    
    
    /**
     * Constructor for <code>InvalidEntityExcepion</code>.<br>
     * 
     * @param entity
     * @param rule
     */
    public InvalidEntityExcepion(final DomainEntity entity, final String rule) {
        this.entity = entity;
        this.rule = rule;
    }
    
    
    
    @Override
    public String getMessage() {
        return MessageFormat.format(exceptionMessage, getMessageParameters());
    }

    
    
    // ----- Getters/Setters
    
    public String getRule() {
        return this.rule;
    }
}

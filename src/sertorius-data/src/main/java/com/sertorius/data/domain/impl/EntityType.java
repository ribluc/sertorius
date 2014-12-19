package com.sertorius.data.domain.impl;

import com.sertorius.data.domain.IDomainEntityType;

/**
 * TODO comment<br>
 * 
 * @author caesar
 */
public class EntityType implements IDomainEntityType {

    private static final long serialVersionUID = -1554421165044144281L;
    
    private Long id;
    private String name;
    
    
    
    /**
     * Constructor for <code>EntityType</code>
     */
    public EntityType() {
        super();
    }

    
    
    @Override
    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}

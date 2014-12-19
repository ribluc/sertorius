package com.sertorius.data.domain.impl;

import com.sertorius.data.domain.DomainEntityStatus;

/**
 * TODO comment<br>
 * 
 * @author caesar
 */
public class EntityStatus implements DomainEntityStatus {

    private static final long serialVersionUID = 1848405626014235019L;
    
    private Long id;
    private String name;
    
    
    
    /**
     * Constructor for <code>EntityStatus</code>
     */
    public EntityStatus() {
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

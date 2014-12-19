package com.sertorius.data.domain;

import java.io.Serializable;

/**
 * DomainEntity key<br>
 *
 * @author caesar
 */
public abstract class EntityKey implements Serializable {

    private static final long serialVersionUID = 6678092167572835083L;

    
    
    /**
     * TODO comment<br>
     *
     * @return
     */
    public abstract Long getLongValue();

    
    
    /**
     * TODO comment<br>
     *
     * @return
     */
    public abstract String getKind();
}

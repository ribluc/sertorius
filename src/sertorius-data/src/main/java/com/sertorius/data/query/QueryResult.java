package com.sertorius.data.query;

import java.io.Serializable;

/**
 * Query Result basic Interface<br>
 *
 * @author caesar
 */
public abstract interface QueryResult extends Serializable {

    /**
     * Returns the total of results<br>
     *
     * @return The total of results found
     */
    public abstract int count();
}

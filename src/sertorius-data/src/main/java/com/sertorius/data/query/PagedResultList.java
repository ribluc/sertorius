package com.sertorius.data.query;

import com.sertorius.data.domain.DomainEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Paged Query result representation<br>
 *
 * @param <E> An DomainEntity implementation
 * @author caesar
 */
public class PagedResultList<E extends DomainEntity> implements QueryResult {

    private static final long serialVersionUID = -4894910568199179423L;
    
    private List<E> data;
    private int numOfRecords;
    private int pageCount;

    
    
    /**
     * Constructor for <code>PagedResultList</code>.<br>
     *
     * @param count The total of results found
     * @param data The result list
     */
    public PagedResultList(final int count, final List<E> data) {
        if (count <= 0 || data == null || data.isEmpty()) {
            this.data = new ArrayList<E>();
        }
        else {
            this.numOfRecords = count;
            this.data = data;
        }
    }
    
    
    
    /**
     * Constructor for <code>PagedResultList</code>.<br>
     * 
     * @param count
     * @param pageCount
     * @param data
     */
    public PagedResultList(final int count, final int pageCount, final List<E> data) {
        if (count <= 0 || pageCount <= 0 || data == null || data.isEmpty()) {
            this.data = new ArrayList<E>();
        }
        else {
            this.numOfRecords = count;
            this.pageCount = pageCount;
            this.data = data;
        }
    }

    
    
    @Override
    public int count() {
        return this.numOfRecords;
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @return
     */
    public int getPageCount() {
        return this.pageCount;
    }

    
    
    /**
     * Returns the result list<br>
     *
     * @return the result list
     */
    public List<E> getResults() {
        return this.data;
    }

    
    
    /**
     * Sort the result list by the given comparator<br>
     *
     * @param comparator A valid <code>Comparator</code>
     */
    public void order(final Comparator<E> comparator) {
        Collections.sort(this.data, comparator);
    }
}

package com.sertorius.data.query;

import com.sertorius.data.domain.DomainEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Paged infinite List<br>
 *
 * @param <E> An DomainEntity implementation
 * @author caesar
 */
public class PagedInfiniteList<E extends DomainEntity> implements QueryResult {

    private static final long serialVersionUID = -2595466248446059506L;
    
    private final List<E> data;
    private int numOfRecords;
    private E lastItem;
    
    
    
    private void setLastItem(final List<E> data) {
        if (data == null || data.size() < 1) return;
        this.lastItem = data.get(data.size() - 1);
    }

    
    
    /**
     * Constructor for <code>PagedTimelineList</code>.<br>
     * 
     * @param data
     */
    public PagedInfiniteList(final List<E> data) {
        this.numOfRecords = 0;
        this.data = data;
        this.setLastItem(this.data);
    }
    
    
    
    /**
     * Constructor for <code>PagedTimelineList</code>.<br>
     *
     * @param count The total of results found
     * @param data The result list
     */
    public PagedInfiniteList(final int count, final List<E> data) {
        if (count <= 0 || data == null || data.isEmpty()) {
            this.data = new ArrayList<E>();
        }
        else {
            this.numOfRecords = count;
            this.data = data;
            this.setLastItem(this.data);
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
    public final E getLastItem() {
        return this.lastItem;
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
    public void sort(final Comparator<E> comparator) {
        Collections.sort(this.data, comparator);
    }
}

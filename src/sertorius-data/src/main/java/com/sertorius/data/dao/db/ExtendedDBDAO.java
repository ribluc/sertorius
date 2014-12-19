package com.sertorius.data.dao.db;

import com.sertorius.data.dao.DAOException;
import com.sertorius.data.domain.DomainEntity;

import java.sql.Connection;
import java.util.Collection;

/***
 * Extended DB DAO interface<br>
 * 
 * @param <E> An DomainEntity implementation
 * @author caesar
 */
public interface ExtendedDBDAO<E extends DomainEntity> extends DBDAO<E> {

    /**
     * TODO comment<br>
     * 
     * @param conn
     * @return
     * @throws DAOException
     */
    public int count(Connection conn) throws DAOException;

    
    
    /**
     * TODO comment<br>
     * 
     * @param conn
     * @param e
     * @return
     * @throws DAOException
     */
    public Collection<E> retrieveCollection(Connection conn, E e) throws DAOException;
}

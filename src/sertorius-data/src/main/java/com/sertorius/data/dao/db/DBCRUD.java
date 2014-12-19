package com.sertorius.data.dao.db;

import com.sertorius.data.dao.DAOException;
import com.sertorius.data.domain.DomainEntity;

import java.sql.Connection;

/**
 * Generic DB CRUD DAO<br>
 *
 * @param <E> An DomainEntity implementation parameter
 * @see <code>DomainEntity</code>
 * @author caesar
 */
public interface DBCRUD<E extends DomainEntity> extends DBDAO<E> {

    /**
     * TODO comment<br>
     * 
     * @param connection
     * @param entity
     * @throws DAOException
     */
    public void create(Connection connection, E entity) throws DAOException;

    
    
    /**
     * TODO comment<br>
     * 
     * @param connection
     * @param entity
     * @throws DAOException
     */
    public void update(Connection connection, E entity) throws DAOException;

    
    
    /**
     * TODO comment<br>
     * 
     * @param connection
     * @param entity
     * @throws DAOException
     */
    public void remove(Connection connection, E entity) throws DAOException;

    
    
    /**
     * TODO comment<br>
     * 
     * @param connection
     * @param entity
     * @return
     * @throws DAOException
     */
    public E retrieve(Connection connection, E entity) throws DAOException;
}

package com.sertorius.data.dao.db;

import com.sertorius.data.dao.DAOException;
import com.sertorius.data.domain.DomainEntity;

import java.sql.Connection;

/***
 * Extended DB CRUD interface with check methods<br>
 *
 * @param <E> An <code>DomainEntity</code> implementation
 * @see <code>DomainEntity</code>
 * @author caesar
 */
public interface ExtendedDBCRUD<E extends DomainEntity> extends DBCRUD<E> {

    /**
     * TODO comment<br>
     * 
     * @param connection
     * @param entity
     * @return
     * @throws DAOException
     */
    public boolean contains(Connection connection, E entity) throws DAOException;

    
    
    /**
     * TODO comment<br>
     * 
     * @param connection
     * @param entity
     * @return
     * @throws DAOException
     */
    public boolean canUpdate(Connection connection, E entity) throws DAOException;
}

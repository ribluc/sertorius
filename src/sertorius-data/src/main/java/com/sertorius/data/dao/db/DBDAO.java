package com.sertorius.data.dao.db;

import com.sertorius.data.dao.DAO;
import com.sertorius.data.domain.DomainEntity;

/**
 * Generic DB DAO Interface<br>
 *
 * @param <E> An DomainEntity implementation
 * @author caesar
 */
public interface DBDAO<E extends DomainEntity> extends DAO {
    // DB DAO Interface
}

package com.sertorius.data.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * Basic DAO with JDBC functionalities<br>
 * 
 * @author caesar
 */
public abstract class AbstractDAO {
    
    private DataSource dataSource;
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param dataSource
     * @throws SQLException
     */
    protected void setConnection(final DataSource dataSource) throws SQLException {
        if (dataSource == null) throw new SQLException("Invalid DataSource: dataSource cannot be null");
        this.dataSource = dataSource;
    }
    
    

    /**
     * TODO comment<br>
     * 
     * @return
     * @throws SQLException
     */
    protected Connection getConnection() throws SQLException {
        if (this.dataSource == null) throw new SQLException("Invalid DataSource: dataSource cannot be null");
        return this.dataSource.getConnection();
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param connection
     */
    protected void closeConnection(final Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) connection.close();
        }
        catch (Exception e) {
            // No need to throw exception
        }
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param resultSet
     */
    protected void closeResultSet(final ResultSet resultSet) {
        try {
            if (resultSet != null && !resultSet.isClosed()) resultSet.close();
        }
        catch (Exception e) {
            // No need to throw exception
        }
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param preparedStatement
     */
    protected void closePreparedStatement(final PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null && !preparedStatement.isClosed()) preparedStatement.close();
        }
        catch (Exception e) {
            // No need to throw exception
        }
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param connection
     */
    protected void safeRollback(final Connection connection) {
        try {
            connection.rollback();
        }
        catch (Exception e) {
            // No need to throw exception
        }
    }
}

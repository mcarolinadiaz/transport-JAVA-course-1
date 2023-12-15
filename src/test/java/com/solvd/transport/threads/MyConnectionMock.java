package com.solvd.transport.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import static org.mockito.Mockito.*;

public class MyConnectionMock implements Connection {
    private static final Logger LOGGER = LogManager.getLogger(MyConnectionMock.class);

    public MyConnectionMock() {

    }
    @Override
    public Statement createStatement() throws SQLException {
        return mock(Statement.class);
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return mock(PreparedStatement.class);
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return mock(CallableStatement.class);
    }

    /**
     * @param sql an SQL statement that may contain one or more '?'
     *            parameter placeholders
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public String nativeSQL(String sql) throws SQLException {
        return null;
    }

    /**
     * @param autoCommit {@code true} to enable auto-commit mode;
     *                   {@code false} to disable it
     * @throws SQLException
     */
    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        LOGGER.debug("setAutoCommit called with value: {}", autoCommit);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return false;
    }

    @Override
    public void commit() throws SQLException {

    }

    @Override
    public void rollback() throws SQLException {

    }

    @Override
    public void close() throws SQLException {

    }

    @Override
    public boolean isClosed() throws SQLException {
        return false;
    }

    /**
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return null;
    }

    /**
     * @param readOnly {@code true} enables read-only mode;
     *                 {@code false} disables it
     * @throws SQLException
     */
    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        // Does nothing as we are mocking this function
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return false;
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {

    }

    @Override
    public String getCatalog() throws SQLException {
        return null;
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {

    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return Connection.TRANSACTION_NONE;
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return null;
    }

    @Override
    public void clearWarnings() throws SQLException {

    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return null;
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return null;
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return null;
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

    }

    @Override
    public void setHoldability(int holdability) throws SQLException {

    }

    @Override
    public int getHoldability() throws SQLException {
        return 0;
    }

    /**
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public Savepoint setSavepoint() throws SQLException {
        return null;
    }

    /**
     * @param name a {@code String} containing the name of the savepoint
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return null;
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {

    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {

    }

    /**
     * @param resultSetType        one of the following {@code ResultSet}
     *                             constants:
     *                             {@code ResultSet.TYPE_FORWARD_ONLY},
     *                             {@code ResultSet.TYPE_SCROLL_INSENSITIVE}, or
     *                             {@code ResultSet.TYPE_SCROLL_SENSITIVE}
     * @param resultSetConcurrency one of the following {@code ResultSet}
     *                             constants:
     *                             {@code ResultSet.CONCUR_READ_ONLY} or
     *                             {@code ResultSet.CONCUR_UPDATABLE}
     * @param resultSetHoldability one of the following {@code ResultSet}
     *                             constants:
     *                             {@code ResultSet.HOLD_CURSORS_OVER_COMMIT} or
     *                             {@code ResultSet.CLOSE_CURSORS_AT_COMMIT}
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return null;
    }

    /**
     * @param sql                  a {@code String} object that is the SQL statement to
     *                             be sent to the database; may contain one or more '?' IN
     *                             parameters
     * @param resultSetType        one of the following {@code ResultSet}
     *                             constants:
     *                             {@code ResultSet.TYPE_FORWARD_ONLY},
     *                             {@code ResultSet.TYPE_SCROLL_INSENSITIVE}, or
     *                             {@code ResultSet.TYPE_SCROLL_SENSITIVE}
     * @param resultSetConcurrency one of the following {@code ResultSet}
     *                             constants:
     *                             {@code ResultSet.CONCUR_READ_ONLY} or
     *                             {@code ResultSet.CONCUR_UPDATABLE}
     * @param resultSetHoldability one of the following {@code ResultSet}
     *                             constants:
     *                             {@code ResultSet.HOLD_CURSORS_OVER_COMMIT} or
     *                             {@code ResultSet.CLOSE_CURSORS_AT_COMMIT}
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return null;
    }

    /**
     * @param sql                  a {@code String} object that is the SQL statement to
     *                             be sent to the database; may contain on or more '?' parameters
     * @param resultSetType        one of the following {@code ResultSet}
     *                             constants:
     *                             {@code ResultSet.TYPE_FORWARD_ONLY},
     *                             {@code ResultSet.TYPE_SCROLL_INSENSITIVE}, or
     *                             {@code ResultSet.TYPE_SCROLL_SENSITIVE}
     * @param resultSetConcurrency one of the following {@code ResultSet}
     *                             constants:
     *                             {@code ResultSet.CONCUR_READ_ONLY} or
     *                             {@code ResultSet.CONCUR_UPDATABLE}
     * @param resultSetHoldability one of the following {@code ResultSet}
     *                             constants:
     *                             {@code ResultSet.HOLD_CURSORS_OVER_COMMIT} or
     *                             {@code ResultSet.CLOSE_CURSORS_AT_COMMIT}
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return null;
    }

    /**
     * @param sql               an SQL statement that may contain one or more '?' IN
     *                          parameter placeholders
     * @param autoGeneratedKeys a flag indicating whether auto-generated keys
     *                          should be returned; one of
     *                          {@code Statement.RETURN_GENERATED_KEYS} or
     *                          {@code Statement.NO_GENERATED_KEYS}
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return null;
    }

    /**
     * @param sql           an SQL statement that may contain one or more '?' IN
     *                      parameter placeholders
     * @param columnIndexes an array of column indexes indicating the columns
     *                      that should be returned from the inserted row or rows
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return null;
    }

    @Override
    public Clob createClob() throws SQLException {
        return null;
    }

    /**
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public Blob createBlob() throws SQLException {
        return null;
    }

    /**
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public NClob createNClob() throws SQLException {
        return null;
    }

    /**
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public SQLXML createSQLXML() throws SQLException {
        return null;
    }

    /**
     * @param timeout The time in seconds to wait for the database operation
     *                used to validate the connection to complete.  If the
     *                timeout period expires before the operationcompletes,
     *                this method returns false.  A value of 0 indicates a
     *                timeout is not applied to the database operation.
     * @return false, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public boolean isValid(int timeout) throws SQLException {
        return false;
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {

    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {

    }

    /**
     * @param name The name of the client info property to retrieve
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public String getClientInfo(String name) throws SQLException {
        return null;
    }

    /**
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public Properties getClientInfo() throws SQLException {
        return null;
    }

    /**
     * @param typeName the SQL name of the type the elements of the array map to. The typeName is a
     *                 database-specific name which may be the name of a built-in type, a user-defined type or a standard  SQL type supported by this database. This
     *                 is the value returned by {@code Array.getBaseTypeName}
     * @param elements the elements that populate the returned object
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return null;
    }

    /**
     * @param typeName   the SQL type name of the SQL structured type that this {@code Struct}
     *                   object maps to. The typeName is the name of  a user-defined type that
     *                   has been defined for this database. It is the value returned by
     *                   {@code Struct.getSQLTypeName}.
     * @param attributes the attributes that populate the returned object
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return null;
    }

    @Override
    public void setSchema(String schema) throws SQLException {

    }

    /**
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public String getSchema() throws SQLException {
        return null;
    }

    @Override
    public void abort(Executor executor) throws SQLException {

    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {

    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return 0;
    }

    /**
     * @param iface A Class defining an interface that the result must implement.
     * @param <T>
     * @return null, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    /**
     * @param iface a Class defining an interface.
     * @return false, as we are mocking this function.
     * @throws SQLException
     */
    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}

package com.solvd.transport.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(MyConnectionPool.class);

    private static MyConnectionPool instance;
    // collection from java.util.concurrent package.
    private BlockingQueue<Connection> connections;
    private static final int POOL_SIZE = 10;
    private MyConnectionPool() {
        connections = new ArrayBlockingQueue<>(POOL_SIZE);
        initializePool();
    }
    public static synchronized MyConnectionPool getInstance() {
        if (instance == null) {
            instance = new MyConnectionPool();
        }
        return instance;
    }
    private void initializePool() {
        for (int i=0; i < POOL_SIZE; i++) {
            /*
            try {
                Connection connection = null;
                connections.add(connection);
            } catch(SQLException e) {
                LOGGER.error(e.getMessage());
            }*/
        }
    }

    public Connection getConnection() throws InterruptedException {
        return connections.take();
    }

    public void releaseConnection(Connection connection) throws InterruptedException {
        connections.put(connection);
    }
}

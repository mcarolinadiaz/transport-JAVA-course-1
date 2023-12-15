package com.solvd.transport.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(MyConnectionPool.class);

    private static MyConnectionPool instance;
    // collection from java.util.concurrent package.
    private BlockingQueue<Connection> connections;
    private static final int POOL_SIZE = 5;
    private MyConnectionPool() {
        connections = new ArrayBlockingQueue<>(POOL_SIZE);
        initializePool();
    }
    public static MyConnectionPool getInstance() {
        if (instance == null) {
            // to introduce the double check. it ensures that is threadsafe and lazy initialized in multithreading.
            synchronized (MyConnectionPool.class) {
                if (instance == null) {
                    instance = new MyConnectionPool();
                }
            }
        }
        return instance;
    }

    /**
     * Initialize collection connections.
     * It doesn't throw exception as we are mocking this connection pool.
     */
    private void initializePool() {
        for (int i=0; i < POOL_SIZE; i++) {
            Connection connection = new MyConnectionMock();
            connections.add(connection);
        }
    }

    public Connection getConnection() throws InterruptedException {
        return connections.take();
    }

    public void releaseConnection(Connection connection) throws InterruptedException {
        connections.put(connection);
    }
}

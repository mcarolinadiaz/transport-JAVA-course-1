package com.solvd.transport.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

public class MyThreadImplemented implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(MyThreadImplemented.class);
    @Override
    public void run() {
        MyConnectionPool connectionPool = MyConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            LOGGER.info("The thread implemented is running.");
            Thread.sleep(1200);
            connectionPool.releaseConnection(connection);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

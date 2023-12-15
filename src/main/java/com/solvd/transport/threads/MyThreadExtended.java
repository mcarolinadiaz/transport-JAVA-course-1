package com.solvd.transport.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

public class MyThreadExtended extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(MyThreadExtended.class);
    @Override
    public void run() {
        MyConnectionPool connectionPool = MyConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            LOGGER.info("The thread extended is running.");
            Thread.sleep(1000);
            connectionPool.releaseConnection(connection);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.solvd.transport.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MyThreadExtended extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(MyThreadExtended.class);
    /*
    @Override
    public void run() {
        try {
            MyConnectionPool connectionPool = MyConnectionPool.getInstance();
            Connection connection = connectionPool.getConnection();
            try {
                LOGGER.info("The thread extended is running.");
                Thread.sleep(1000);
            } finally {
                connectionPool.releaseConnection(connection);
            }
        } catch (InterruptedException | RuntimeException e) {
            LOGGER.error("Error in thread extended: " + e.getMessage(), e);
        }
    }*/
    @Override
    public void run() {
        try {
            MyConnectionPool connectionPool = MyConnectionPool.getInstance();
            CompletableFuture<Connection> completableFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    return connectionPool.getConnection();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            LOGGER.info("The thread extended is running.");
            Thread.sleep(1000);
            // Handle InterruptedException and ExecutionException
            completableFuture.handle((connection, ex) -> {
                if (ex != null) {
                    LOGGER.error("Error in CompletableFuture: " + ex.getMessage(), ex);
                } else {
                    try {
                        connectionPool.releaseConnection(connection);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                return null; // or handle the result accordingly
            }).get(); // to wait for completion
        } catch (InterruptedException | RuntimeException | ExecutionException e) {
            throw new RuntimeException(e); // checked exception in RuntimeException
        }
    }
}

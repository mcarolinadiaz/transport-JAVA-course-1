package com.solvd.transport.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThreadExtended extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(MyThreadExtended.class);
    @Override
    public void run() {
        LOGGER.info("The thread is running.");
    }
}

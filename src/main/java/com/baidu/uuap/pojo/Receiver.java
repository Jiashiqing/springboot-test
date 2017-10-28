package com.baidu.uuap.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

//@Component
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
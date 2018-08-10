package com.luobosi.juc.thread;

import java.io.IOException;

public class VolatileTest {

    public static void main(String[] args) throws IOException {
        VolatileThreads vt = new VolatileThreads();

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            vt.testA();
        }, "Thread ONE");

        Thread t2 = new Thread(() -> vt.testB(), "Thread TWO");

        t2.start();
        t1.start();

        System.in.read();
    }

}
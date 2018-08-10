package com.luobosi.juc.thread;

public class VolatileThreads {

    private Object o = null;
    private int i = 0;
    private volatile boolean flag = false;


    public void testA() {
        i = 1;
        flag = true;
        o = new Object();

        System.out.println(Thread.currentThread().getName() + "--- 赋值");
    }

    private volatile boolean bjj = false;

    public void testB() {
        while (true) {
             System.out.println("");
            if (o != null) {
                System.out.println("========");
            }
        }
    }

}


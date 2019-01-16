package com.luobosi.study.juc.thread.pool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestThreadPoolTask implements Runnable {

    private int id;
    private String name;


    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ",id:" + this.id);
    }


}
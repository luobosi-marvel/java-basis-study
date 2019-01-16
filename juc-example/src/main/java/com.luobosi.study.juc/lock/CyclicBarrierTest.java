package com.luobosi.study.juc.lock;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier;

    static class CyclicBarrierThread extends Thread{
        public void run() {
            System.out.println(Thread.currentThread().getName() + "到了");
            //等待
            try {
                // todo： 在这里等待别人，等别人执行完了，才能继续往下执行
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + "执行完了");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("人到齐了，开会吧...."));

        for(int i = 0 ; i < 5 ; i++){
            new CyclicBarrierThread().start();
        }
    }
}
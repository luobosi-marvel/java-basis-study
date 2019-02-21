package com.luobosi.study.juc.thread.pool;

import java.util.Random;

public class Demo {

    private static ThreadLocal<Integer> threadData = new ThreadLocal<>();
    private static ThreadLocal<String> threadDataA = new ThreadLocal<>();

    /**
     * @param args
     */
    public static void main(String[] args) {

        WordThread thread1 = new WordThread(threadData, threadDataA);
        WordThread thread2 = new WordThread(threadData, threadDataA);

        thread1.start();
        thread2.start();
            
        
        System.out.println(Thread.currentThread().getName()+" 执行完毕");

    }

}

class WordThread extends Thread {
    private ThreadLocal<Integer> mThreadData;

    private ThreadLocal<String> mThreadDataA;

    public WordThread(ThreadLocal<Integer> threadData, ThreadLocal<String> mThreadDataA) {
        this.mThreadData = threadData;
        this.mThreadDataA = mThreadDataA;
    }

    /* (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        super.run();
        System.out.println("WordThread:" + Thread.currentThread().getName());

        int dataIn = new Random().nextInt(10);

        mThreadData.set(dataIn);
        mThreadData.set(6);
        mThreadData.set(7);
        mThreadData.set(8);
        mThreadData.set(9);

        mThreadDataA.set("marvel");
        mThreadDataA.set("ererer");
        
        // 获取数据
        int dataOut = mThreadData.get();
        System.out.println(dataOut);

    }
}

/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.fe;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * NewThread
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-16
 */
public class NewThread {
    public static void main(String[] args) throws InterruptedException {
        //EmailÊÇÒ»¸öÊµÌåÀà£¬°üº¬username passwordÁ½¸öÊôÐÔ
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));

        LinkedList<Email> emailList = new LinkedList<Email>();//¼ÙÉèlistÖÐÓÐ1WÌõÊý¾Ý
        for (int i = 0; i < 10; i++) {
            emailList.add(new Email(String.valueOf(i)));
        }
        Run s = new Run(emailList);
        for (int i = 0; i < 3; i++) {
            executor.execute(s);
        }
        System.out.println("ÒÑÍê³É£º" + executor.getActiveCount());
        executor.shutdown();
    }
}

class Email {
    String username;

    public Email() {
    }

    public Email(String username) {
        this.username = username;
    }

    public String getUserName() {
        return username;
    }
}

class Run implements Runnable {
    int i = 0;
    LinkedList<Email> emailList;

    public Run(LinkedList<Email> emailList) {
        this.emailList = emailList;
    }

    @Override
    public void run() {
        Email email = null;
        while (true) {
            synchronized (emailList) {
                if (i < 100) {
//                    email=emailList.get(i);
//                	emailList.removeFirst();
                    System.out.println(Thread.currentThread().getName() + "         email--" + i);
                    i++;
                } else {
                    break;
                }
            }
        }
    }
}
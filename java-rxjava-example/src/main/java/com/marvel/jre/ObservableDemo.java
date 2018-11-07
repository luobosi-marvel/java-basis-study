/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.jre;

import io.reactivex.subjects.ReplaySubject;

/**
 * ObservableDemo
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-01
 */
public class ObservableDemo {

    public static void main(String[] args) {
        ObservableDemo observableDemo = new ObservableDemo();
        ReplaySubject<Object>  observable = observableDemo.observable1();

        observableDemo.observable2(observable);

        observable.subscribe(System.out::println,
                throwable -> System.out.println("replaySubject onError"),
                () -> System.out.println("replaySubject:complete"));
    }


    public ReplaySubject<Object> observable1() {
        ReplaySubject<Object> replaySubject = ReplaySubject.create();

        replaySubject.onNext("replaySubject2");
        replaySubject.onNext("replaySubject3");
        replaySubject.onNext("replaySubject4");
        return replaySubject;
    }


    public ReplaySubject<Object> observable2(ReplaySubject<Object> replaySubject) {


        replaySubject.onNext("replaySubject5");
        replaySubject.onNext("replaySubject6");
        replaySubject.onNext("replaySubject7");
        return replaySubject;
    }

}

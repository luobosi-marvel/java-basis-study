/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.jre;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * RxJavaDemo5
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-18
 */
public class RxJavaDemo5 {

    public static void main(String[] args) {
        RxJavaDemo5 rxJavaDemo5 = new RxJavaDemo5();

        rxJavaDemo5.asyncSubject();
        System.out.println("===============");
        rxJavaDemo5.behaviorSubject();
        System.out.println("===============");
        rxJavaDemo5.replaySubject();
        System.out.println("===============");
        rxJavaDemo5.publishSubject();
    }

    private void asyncSubject() {
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.onNext("asyncSubject1");
        subject.onNext("asyncSubject2");
        subject.onComplete();

        subject.subscribe(
                s -> System.out.println(s),
                error -> System.out.println("asyncSubject onError"),
                () -> System.out.println("asyncSubject: complete")
        );
    }

    private void behaviorSubject() {
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("behaviorSubject1");
        subject.subscribe(
                s -> System.out.println(s),
                error -> System.out.println("behaviorSubject onError"),
                () -> System.out.println("behaviorSubject: complete")
        );

        subject.onNext("behaviorSubject2");
        subject.onNext("behaviorSubject3");
    }

    private void replaySubject() {
        // todo: 如果将 create() 改成 createWithSize(1),表示只缓存订阅前最后发送的一条数据
        // todo: ReplaySubject 除了可以限制缓存数据的数量，还能限制缓存的时间，使用 createWithTime()
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.onNext("replaySubject1");
        subject.onNext("replaySubject2");

        subject.subscribe(
                s -> System.out.println(s),
                error -> System.out.println("replaySubject onError"),
                () -> System.out.println("replaySubject: complete")
        );

        subject.onNext("replaySubject3");
        subject.onNext("replaySubject4");
    }

    private void publishSubject() {
        // Observer 只接收 PublishSubject 被订阅之后发送的数据
        PublishSubject<String> subject = PublishSubject.create();
        subject.onNext("publishSubject1");
        subject.onNext("publishSubject2");
        // 注意，因为在 subject 订阅之前就执行了 onComplete() 方法，所以无法发射数据
        subject.onComplete();

        subject.subscribe(
                s -> System.out.println(s),
                error -> System.out.println("publishSubject onError"),
                () -> System.out.println("publishSubject: complete")
        );

        subject.onNext("publishSubject3");
        subject.onNext("publishSubject4");
    }

}

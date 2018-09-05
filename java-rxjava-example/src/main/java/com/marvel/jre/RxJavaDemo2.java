/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.jre;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * RxJavaDemo2
 *
 * @author luobosi@2dfire.com
 * @since 2018-09-04
 */
public class RxJavaDemo2 {

    /**
     * Subject 作为一个 Observable 时，可以不停的调用 onNext() 来发送事件，直至遇到 onComplete() 才会结束。
     * Subject 不是线程安全的
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        RxJavaDemo2 rxJavaDemo2 = new RxJavaDemo2();
        rxJavaDemo2.asyncSubject();
        System.out.println();
        rxJavaDemo2.behaviorSubject();
        System.out.println();
        rxJavaDemo2.replaySubject();
        System.out.println();
        rxJavaDemo2.publishSubject();
    }

    /**
     * Observer 会接收 AsyncSubject 的 onComplete() 之前的最后一个数据
     */
    private void asyncSubject() {
        AsyncSubject<Object> asyncSubject = AsyncSubject.create();

        asyncSubject.onNext("asyncSubject1");
        asyncSubject.onNext("asyncSubject2");
        // asyncSubject.onComplete() 必须要调用才会开始发送数据，否则观察者将不接收任何数据
        // 可以将 asyncSubject.onComplete() 换顺序
        asyncSubject.onComplete();
        asyncSubject.subscribe(s -> System.out.println("asyncSubject: " + s),
                // 有异常才会输出
                throwable -> System.out.println("asyncSubject onError"),
                () -> System.out.println("asyncSubject:complete"));

        asyncSubject.onNext("asyncSubject3");
        asyncSubject.onNext("asyncSubject4");
    }

    /**
     * Observer 会先接收到 BehaviorSubject 被订阅之前的最后一个数据，再接收订阅之后发射过来的数据。
     * 如果 BehaviorSubject 被订阅之前没有发送任何数据，则会发送一个默认数据。
     *
     * BehaviorSubject 每次只会发射调用 subject() 方法之前的最后一个事件和调用 subscribe() 方法之后的事件
     */
    private void behaviorSubject() {
        BehaviorSubject<Object> behaviorSubject = BehaviorSubject.createDefault("defaultBehaviorSubject");

        //
        behaviorSubject.subscribe(System.out::println,
                // 有异常才会输出
                throwable -> System.out.println("behaviorSubject onError"),
                () -> System.out.println("behaviorSubject:complete"));

        behaviorSubject.onNext("behaviorSubject1");
        behaviorSubject.onNext("behaviorSubject2");

    }

    /**
     * ReplaySubject 会发射所有来自原始 Observable 的数据给观察者，无论它们是何时订阅的
     *
     * 稍微改一下代码，将 create() 改成 createWithSize(1)，表示只缓存订阅前最后发送的一条数据
     * 从并发的角度来看，ReplaySubject 在处理并发 subject() 和 onNext() 时会更加复杂。
     * ReplaySubject 除了可以限制缓存数据的数量，还能限制缓存的时间，使用 createWithTime() 即可。
     */
    private void replaySubject() {

        ReplaySubject<Object> replaySubject = ReplaySubject.create();

        replaySubject.onNext("replaySubject1");
        replaySubject.onNext("replaySubject2");

        replaySubject.subscribe(System.out::println,
                throwable -> System.out.println("replaySubject onError"),
                () -> System.out.println("replaySubject:complete"));

        replaySubject.onNext("replaySubject3");
        replaySubject.onNext("replaySubject4");
    }

    /**
     * Observer 只接收 PublishSubject 被订阅之后 onComplete() 之前的数据
     */
    private void publishSubject() {
        PublishSubject<Object> publishSubject = PublishSubject.create();

        publishSubject.onNext("publishSubject1");
        publishSubject.onNext("publishSubject2");
        publishSubject.onComplete();

        publishSubject.subscribe(s -> System.out.println("publishSubject: " + s),
                throwable -> System.out.println("publishSubject onError"),
                () -> System.out.println("publishSubject: complete"));

        publishSubject.onNext("publishSubject1");
        publishSubject.onNext("publishSubject2");
    }

}
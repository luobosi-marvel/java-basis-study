/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.jre;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * RxJavaDemo1
 *
 * @author luobosi@2dfire.com
 * @since 2018-09-03
 */
public class RxJavaDemo1 {

    public static void main(String[] args) {
        RxJavaDemo1 rxJavaDemo1 = new RxJavaDemo1();
        rxJavaDemo1.fun1();
        System.out.println();
        rxJavaDemo1.fun2();
        System.out.println();
        rxJavaDemo1.fun3();
        System.out.println();
        rxJavaDemo1.fun4();
        System.out.println();
        rxJavaDemo1.fun5();
        System.out.println();
        rxJavaDemo1.fun6();

    }

    private void fun1() {
        Observable.just("Hello World").subscribe(System.out::println);
    }

    private void fun2() {
        Observable.just("Hello World")
                .subscribe(
                        System.out::println,
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println("onComplete"));
    }

    private void fun3() {
        Observable.just("Hello World")
                .subscribe(
                        System.out::println,
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println("onComplete"),
                        disposable -> System.out.println("subscribe"));
    }

    private void fun4() {
        Observable.just("Hello World")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("subscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }

    /**
     * do 操作
     */
    private void fun5() {
        Observable.just("hello")
                .doOnNext(s -> System.out.println("doOnNext: " + s))
                .doAfterNext(s -> System.out.println("doAfterNext: " + s))
                .doOnComplete(() -> System.out.println("doOnComplete: "))
                // 订阅之后回调的方法
                .doOnSubscribe(disposable -> System.out.println("doOnSubscribe: "))
                .doAfterTerminate(() -> System.out.println("doAfterTerminate: "))
                .doFinally(() -> System.out.println("doFinally"))
                // Observable 每发射一个数据就会触发这个回调，不仅包括 onNext，还包括 onError 和 onCompleted
                .doOnEach(stringNotification -> System.out.println("doOnEach:"))
                // 订阅后可以取消订阅
                .doOnLifecycle(disposable -> System.out.println("doOnLifecycle: " + disposable.isDisposed()), () -> System.out.println("doOnLifecycle run: "))
                .subscribe(s -> System.out.println("收到的消息: " + s));
    }

    /**
     * map 操作详解
     */
    private void fun6() {
        Observable.range(0, 10)
                .map(integer -> integer + "marvel")
                .subscribe(System.out::println);
    }

    private void fun7() {
        Observable.just("Hello World")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println(throwable.getMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("onComplete()");
                    }
                }, new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        System.out.println("subscribe");
                    }
                });
    }
}
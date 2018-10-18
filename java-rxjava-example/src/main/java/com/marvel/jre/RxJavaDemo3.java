/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.jre;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Function;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * RxJavaDemo3
 * 创建操作符
 * RxJava 的创建操作符主要包括如下内容：
 * 1. just(): 将一个或多个对象转换成发射这个或这些对象的一个 Observable
 * 2. from(): 将一个 Iterable、一个 Future 或者一个数组转换成一个 Observable
 * 3. create(): 使用一个函数从头创建一个 Observable
 * 4. defer(): 只有当订阅者才创建 Observable，为每个订阅者创建一个新的 Observable
 * 5. range(): 创建一个发射指定范围的整数序列的 Observable
 * 6. interval(): 创建一个按照给定的时间间隔发射整数序列的 Observable
 * 7. timer(): 创建一个给定的延时之后发射单个数据的 Observable
 * 8. empty(): 创建一个什么都不做直接通知完成的 Observable
 * 9. error(): 创建一个什么都不做直接通知错误的 Observable
 * 10. never(): 创建一个不发射任何数据的 Observable
 *
 * @author luobosi@2dfire.com
 * @since 2018-09-04
 */
public class RxJavaDemo3 {
    /**
     * RxJava 建议我们在传递 create 方法的函数时，先检查一下观察者的 isDisposed 状态，
     * 以便在没有观察者的时候，让我们的 Observable 停止发射数据，防止运行昂贵的运算
     */
    private void create() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                try {
                    if (!observableEmitter.isDisposed()) {
                        for (int i = 0; i < 10; i++) {
                            observableEmitter.onNext(i);
                        }
                    }
                    observableEmitter.onComplete();
                } catch (Exception e) {
                    observableEmitter.onError(e);
                }
            }
        }).subscribe(
                integer -> System.out.println("Next: " + integer),
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("Sequence complete"));
    }

    private void juest() {
        Observable.just("hello just").subscribe(s -> System.out.println(s));
    }

    private void fromArray() {
        Observable.fromArray("hello", "from")
                .subscribe(strings -> System.out.println(strings));
    }

    private void fromIterable() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5 ,6, 7, 8, 9, 10);

        Observable.fromIterable(integers)
                .subscribe(
                        integer -> System.out.println(integer),
                        error -> System.out.println(error.getMessage()),
                        () -> System.out.println("Sequence complete"));
    }

    private void repeat() {
        Observable
                .just("hello just")
                .repeat(3)
                .subscribe(s -> System.out.println(s));
    }

    /**
     * repeatWhen 不是缓存和重放原始 Observable 的数据序列
     * 而是有条件的重新订阅和发射原来的 Observable。
     */
    private void repeatWhen() {
        Observable.range(0, 9).repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Object> objectObservable) throws Exception {
                return Observable.timer(10, TimeUnit.SECONDS);
            }
        }).subscribe(
                integer -> System.out.println(integer)
        );
    }

    /**
     * 表示直到某个条件就不再重复发射数据
     */
    private void repeatUntil() {
        final long startTimeMillis = System.currentTimeMillis();

        Observable.interval(500, TimeUnit.MILLISECONDS)
                .take(5)
                .repeatUntil(() -> System.currentTimeMillis() - startTimeMillis > 5000)
                .subscribe(aLong -> System.out.println(aLong));
    }

    private void defer() {
        Observable observable = Observable.defer(new Callable<ObservableSource<?>>() {
            @Override
            public ObservableSource<?> call() throws Exception {
                return Observable.just("hello defer");
            }
        });

        observable.subscribe(str -> System.out.println(str));
    }

    private void interval() {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);

        observable.subscribe(aLong -> System.out.println(aLong));
    }

    private void timer() {
        Observable<Long> observable = Observable.timer(2, TimeUnit.SECONDS);

        observable.subscribe(aLong -> System.out.println("hello timer"));
    }


}
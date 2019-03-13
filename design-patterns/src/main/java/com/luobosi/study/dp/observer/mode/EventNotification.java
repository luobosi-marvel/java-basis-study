/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.observer.mode;

import java.util.List;

/**
 * EventNotification
 *
 * @author luobosi@2dfire.com
 * @since 2019-03-13
 */
public class EventNotification {

    /**
     * 观察者 list
     */
    private List<Observer> observerList;

    /**
     * 添加一个观察者
     *
     * @param observer 观察者
     * @return true/false
     */
    public boolean addObserver(Observer observer) {
        return observerList.add(observer);
    }

    /**
     * 移除一个观察者
     *
     * @return true/false
     */
    public boolean removeObserver(Observer observer) {
        return observerList.remove(observer);
    }

    /**
     * 通知所有的观察者
     */
    public void notifyAllObserver(Event event) {
        observerList.forEach(observer -> observer.business(event.getMessage()));
    }

}

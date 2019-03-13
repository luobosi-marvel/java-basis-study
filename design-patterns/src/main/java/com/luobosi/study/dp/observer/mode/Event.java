/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.observer.mode;

/**
 * Event
 *
 * @author luobosi@2dfire.com
 * @since 2019-03-13
 */
public enum Event {

    SINGLE("我现在单身"),
    MARRY("我现在结婚了"),
    ;

    private String message;

    Event(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

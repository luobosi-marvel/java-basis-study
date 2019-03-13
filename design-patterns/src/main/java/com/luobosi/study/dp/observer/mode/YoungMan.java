/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.observer.mode;

/**
 * YoungMan
 *
 * @author luobosi@2dfire.com
 * @since 2019-03-13
 */
public class YoungMan implements Observer {

    @Override
    public void business(String message) {
        System.out.println(message);
    }
}

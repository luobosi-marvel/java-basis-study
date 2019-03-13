/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.observer.mode;

/**
 * Observer
 *
 * @author luobosi@2dfire.com
 * @since 2019-03-13
 */
public interface Observer {

    /**
     * 业务逻辑代码
     */
    void business(String message);
}

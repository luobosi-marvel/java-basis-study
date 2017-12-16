/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.state;

/**
 * State
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-16
 */
public interface State {
    /**
     * 处理器
     *
     * @param poetTitle 诗人条件
     */
    void handle(PoetTitle poetTitle);
}
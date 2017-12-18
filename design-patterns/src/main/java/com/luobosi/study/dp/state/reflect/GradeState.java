/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.state.reflect;

/**
 * GradeState
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-18
 */
public interface GradeState {
    /**
     * 处理器
     *
     * @param request 条件
     */
    int handle(MyRequest request);
}
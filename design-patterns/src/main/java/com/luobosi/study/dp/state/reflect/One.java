/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.state.reflect;

/**
 * One
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-18
 */
public class One implements GradeState{

    @Override
    public int handle(MyRequest request) {
        if (request.getGrade() == 1) {
            return 1;
        }
        return -1;
    }
}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.state.reflect;

/**
 * Three
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-18
 */
public class Three implements GradeState {

    @Override
    public int handle(MyRequest request) {
        if (request.getGrade() == 3) {
            return 3;
        }
        return -1;
    }
}
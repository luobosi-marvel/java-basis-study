/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.state.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * MyRequest
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-18
 */
@AllArgsConstructor
@Data
public class MyRequest {
    /** 等级权重 */
    private Integer grade;
}
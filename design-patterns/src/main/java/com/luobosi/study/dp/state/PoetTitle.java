/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.state;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * PoetTitle
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-16
 */
@Data
@AllArgsConstructor
public class PoetTitle {
    /** 诗人名字 */
    private String name;
    /** 写诗的总数 */
    private int poetSum;
}
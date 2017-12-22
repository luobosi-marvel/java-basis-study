/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.factory.factory.method.pattern;

/**
 * Factory
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-04
 */
public interface Factory {

    /**
     * 创建产品的方法
     * @return 返回指定产品
     */
    Product createProduct();
}
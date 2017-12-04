/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.factory.simple.factory.pattern;

import com.luobosi.common.constant.Constants;

/**
 * Factory
 * 工厂类(单例)
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-04
 */
public class Factory {

    private Factory() {
    }

    /**
     * 创建产品对象
     *
     * @param productName 产品的名字
     * @return 产品
     */
    public static Product createProduct(String productName) {
        if (productName == null || productName.length() == 0) {
            throw new IllegalArgumentException("产品名字不能为空！！！");
        }

        Product product = null;

        if (Constants.ConstantFactory.CONCREATE_PRODUCT_A.equals(productName)) {
            product = new ConcreateProductA();
        } else if (Constants.ConstantFactory.CONCREATE_PRODUCT_B.equals(productName)) {
            product = new ConcreateProductB();
        } else {
            throw new RuntimeException("传入的参数不合法！！！");
        }
        return product;
    }

}
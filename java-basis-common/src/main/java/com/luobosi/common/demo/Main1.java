/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.common.demo;

import java.util.List;

/**
 * Main1
 *
 * @author luobosi@2dfire.com
 * @since 2019-03-07
 */
public class Main1 {

    private List<String> nameList;

    public static void main(String[] args) {
        Main1 main1 = new Main1();

        if (null == main1.nameList || main1.nameList.size() == 0) {
            throw new NullPointerException("参数异常");
        }

        main1.nameList.forEach(System.out::println);
    }
}

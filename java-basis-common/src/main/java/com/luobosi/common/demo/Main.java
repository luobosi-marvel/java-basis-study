/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.common.demo;

import java.util.List;

/**
 * Main
 *
 * @author luobosi@2dfire.com
 * @since 2019-03-07
 */
public class Main {

    private List<String> nameList;

    public static void main(String[] args) {
        Main main = new Main();
        ValidateUtil.checkNotNull(main.nameList, "名字列表不能为空").forEach(System.out::println);
    }

}

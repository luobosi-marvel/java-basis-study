/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.registry;

import java.util.HashMap;
import java.util.Map;

/**
 * Main
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-02
 */
public class Main {

    public static void main(String[] args) {
        Map<Integer, IRegistry> map = new HashMap<>();

        map.put(1, ()-> System.out.println(1));

        map.put(2, () -> System.out.println(2));

        map.get(1).execute();
    }
}

/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.fe;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JsonExample3
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-14
 */
public class JsonExample3 {

    private static final String[] FOOD_JSON_INSERT = {"a","b","c"};

    public static void main(String[] args) {
        List<String> list = Arrays.asList(FOOD_JSON_INSERT);
        List<String> list1 = new ArrayList<>();
        String s = JSON.toJSONString(list);
        System.out.println(s);

        JSONArray objects = JSON.parseArray(s);


        list1 = JSONObject.parseArray(objects.toString(), String.class);

        list1.forEach(System.out::println);
    }

}
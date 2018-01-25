/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.fe;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.luobosi.study.fe.domain.A;
import com.luobosi.study.fe.domain.TastePreferencesDO;

import java.util.*;
import java.util.stream.Collectors;

/**
 * JsonExample2
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-20
 */
public class JsonExample2 {
    /** 数组格式 */
    private final static String tastePreferences =
            "{\"tastePreferences\": [{\"preferences\": \"不要啦\"},{\"preferences\": \"不要辣\"},{\"preferences\": \"不要拉\"},{\"preferences\": \"不要啊\"},{\"preferences\": \"不要了\"}]}";

    private final static String tastePreferencesOne = "{\"preferences\": \"不要啦\"}";

    private final static String timeLine = "{\"preferences\":[]}";

    private final static String COUPON_IDS = "[{\"couponId\":\"id1\"},{\"couponId\":\"id2\"}]";

    public static void main(String[] args) {
        //json字符串转换成jsonobject对象

//        testJSONStrToJavaBeanObj();
//       testJSONStrToJavaBeanList();
//        test();

//        testJSONStrToStringList();

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "1");
        map.put(3, "1");
        map.put(4, "1");
        map.put(5, "2");

        Set<Integer> set = map.keySet();
        set.stream().forEach(System.out::println);

        Collection<String> values = map.values();
        values.stream().forEach(System.out::println);

        System.out.println("size: " + values.size());
        System.out.println("isEmpty: " + values.isEmpty());
        values.clear();

        map.entrySet().stream().forEach(System.out::println);
    }

    /**
     * json字符串-简单对象与JavaBean_obj之间的转换
     */
    public static void testJSONStrToJavaBeanObj(){

        TastePreferencesDO tastePreferencesDO = JSON.parseObject(tastePreferencesOne, new TypeReference<TastePreferencesDO>() {});
        System.out.println(tastePreferencesDO);
    }

    /**
     * json字符串-数组类型与JavaBean_List之间的转换
     */
    public static void testJSONStrToJavaBeanList(){
        ArrayList<TastePreferencesDO> tastePreferencesDOS = JSON.parseObject(timeLine, new TypeReference<ArrayList<TastePreferencesDO>>() {});
        for (TastePreferencesDO taste : tastePreferencesDOS) {
            System.out.println(taste.getPreferences());
        }
    }

    public static void testJSONStrToStringList(){
        ArrayList<String> tastePreferencesDOS = JSON.parseObject(COUPON_IDS, new TypeReference<ArrayList<String>>() {});
        for (String coupon : tastePreferencesDOS) {
            System.out.println(coupon);
        }
    }

    public static void test() {
        A a = JSON.parseObject(tastePreferences, new TypeReference<A>() {});
        System.out.println(a);
    }

}
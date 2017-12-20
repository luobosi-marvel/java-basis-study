/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.fe;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.luobosi.study.fe.domain.TastePreferencesDO;

import java.util.ArrayList;

/**
 * JsonExample2
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-20
 */
public class JsonExample2 {
    /** 数组格式 */
    private final static String tastePreferences =
            "[{\"preferences\": \"不要啦\"},{\"preferences\": \"不要辣\"},{\"preferences\": \"不要拉\"},{\"preferences\": \"不要啊\"},{\"preferences\": \"不要了\"}]";

    private final static String tastePreferencesOne = "{\"preferences\": \"不要啦\"}";

    public static void main(String[] args) {
        //json字符串转换成jsonobject对象

//        testJSONStrToJavaBeanObj();
        testJSONStrToJavaBeanList();
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

        ArrayList<TastePreferencesDO> tastePreferencesDOS = JSON.parseObject(tastePreferences, new TypeReference<ArrayList<TastePreferencesDO>>() {});

        for (TastePreferencesDO taste : tastePreferencesDOS) {
            System.out.println(taste.getPreferences());
        }
    }
}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.fe;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * JsonExample
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-19
 */
public class JsonExample {
    public static void main(String[] args) {
        //String json="{\"name\":\"刘德华\",\"age\":35,\"some\":[{\"k1\":\"v1\",\"k2\":\"v2\"},{\"k3\":\"v3\",\"k4\":\"v4\"}]}";
        String json="{\"some\":[{\"k1\":\"v1\",\"k2\":\"v2\"},{\"k3\":\"v3\",\"k4\":\"v4\"}]}";
        //json字符串转换成jsonobject对象
        JSONObject jso= JSON.parseObject(json);
        System.out.println("初始jsonObject:\n"+jso+"\n");
        //jsonobject对象取得some对应的jsonarray数组
        JSONArray jsarr=jso.getJSONArray("some");
        System.out.println("jsonObject里面的jsonarray:\n"+jsarr+"\n");





        //jsonarray对象通过getjsonobjext(index)方法取得数组里面的jsonobject对象
        JSONObject ao=jsarr.getJSONObject(0);
        System.out.println("jsonObject里面的jsonarray里面的第一个jsonobject：\n"+ao+"\n");
        //jsonobject对象通过key直接取得String的值
        String vString=ao.getString("k1");
        Collection collection = ao.values();
        List<String> strings = new ArrayList<String>(collection);
        System.out.println();
        strings.stream().forEach(System.out::println);

        System.out.println();
/*        Map<String, Object> innerMap = ao.getInnerMap();
        for (Map.Entry entry : innerMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + "   value: " + entry.getValue());
        }*/
        System.out.println("jsonObject里面的jsonarray里面的第一个jsonobject里的键值对对k1取值：\n"+vString+"\n");
    }


}
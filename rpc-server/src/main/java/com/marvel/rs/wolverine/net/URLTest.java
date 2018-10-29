/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.net;

import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * URLTest
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-29
 */
public class URLTest {

    public static void main(String[] args) {
        try {
            // 获取IP地址
            String ip = InetAddress.getLocalHost().getHostAddress();

            Map<String, String> map = new HashMap<>();

            URL url = new URL("marvel", ip, 8888, "org.apache.dubbo.config.cache.CacheService", map);
            System.out.println("IP地址：" + ip);
        } catch (Exception e) {
            System.out.println("异常：" + e);
            e.printStackTrace();
        }
    }

}

/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.zk;

import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ZkConnect
 * 连接 zk 的小 demo
 *
 * @author luobosi@2dfire.com
 * @since 2018-09-21
 */
public class ZkConnect {

    /**
     * logger 对象
     */
    private static final Logger logger = LoggerFactory.getLogger(ZkConnect.class);

    /**
     * 单机模式是一个ip
     */
    private static String zkServerIp;

    /**
     * 连接超时时间
     */
    private static Integer timeout;

    // 加载配置信息
    static {
        Properties properties = new Properties();
        InputStream inputStream = Object.class.getResourceAsStream("/zk-connect.properties");
        try {
            properties.load(inputStream);

            zkServerIp = properties.getProperty("zk.zkServerIp");
            // zkServerIps = properties.getProperty("zk.zkServerIps");
            timeout = Integer.parseInt(properties.getProperty("zk.timeout"));
        } catch (Exception e) {
            logger.error("配置文件读取异常", e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error("关闭流失败", e);
            }
        }
    }


    /**
     * 获取 zk 连接
     *
     * @return 返回一个 zk connect
     */
    public static ZooKeeper getZkConnect() {

        // 实例化zookeeper客户端
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper(zkServerIp, timeout, new ZkConnectWatcher());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return zooKeeper;
    }
}

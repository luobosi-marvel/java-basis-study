/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/**
 * ZkNodeOperator
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
public class ZkNodeOperator {

    /**
     * 创建一个 zk 节点
     *
     * @param path 路径
     * @param data 保存的数据
     */
    public void createZKNode(String path, byte[] data) {
        ZooKeeper zooKeeper = ZkConnect.getZkConnect();
        String result = "";
        try {
            result = zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println("创建节点：\t" + result + "\t成功...");
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一个 zk 节点
     *
     * @param path    路径
     * @param version 版本
     */
    public void deleteZKNode(String path, int version) {
        ZooKeeper zooKeeper = ZkConnect.getZkConnect();
        try {
            zooKeeper.delete(path, version);
        } catch (InterruptedException | KeeperException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取指定路径的所有子节点
     *
     * @param path 路径
     * @return 指定路径下的所有子节点
     */
    public List<String> getChildrenList(String path) {
        ZooKeeper zooKeeper = ZkConnect.getZkConnect();
        /*
         * 参数：
         * path：父节点路径
         * watch：true或者false，注册一个watch事件
         */
        List<String> strChildList = null;
        try {
            strChildList = zooKeeper.getChildren(path, false);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }

        return strChildList;
    }
}

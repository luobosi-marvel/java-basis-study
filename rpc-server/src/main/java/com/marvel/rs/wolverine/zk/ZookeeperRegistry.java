/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.zk;

/**
 * ZookeeperRegistry
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
public class ZookeeperRegistry {

    /**
     * 创建一个跟节点
     */
    public void registerRootPath() {
        ZkNodeOperator zkNodeOperator = new ZkNodeOperator();
        try {
            zkNodeOperator.createZKNode("/marvel", null);
        } catch (Throwable e) {
            throw new RuntimeException("Failed to register marvel to zookeeper" + e);
        }
    }

    public void doRegister(String interfaceName) {
        ZkNodeOperator zkNodeOperator = new ZkNodeOperator();
        try {
            zkNodeOperator.createZKNode(toInterfaceNamePath(interfaceName), null);
        } catch (Throwable e) {
            throw new RuntimeException("Failed to register " + interfaceName + " to zookeeper" + e);
        }
    }



    private String toInterfaceNamePath(String interfaceName) {
        return "/" + interfaceName;
    }

}

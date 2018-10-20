/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine;

import com.marvel.rs.wolverine.config.ServiceConfig;
import com.marvel.rs.wolverine.schema.WolverineNamespaceHandler;
import com.marvel.rs.wolverine.zk.ZookeeperRegistry;

import java.util.List;

/**
 * WolverineServer
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
public class WolverineServer {

    public static void main(String[] args) throws InterruptedException {
        /*WolverineNamespaceHandler namespaceHandler = new WolverineNamespaceHandler();
        List<ServiceConfig> parse = namespaceHandler.parse();
        System.out.println(parse);*/

        ZookeeperRegistry zookeeperRegistry = new ZookeeperRegistry();
        zookeeperRegistry.registerRootPath();

        Thread.sleep(10000);
    }
}

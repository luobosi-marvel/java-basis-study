/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * ZkConnectWatcher
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
public class ZkConnectWatcher implements Watcher {

    /**
     * Watch事件通知
     *
     * @param watchedEvent 事件监听对象
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("接收到watch通知：" + watchedEvent);
    }
}

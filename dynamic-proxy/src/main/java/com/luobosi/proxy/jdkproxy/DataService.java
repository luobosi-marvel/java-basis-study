/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.proxy.jdkproxy;

/**
 * DataService
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-06
 */
public interface DataService {

    /**
     * 保存
     *
     * @param username  用户名
     */
    void save(String username);

    /**
     * 更新
     *
     * @param username
     */
    void update(String username);
}
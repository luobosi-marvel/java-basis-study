/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.proxy.myproxy;

/**
 * BookService
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-06
 */
public interface BookService {

    /**
     * 插入方法
     *
     * @param bookName 书名
     */
    void insert(String bookName);

    /**
     * 更新书名
     *
     * @param bookName 书名
     */
    void update(String bookName);

    /**
     * 根据书名查找信息
     *
     * @param bookName 书名
     * @return 作者
     */
    String findBook(String bookName);

}
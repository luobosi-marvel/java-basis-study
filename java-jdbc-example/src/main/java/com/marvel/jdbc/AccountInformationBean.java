/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * AccountInformationBean
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountInformationBean implements Serializable {

    private static final long serialVersionUID = 439407777110381001L;

    /**
     * 主键
     */
    private int id;

    /**
     * 名字
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 信息
     */
    private String message;

}

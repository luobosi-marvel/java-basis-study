/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.config;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ServiceConfig
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
@Data
@ToString
public class ServiceConfig implements Serializable {

    private static final long serialVersionUID = 8186522364370165651L;

    /**
     * 依赖注入引用的名称
     */
    private String ref;

    /**
     * 接口全限定名称
     */
    private String interfaceName;

    /**
     * 具体实现类
     */
    private Class<?> interfaceClass;

    /**
     * 版本号
     */
    private String version;
}

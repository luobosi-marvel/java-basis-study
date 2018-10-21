/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ScanComponent
 * 扫描包下面使用了自定义注解的类
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-21
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ScanComponent {

    /**
     * 要扫描的包的路径
     *
     * @return 包路径名
     */
    String basePackage();

}

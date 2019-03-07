/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.common.demo;

/**
 * ValidateUtil
 *
 * @author luobosi@2dfire.com
 * @since 2019-03-07
 */
public class ValidateUtil {

    private ValidateUtil() {

    }

    /**
     * 检查对象是否为空,如果对象不为空则返回该对象
     *
     * @param arg           对象实体
     * @param exceptionTest 异常信息
     * @param <T>           泛型对象
     * @return 实体对象
     */
    public static <T> T checkNotNull(T arg, String exceptionTest) {
        if (arg == null) {
            throw new NullPointerException(exceptionTest);
        }
        return arg;
    }

    /**
     * 如果整型数值为 null ,则返回给定的默认值
     *
     * @param wrapper      要校验的值
     * @param defaultValue 默认值
     * @return int 类型
     */
    public static int intValue(Integer wrapper, int defaultValue) {
        return wrapper != null ? wrapper : defaultValue;
    }
}

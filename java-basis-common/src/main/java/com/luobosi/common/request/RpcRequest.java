/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.common.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * RpcRequest
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
@Data
@ToString
public class RpcRequest implements Serializable {

    /**
     * 类名
     */
    private String className;

    /**
     * 调用的方法名称
     */
    private String methodName;

    /**
     * 调用方法的参数
     */
    private Object[] parameters;
}

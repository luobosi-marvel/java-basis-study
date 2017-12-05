/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.proxy.javassist;

import lombok.Data;

/**
 * Subject
 * 这个是目标类，好让 javassist 为它生成代理类
 * @author luobosi@2dfire.com
 * @since 2017-12-05
 */
@Data
public class Subject {
    /** 姓名 */
    private String username;
    /** 密码 */
    private String password;
}
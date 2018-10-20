/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * UserDTO
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    // 这里一定要加上序列化id，因为相同类的class在不同环境的机器上的serialVersionUID不同，反序列化就容易报异常。
    private static final long serialVersionUID = -7439286073069867838L;

    /**
     * 名字
     */
    private String name;

    /**
     * 年纪
     */
    private int age;

    /**
     * 描述
     */
    private String desc;
}

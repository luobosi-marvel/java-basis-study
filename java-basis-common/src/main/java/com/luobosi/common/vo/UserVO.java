/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * UserVO
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-21
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserVO implements Serializable {

    private static final long serialVersionUID = 466532378435890436L;

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

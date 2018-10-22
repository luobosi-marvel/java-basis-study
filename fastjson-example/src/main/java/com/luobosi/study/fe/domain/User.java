/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.fe.domain;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * User
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-22
 */

@Data
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 8994082346461101810L;

    @NotNull // 不允许为空
    @Size(min = 1, max = 20) // 长度或大小范围
    private String name;

    @NotNull
    private String email;

    @Min(18) // 最小值
    @Max(100) // 最大值
    private int age;

    @Past // 必须为一个过去的时间
    private Date loginDate;

    @Future // 必须为一个未来的时间
    private Date expiryDate;
}

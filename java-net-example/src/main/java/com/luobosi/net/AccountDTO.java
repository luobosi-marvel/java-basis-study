/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * AccountDTO
 *
 * @author luobosi@2dfire.com
 * @since 2019-01-21
 */
@Data
@ToString
public class AccountDTO implements Serializable {

    private Long id;

    private String username;

    private String pwd;
}

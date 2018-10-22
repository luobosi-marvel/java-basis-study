/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.fe;

import com.luobosi.study.fe.domain.User;

import javax.validation.constraints.NotNull;

/**
 * ParamValidation
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-22
 */
public class ParamValidation {

    public void save(@NotNull User user) {
        System.out.println(user);
    }

    public static void main(String[] args) {
        User user = new User();
        ParamValidation paramValidation = new ParamValidation();
        paramValidation.save(user);

        System.out.println(user);
    }
}

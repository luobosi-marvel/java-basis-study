/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs;

import com.luobosi.common.dto.UserDTO;
import com.luobosi.common.facade.IHelloFacade;

/**
 * HelloServiceImpl
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
public class HelloServiceImpl implements IHelloFacade {

    @Override
    public String sayHello(String content) {
        return "hello " + content;
    }

    @Override
    public String saveUser(UserDTO user) {
        System.out.println(user);
        return "success";
    }
}

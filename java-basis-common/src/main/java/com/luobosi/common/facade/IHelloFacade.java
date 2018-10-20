/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.common.facade;

import com.luobosi.common.dto.UserDTO;

/**
 * IHelloFacade
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
public interface IHelloFacade {

    /**
     * 打招呼
     *
     * @param content 文本内容
     * @return 打招呼
     */
    String sayHello(String content);

    /**
     * 保存一个用户
     *
     * @param user 用户
     * @return 返回成功
     */
    String saveUser(UserDTO user);
}

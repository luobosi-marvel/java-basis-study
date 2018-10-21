/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.impl;

import com.luobosi.common.facade.IUserFacade;
import com.luobosi.common.vo.UserVO;
import com.marvel.rs.wolverine.annotation.Service;

/**
 * UserServiceImpl
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-21
 */
@Service("userServiceImpl")
public class UserServiceImpl implements IUserFacade {

    @Override
    public UserVO getUser() {
        return new UserVO("张三", 20, "很帅");
    }
}

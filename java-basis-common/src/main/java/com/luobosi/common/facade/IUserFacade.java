/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.common.facade;

import com.luobosi.common.vo.UserVO;

/**
 * IUserFacade
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-21
 */
public interface IUserFacade {

    /**
     * 获取一个 user 用户
     *
     * @return user
     */
    UserVO getUser();

}

/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.state;

import com.luobosi.common.constant.Constants;

/**
 * PoetryCentsState
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-16
 */
public class PoetryCentsState implements State {

    @Override
    public void handle(PoetTitle poetTitle) {
        if (poetTitle.getPoetSum() == Constants.ConstantNumber.HUNDRED) {
            System.out.println(poetTitle.getName() + "是诗仙！");
        }
    }


}
/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.chain.responsibility;

/**
 * VicePresident
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-07
 */
public class VicePresident extends Approver{

    public VicePresident(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 100000) {
            System.out.println("副董事长：" + this.name + "审批采购单" + request);
        } else {
            // 请求转发，让下家处理
            this.successor.processRequest(request);
        }
    }
}

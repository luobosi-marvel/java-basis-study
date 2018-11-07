/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.chain.responsibility;

/**
 * President
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-07
 */
public class President extends Approver {

    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {

        if (request.getAmount() < 500000) {
            System.out.println("董事长：" + this.name + "审批采购单" + request);
        } else {
            // 转发请求
            this.successor.processRequest(request);
        }
    }
}

/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.chain.responsibility;

/**
 * Director
 * 主任类：具体处理者
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-07
 */
public class Director extends Approver {

    public Director(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 5000) {
            // 处理请求
            System.out.println("主任：" + this.name + "审批采购单" + request);
        } else {
            // 让下家处理，但是不知道啥时候能处理完。请求链路比较长的时候是很耗时间的
            this.successor.processRequest(request);
        }
    }
}

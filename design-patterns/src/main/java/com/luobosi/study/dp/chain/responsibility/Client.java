/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.chain.responsibility;

/**
 * Client
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-07
 */
public class Client {

    public static void main(String[] args) {
        Approver wangwu, marvel, luobosi, qiezi;

        wangwu = new Director("王五");
        marvel = new VicePresident("张无忌");
        luobosi = new President("萝卜丝");
        qiezi = new Congress("茄子");

        // 创建指责链
        wangwu.setSuccessor(marvel);
        marvel.setSuccessor(luobosi);
        luobosi.setSuccessor(qiezi);

        // 创建采购单
        PurchaseRequest request1 = new PurchaseRequest(4000, 10001, "购买倚天剑");
        wangwu.processRequest(request1);

        PurchaseRequest request2 = new PurchaseRequest(60000, 10002, "购买屠龙刀");
        wangwu.processRequest(request2);

        PurchaseRequest request3 = new PurchaseRequest(100000, 10003, "购买周芷若");
        wangwu.processRequest(request3);

        PurchaseRequest request4 = new PurchaseRequest(8000000, 10004, "购买赵敏");
        wangwu.processRequest(request4);

    }
}

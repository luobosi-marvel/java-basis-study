/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.chain.responsibility;

/**
 * Approver
 * 审批者类，抽象处理者
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-07
 */
public abstract class Approver {
    /**
     * 定义后继对象
     * 自关联，其实就是维护一个下家的饮用
     */
    protected Approver successor;
    /**
     * 审批者姓名
     */
    protected String name;

    public Approver(String name) {
        this.name = name;
    }

    /**
     * 设置后继处理者
     *
     * @param successor 后继处理者
     */
    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    /**
     * 抽象请求处理方法
     *
     * @param request 请求者
     */
    public abstract void processRequest(PurchaseRequest request);
}

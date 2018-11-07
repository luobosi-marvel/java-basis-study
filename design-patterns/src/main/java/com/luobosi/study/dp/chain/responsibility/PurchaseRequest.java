/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.chain.responsibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * PurchaseRequest
 * 采购单：请求类
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseRequest {

    /**
     * 采购金额
     */
    private double amount;

    /**
     * 采购单编号
     */
    private int number;

    /**
     * 采购目的
     */
    private String purpose;
}

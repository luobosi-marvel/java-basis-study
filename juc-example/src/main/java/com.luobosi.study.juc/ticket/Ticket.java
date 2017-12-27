/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.juc.ticket;

import lombok.Data;
import lombok.ToString;

/**
 * Ticket
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-27
 */
@Data
@ToString
public class Ticket {
    /** 出发地 */
    private String from;
    /** 结束地 */
    private String to;
    /** 上机时间 */
    private String time;
    /** 最低价格 */
    private double price;
}
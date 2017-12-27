/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.juc.ticket;

import java.util.List;

/**
 * TicketManager
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-27
 */
public class TicketManager {

    private List<Ticket> tickets;

    public TicketManager(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    /**
     * 根据用户输入的条件返回票（需要加锁，还需要优化）
     *
     * @param from  出发地
     * @param to    到达地
     * @param time  上机时间
     * @return      返回票给用户
     */
    public Ticket search(String from, String to, String time) {
        for (Ticket ticket : tickets) {
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to) && ticket.getTime().equals(time)) {
                return ticket;
            }
        }
        return null;
    }
}
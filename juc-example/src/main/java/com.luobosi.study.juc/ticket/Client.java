/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.juc.ticket;

import com.google.common.collect.Lists;
import com.luobosi.common.constant.Constants;

import java.util.List;

/**
 * Client
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-27
 */
public class Client {


    public static void main(String[] args) {
        TicketManager ticketManager = new TicketManager(initTickets());
        // 找票
        Ticket search = ticketManager.search("", "", "");
        System.out.println(search);
    }

    public static List<Ticket> initTickets() {
        List<Ticket> tickets = Lists.newArrayList();
        int i = 0;
        while (i < Constants.ConstantNumber.TEN_THOUSAND) {
            Ticket ticket = new Ticket();
            ticket.setFrom("marvelous" + i);
            ticket.setTo("beijing" + i);
            ticket.setTime("" + i);
            ticket.setPrice(i);
            tickets.add(ticket);
        }
        return tickets;
    }
}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.state;

/**
 * Client
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-16
 */
public class Client {

    private State state;
    public Client(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public static void main(String[] args) {
        PoetTitle poetTitle = new PoetTitle("杜甫", 30);
        PoetTitle poetTitle1 = new PoetTitle("李白", 100);

        Client client = new Client(new PoetryState());
        Client client1 = new Client(new PoetryCentsState());

        client.getState().handle(poetTitle);
        client1.getState().handle(poetTitle1);

    }

}
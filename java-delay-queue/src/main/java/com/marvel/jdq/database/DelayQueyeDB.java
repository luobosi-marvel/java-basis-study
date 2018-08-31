/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.jdq.database;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

/**
 * DelayQueyeDB
 *
 * @author luobosi@2dfire.com
 * @since 2018-08-20
 */
public class DelayQueyeDB {

    public static void main(String[] args) {
        Long currentTime = System.currentTimeMillis();


        long zero = LocalDateTime.of(LocalDate.now(), LocalTime.MIN).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println("当天时间戳：" + zero);
        long time = currentTime - zero;
        long times = 1534923020000L - zero;
        System.out.println("偏移的时间戳：" + time);
        System.out.println(time / (1000 * 60));
        System.out.println("圈数：" + times / (1000 * 60 * 24 * 60));
        System.out.println("桶号：" + times % (1000 * 60 * 24 * 60) / (1000 * 60));


    }

}
/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.singleton;

/**
 * Season
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-12
 */
public enum Season {

    SPRING("spring", 10), SUMMER("summer", 20), AUTUMN("autumn", 30), WINTER("winter", 40);

    private String name;

    private int rate;

    Season(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public static Season valueOf(int ordinal) {
        if (ordinal < 0 || ordinal >= values().length) {
            throw new IndexOutOfBoundsException("Invalid ordinal");
        }
        return values()[ordinal];
    }

    public static void main(String[] args) {
        System.out.println(Season.valueOf(0).getName());
    }

}

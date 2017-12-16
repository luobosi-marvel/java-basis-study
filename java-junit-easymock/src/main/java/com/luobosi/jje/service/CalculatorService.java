/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.jje.service;

/**
 * CalculatorService
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-16
 */
public interface CalculatorService {

    /**
     * 求和
     *
     * @param input1 加数1
     * @param input2 加数2
     * @return 和
     */
    double add(double input1, double input2);

    /**
     * 求差
     *
     * @param input1 减数
     * @param input2 被减数
     * @return 差
     */
    double subtract(double input1, double input2);

    /**
     * 求积
     *
     * @param input1 乘数
     * @param input2 乘数
     * @return 积
     */
    double multiply(double input1, double input2);

    /**
     * 求商
     *
     * @param input1 除数
     * @param input2 被除数
     * @return 商
     */
    double divide(double input1, double input2);
}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.jje;

import com.luobosi.jje.service.CalculatorService;

/**
 * MathApplication
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-16
 */
public class MathApplication {
    private CalculatorService calcService;

    public void setCalculatorService(CalculatorService calcService){
        this.calcService = calcService;
    }
    public double add(double input1, double input2){
        return calcService.add(input1, input2);
    }
    public double subtract(double input1, double input2){
        return calcService.subtract(input1, input2);
    }
    public double multiply(double input1, double input2){
        return calcService.multiply(input1, input2);
    }
    public double divide(double input1, double input2){
        return calcService.divide(input1, input2);
    }
}
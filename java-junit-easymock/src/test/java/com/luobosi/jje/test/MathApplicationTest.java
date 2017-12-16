/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.jje.test;

import com.luobosi.jje.MathApplication;
import com.luobosi.jje.service.CalculatorService;
import org.easymock.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * MathApplicationTester
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-16
 */
@RunWith(EasyMockRunner.class)
public class MathApplicationTest {

    @TestSubject
    MathApplication mathApplication = new MathApplication();
    @Mock
    CalculatorService calcService;

    @Test
    public void testAdd() {
        EasyMock.expect(calcService.add(10.0D, 20.0D)).andReturn(30.0D);
        /*
            在使用 Mock 对象进行实际的测试前，我们需要将 Mock 对象的状态切换为 Replay 。
            在 Replay 状态，Mock 对象能够根据设定对特定的方法调用作出预期的响应。
          */
        EasyMock.replay(calcService);

        // 调用 Mock 对象方法进行单元测试
        double a = calcService.add(10.0D, 20.0D);
        System.out.println(a);

        Assert.assertEquals(mathApplication.add(10.0D, 20.0D), 30.0D, 0);
    }
}
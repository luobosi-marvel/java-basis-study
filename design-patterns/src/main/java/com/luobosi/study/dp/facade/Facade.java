/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.facade;

import lombok.Setter;

/**
 * Facade
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-16
 *
 * 外观模式的用意是为子系统提供一个集中化和简化的沟通渠道，而不是向子系统加入新的行为。
 *
 * 使用场景
 *  ① 当要为访问一系列复杂的子系统提供一个简单入口时可以使用外观模式。
 *  ② 客户端程序与多个子系统之间存在很大的依赖性。引入外观类可以将子系统与客户端解耦，从而提高子系统的独立性和可移植性。
 *  ③ 在层次化结构中，可以使用外观模式定义系统中每一层的入口，层与层之间不直接产生联系，而通过外观类建立联系，降低层之间
 *      的耦合度
 */
public class Facade {
    @Setter
    private SubSystemA subSystemA;
    @Setter
    private SubSystemB subSystemB;
    @Setter
    private SubSystemC subSystemC;

    public void printSubSystemA() {
        subSystemA.subSystemA();
    }

    public void printSubSystemB() {
        subSystemB.subSystemB();
    }

    public void printSubSystemC() {
        subSystemC.subSystemC();
    }


}
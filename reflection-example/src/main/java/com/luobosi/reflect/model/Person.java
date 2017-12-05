/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.reflect.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Person
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-05
 */
@Data
@AllArgsConstructor
public class Person {
    /** 用户名 */
    private String username ;
    /** 年龄 */
    private Integer age;
    /** 性别 */
    private  String sex;

    public Person() {
        System.out.println("这个是无参数的构造器！");
    }

    public void show(){
        System.out.println("无参数的show()方法");
    }

    public void show(String str){
        System.out.println("带参数的show()方法" + str);
    }

    public void showInfo(String name, int age){
        System.out.println("我的名字是："+name+"\t\t年龄："+age);

    }
    private  String eat(){
        return "我很能吃！";
    }

    /**
     * 主函数，为了反射测试而添加
     *
     * @param args 系统参数
     */
    public static void main(String[] args) {
        System.out.println("main方法中-------->");
        for (String string : args) {
            System.out.print(string+"\t\t");

        }
    }
}
/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.util;

import com.marvel.rs.wolverine.context.IocContext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * FilePathUtil
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-21
 */
public class FilePathUtil {
    /**
     * 最大总包名路径
     */
    private static String ALL_INCLUSIVE_PATH = "/com/marvel/rs";

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        String filePath = IocContext.class.getResource(ALL_INCLUSIVE_PATH).getPath();
        List<Class> classList = new ArrayList<>();
        getPathClassToList(filePath, classList);

    }

    /**
     * 递归获取指定路径下面的所有 class 文件，并将所有的 class 文件传入 参数 classList 集合里面
     *
     * @param filePath  指定的根文件路径
     * @param classList 用来存放根文件下面所有的 class 文件
     */
    public static void getPathClassToList(String filePath, List<Class> classList) {
        try {
            File[] files = getClassFile(filePath);
            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        Class<?> clazz = Class.forName(getClassFullyQualifiedName(f.getPath()));
                        classList.add(clazz);
                    } else {
                        // 递归扫描
                        getPathClassToList(f.getPath(), classList);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取类的全路径名称
     *
     * @param filePath 文件绝对路径
     * @return 类的全路径名称
     */
    private static String getClassFullyQualifiedName(String filePath) {
        int index = filePath.indexOf(ALL_INCLUSIVE_PATH);
        // 如果 index 不加 1，则拿出来的路径是 /com/marvel/rs/wolverine/zk/ZkConnect，要去掉前面的 斜杠
        String subStr = filePath.substring(index + 1, filePath.lastIndexOf("."));
        return subStr.replaceAll("/", "\\.");

    }


    /**
     * 获取该路径下所有的class文件和目录
     *
     * @param filePath 文件路径
     * @return 返回文件数组
     */
    private static File[] getClassFile(String filePath) {
        return new File(filePath).listFiles(file -> file.isFile() && file.getName().endsWith(".class") || file.isDirectory());
    }


}

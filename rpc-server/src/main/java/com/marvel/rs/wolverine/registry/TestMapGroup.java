/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.registry;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TestMapGroup
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-21
 */
public class TestMapGroup {

    public static void main(String[] args) {

        Set<String> orderIdSetOpt = new HashSet<>( Arrays.asList(
                "00156161633f019101633f27fe80000d",
                "00028788633f019101633f285fb9000e",
                "00028790633f019101633f2963c90012",
                "00028790633f019101633f2bf9cd0015",
                "00028790633f019101633f2d4cf90016",
                "00156161633f019101633f2d9f8c0017",
                "00156161633f019101633f2eb27a0018",
                "00028788633f019101633f2fdd350019",
                "00028788633f019101633f306b0c001a",
                "00150964633f019101633f337347001b",
                "00150964633f019101633f340eaa001f",
                "00150964633f019101633f348b7d0023",
                "00156161633f019101633f43e4a2002d",
                "00111332633f019101633f4f1d36003c",
                "00156161633f019101633f5a06e8004c",
                "00028790633f019101633f5a46eb004d",
                "00028790633f019101633f5c17490051",
                "00156161633f019101633f5ccdd70052",
                "00156161633f019101633f5d95740053",
                "00028788633f019101633f63a10a005d",
                "00028788633f019101633f6781e2006c",
                "00028788633f019101633f69bf1d006d",
                "00156161633f019101633f6a4a63006e",
                "00028788633f019101633f6d5d11006f",
                "00028790633f019101633f6ed7b90070",
                "00028788633f019101633f6f59f40071",
                "00028788633f019101633f759e190075",
                "00028788633f019101633f7680180077",
                "00028790633f019101633f7853ee007a",
                "00028788633f019101633f7a17c7007b"
        ));

        // 根据栏目id 分组
        Map<String/* entityId */, List<String>/* 订单id 集合*/> groupByOrderIdMap = orderIdSetOpt.stream()
                .collect(Collectors.groupingBy(orderId -> orderId.substring(0, 8)));

        groupByOrderIdMap.forEach((entityId, orderIds) -> System.out.println(entityId + " :" + orderIds.toString()));
    }
}

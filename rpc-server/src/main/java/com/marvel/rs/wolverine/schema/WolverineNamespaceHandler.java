/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.schema;

import com.marvel.rs.wolverine.config.ServiceConfig;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * WolverineNamespaceHandler
 * 这里用来解析我们暴露出去的服务，那么我们需要为我们的服务创建代理类型
 * 我们需要将 xml 获取的 配置类注册到 zk 里面去
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
public class WolverineNamespaceHandler {

    public List<ServiceConfig> parse() {
        List<ServiceConfig> serviceConfigList = new ArrayList<>();
        try {
            File file = new File(this.getClass().getResource("/marvel-provider.xml").getPath());
            //创建读取器
            SAXReader reader = new SAXReader();

            Document document = reader.read(file);
            Element beans = document.getRootElement();
            Iterator iterator = beans.elementIterator();
            while (iterator.hasNext()) {
                Element service = (Element) iterator.next();
                ServiceConfig serviceConfig = new ServiceConfig();
                List<Attribute> serviceConfigAttr = service.attributes();
                // 属性设置
                for (Attribute attribute : serviceConfigAttr) {
                    if ("ref".equals(attribute.getName())) {
                        serviceConfig.setRef(attribute.getValue());
                    } else if ("interface".equals(attribute.getName())) {
                        serviceConfig.setInterfaceName(attribute.getValue());
                    } else if ("version".equals(attribute.getName())) {
                        serviceConfig.setVersion(attribute.getValue());
                    }
                }
                serviceConfigList.add(serviceConfig);

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return serviceConfigList;
    }
}

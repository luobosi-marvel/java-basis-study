package com.marvel.rs.wolverine.proxy;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.List;

public interface HelloService {

    void say(String msg);

    String echo(String msg);

    String[] getHobbies();

    int insert(BIConversion.User user);

    BIConversion.User getUser();

    List<BIConversion.User> getUser(String group, int age);
}

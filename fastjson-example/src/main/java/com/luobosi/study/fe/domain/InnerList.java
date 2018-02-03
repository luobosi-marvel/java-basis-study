package com.luobosi.study.fe.domain;

import java.io.Serializable;

/**
 * @author luobosi@2dfire.com
 */
public class InnerList implements Serializable {

    private static final long serialVersionUID = -6801179299517408827L;

    private String name;

    private String url;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

}
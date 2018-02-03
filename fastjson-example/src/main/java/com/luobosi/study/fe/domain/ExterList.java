package com.luobosi.study.fe.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * @author luobosi@2dfire.com
 */
public class ExterList implements Serializable{

    private static final long serialVersionUID = 7784179978573995757L;

    @JSONField(name = "inner_list")
    private List<InnerList> innerList;

    public List<InnerList> getInnerList() {
        return innerList;
    }

    public void setInnerList(List<InnerList> innerList) {
        this.innerList = innerList;
    }
}
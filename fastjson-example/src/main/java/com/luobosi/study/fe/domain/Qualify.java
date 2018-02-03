package com.luobosi.study.fe.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * @author luobosi@2dfire.com
 */
public class Qualify implements Serializable{


    private static final long serialVersionUID = -6425896158482359974L;

    @JSONField(name = "exter_list")
    private List<ExterList> exterList;


    public List<ExterList> getExterList() {
        return exterList;
    }

    public void setExterList(List<ExterList> exterList) {
        this.exterList = exterList;
    }

    @Override
    public String toString() {
        return "Qualify{" +
                "exterList=" + exterList +
                '}';
    }
}
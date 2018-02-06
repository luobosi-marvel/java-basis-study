package com.luobosi.study.fe.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Arrays;


/**
 * @author luobosi@2dfire.com
 */
public class Categorie implements Serializable {

    private static final long serialVersionUID = 2923600016902709926L;

    private int[] children;

    private int father;

    private int id;

    private int level;

    private String name;

    private Qualify qualify;

    @JSONField(name = "sensitive_type")
    private int sensitiveType;

    public int[] getChildren() {
        return children;
    }

    public void setChildren(int[] children) {
        this.children = children;
    }

    public void setFather(int father) {
        this.father = father;
    }

    public int getFather() {
        return this.father;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setQualify(Qualify qualify) {
        this.qualify = qualify;
    }

    public Qualify getQualify() {
        return this.qualify;
    }

    public int getSensitiveType() {
        return sensitiveType;
    }

    public void setSensitiveType(int sensitiveType) {
        this.sensitiveType = sensitiveType;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "children=" + Arrays.toString(children) +
                ", father=" + father +
                ", id=" + id +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", qualify=" + qualify +
                ", sensitiveType=" + sensitiveType +
                '}';
    }
}
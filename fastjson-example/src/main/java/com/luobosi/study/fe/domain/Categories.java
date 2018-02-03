package com.luobosi.study.fe.domain;

import java.io.Serializable;
import java.util.List;


/**
 * @author luobosi@2dfire.com
 */
public class Categories implements Serializable {

    private static final long serialVersionUID = 2923600016902709926L;

    private List<Children> children;

    private int father;

    private int id;

    private int level;

    private String name;

    private Qualify qualify;

    private int sensitive_type;

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public List<Children> getChildren() {
        return this.children;
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

    public void setSensitive_type(int sensitive_type) {
        this.sensitive_type = sensitive_type;
    }

    public int getSensitive_type() {
        return this.sensitive_type;
    }

}
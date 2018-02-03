package com.luobosi.study.fe.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class Root implements Serializable{

    @JSONField(name = "category_list")
    private CategoryList categoryList;


    public CategoryList getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(CategoryList categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Root{" +
                "categoryList=" + categoryList +
                '}';
    }
}
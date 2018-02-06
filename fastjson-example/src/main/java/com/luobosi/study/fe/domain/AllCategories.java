package com.luobosi.study.fe.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author luobosi@2dfire.com
 */
public class AllCategories implements Serializable{

    private static final long serialVersionUID = 3984086787974226593L;

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
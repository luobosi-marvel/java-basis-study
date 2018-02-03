package com.luobosi.study.fe.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author luobosi@2dfire.com
 */
public class CategoryList implements Serializable{

    private static final long serialVersionUID = 8475575891280595917L;

    private List<Categories> categories;

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public List<Categories> getCategories() {
        return this.categories;
    }

    @Override
    public String toString() {
        return "CategoryList{" +
                "categories=" + categories +
                '}';
    }
}
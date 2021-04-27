package com.company.dla.lab6_refact;

import java.util.Arrays;

public class Purchase {
    private String productName;
    private Integer cost;
    private Integer count;

    public Purchase(String productName, int cost, int count) {
        this.productName = productName;
        this.cost = cost;
        this.count = count;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCost() {
        return cost;
    }
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public void addCount(Integer count) {
        this.count += count;
    }
}

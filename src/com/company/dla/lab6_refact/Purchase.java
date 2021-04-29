package com.company.dla.lab6_refact;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (productName != null ? !productName.equals(purchase.productName) : purchase.productName != null)
            return false;
        if (cost != null ? !cost.equals(purchase.cost) : purchase.cost != null) return false;
        return count != null ? count.equals(purchase.count) : purchase.count == null;
    }

    @Override
    public int hashCode() {
        int result = productName != null ? productName.hashCode() : 0;
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        return result;
    }
}

package com.thoughtworks.ketsu.domain.product;

public class Product {
    private long id;
    private String name;
    private String description;
    private float price;

    public Product(long id) {
        this.id = id;
    }

    public Product(){

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

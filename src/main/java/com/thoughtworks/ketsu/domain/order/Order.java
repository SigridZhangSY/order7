package com.thoughtworks.ketsu.domain.order;

import java.util.Date;
import java.util.List;

public class Order {
    private long id;
    private long userId;
    private String name;
    private String address;
    private String phone;
    private float totalPrice;
    private Date time;
    private List<OrderItem> items;

    public Order(long id, long userId) {
        this.id = id;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public Date getTime() {
        return time;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public long getUserId() {
        return userId;
    }
}

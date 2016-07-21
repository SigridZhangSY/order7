package com.thoughtworks.ketsu.domain.product;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class Product implements Record {
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

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return new HashMap<String, Object>(){{
            put("id", id);
            put("uri", routes.productUri(Product.this));
            put("name", name);
            put("decsription", description);
            put("price", price);
        }};
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }
}

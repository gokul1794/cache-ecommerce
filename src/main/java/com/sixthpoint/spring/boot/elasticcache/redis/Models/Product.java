package com.sixthpoint.spring.boot.elasticcache.redis.Models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    String productId;
    public String getProductId() {
        return productId;
    }
    String title;
    String description;
    String url;
    Manufacturer manufacturer;
    ShippingDetails shippingDetails;
    int quantity;
    Category category;
    Pricing pricing;
}

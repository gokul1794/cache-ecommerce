package com.sixthpoint.spring.boot.elasticcache.redis.Models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Category implements Serializable {
    public String categoryName;
    public String color;
}

package com.sixthpoint.spring.boot.elasticcache.redis.Models;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShippingDetails implements Serializable {
    float weight;
    float width;
    float height;
    float depth;

}

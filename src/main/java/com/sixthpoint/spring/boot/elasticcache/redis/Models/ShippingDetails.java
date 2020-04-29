package com.sixthpoint.spring.boot.elasticcache.redis.Models;

import lombok.Data;

@Data
public class ShippingDetails {
    float weight;
    float width;
    float height;
    float depth;

}

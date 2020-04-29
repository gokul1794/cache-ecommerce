package com.sixthpoint.spring.boot.elasticcache.redis.Models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Pricing implements Serializable {
    double price;
}

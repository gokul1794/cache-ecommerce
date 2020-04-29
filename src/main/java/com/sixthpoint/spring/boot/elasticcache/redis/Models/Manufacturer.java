package com.sixthpoint.spring.boot.elasticcache.redis.Models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Manufacturer implements Serializable {
    String ModelNumber;
    Date date;
}

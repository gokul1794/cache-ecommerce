package com.sixthpoint.spring.boot.elasticcache.redis.controller;

import com.sixthpoint.spring.boot.elasticcache.redis.Models.Product;
import com.sixthpoint.spring.boot.elasticcache.redis.controller.util.ResponseUtil;
import com.sixthpoint.spring.boot.elasticcache.redis.service.TaskService;
import com.sixthpoint.spring.boot.elasticcache.redis.service.dto.TaskDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( value = "/commerce" )
public class CommerceController {
    @Autowired
    private TaskService taskService;

    @ApiOperation(
            value = "Perform the long running task")
    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
    public List<Product> GetProducts() throws IOException {
        List<Product> products = taskService.getAllProducts();
        return products;
    }
}

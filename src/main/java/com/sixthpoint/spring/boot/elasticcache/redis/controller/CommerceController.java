package com.sixthpoint.spring.boot.elasticcache.redis.controller;

import com.sixthpoint.spring.boot.elasticcache.redis.Models.Product;
import com.sixthpoint.spring.boot.elasticcache.redis.controller.util.ResponseUtil;
import com.sixthpoint.spring.boot.elasticcache.redis.service.TaskService;
import com.sixthpoint.spring.boot.elasticcache.redis.service.dto.TaskDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping( value = "/ecommerce" )
public class CommerceController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
    public List<Product> GetProducts() throws IOException {
        List<Product> products = taskService.getAllProducts();
        return products;
    }


    @RequestMapping(value = "/getProductCategories", method = RequestMethod.GET)
    public List<String> GetProductCategories() throws IOException {
        List<String> products = taskService.getAllProductCategories();
        return products;
    }


    @RequestMapping(value = "/getProductByCategory/{category}", method = RequestMethod.GET)
    public List<Product> GetProductsByCategory(@PathVariable String category) throws IOException {
        List<Product> products = taskService.getAllProductsByCategory(category);
        return products;
    }


    @RequestMapping(value = "/getProductDetails", method = RequestMethod.GET)
    public List<Product> GetProductDetails(@RequestParam("id") String id) throws IOException {
        List<Product> products = taskService.getProductDetails(id);
        return products;
    }
}

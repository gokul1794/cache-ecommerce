package com.sixthpoint.spring.boot.elasticcache.redis.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sixthpoint.spring.boot.elasticcache.redis.Models.Product;
import com.sixthpoint.spring.boot.elasticcache.redis.service.dto.TaskDTO;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class TaskService {

    @Cacheable(value = "getLongRunningTaskResult", key="{#seconds}", cacheManager = "cacheManager1Hour")
    public Optional<TaskDTO> getLongRunningTaskResult(long seconds) {
        try {
            long randomMultiplier = new Random().nextLong();
            long calculatedResult = randomMultiplier * seconds;
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setCalculatedResult(calculatedResult);
            Thread.sleep(2000); // 2 Second Delay to Simulate Workload
            return Optional.of(taskDTO);
        } catch (InterruptedException e) {
            return Optional.of(null);
        }
    }

    /**
     * An API that will call my own product result
     * @param
     */
    @Cacheable(value = "getProducts", key="{#allProducts}", cacheManager = "cacheManager1Hour")
    public List<Product> getAllProducts() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://127.0.0.1:8080/getProducts")
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        Gson gson = new Gson();
        TypeToken<List<Product>> token = new TypeToken<List<Product>>() {};
        String results = response.body().string();
        List<Product> products = gson.fromJson(results,
                token.getType());
        return products;
    }

    @CacheEvict(value = "getLongRunningTaskResult", key = "#seconds")
    public void resetLongRunningTaskResult(long seconds) {
        // Intentionally blank
    }
}

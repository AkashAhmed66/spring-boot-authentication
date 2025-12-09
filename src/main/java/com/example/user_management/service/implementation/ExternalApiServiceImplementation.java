package com.example.user_management.service.implementation;

import com.example.user_management.service.ExternalApiService;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class ExternalApiServiceImplementation implements ExternalApiService {

    private WebClient webClient;

    public CompletableFuture<Map<String, Object>> callApi1() {
        return webClient.get()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .toFuture();
    }

    public CompletableFuture<Map<String, Object>> callApi2() {
        return webClient.get()
                .uri("https://jsonplaceholder.typicode.com/users/1")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .toFuture();
    }


    public CompletableFuture<Map<String, Object>> ParallelApiCalls() {

        CompletableFuture<Map<String, Object>> api1 = callApi1();
        CompletableFuture<Map<String, Object>> api2 = callApi2();

        return api1.thenCombine(api2, (data1, data2) -> {
            Map<String, Object> finalValue = new HashMap<>();

            finalValue.put("api1", data1);
            finalValue.put("api2", data2);
            return finalValue;
        });
    }
}

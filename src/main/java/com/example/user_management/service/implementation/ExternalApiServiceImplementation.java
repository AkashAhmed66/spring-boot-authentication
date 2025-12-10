package com.example.user_management.service.implementation;

import com.example.user_management.service.ExternalApiService;
import com.example.user_management.utils.AsyncService;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class ExternalApiServiceImplementation implements ExternalApiService {

    private WebClient webClient;
    private AsyncService asyncService;

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

    @Override
    public CompletableFuture<List<Map<String, Object>>> TwoAsyncServiceMergeelApiCalls() {

        CompletableFuture<Map<String, Object>> m1 = asyncService.asyncMethodOne();
        CompletableFuture<Map<String, Object>> m2 = asyncService.asyncMethodTwo();

        List<Map<String, Object>> resultList = Collections.synchronizedList(new ArrayList<>());

        // Add each result in completion order
        m1.thenAccept(resultList::add);
        m2.thenAccept(resultList::add);

        return CompletableFuture.allOf(m1, m2)
                .thenApply(voidResult -> {

                    // Add final summary object
                    Map<String, Object> finalObj = Map.of(
                            "status", "both completed",
                            "time", asyncService.getCurrentTime()
                    );

                    resultList.add(finalObj);

                    return resultList;
                });
    }


}

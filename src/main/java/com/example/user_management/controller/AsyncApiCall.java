package com.example.user_management.controller;

import com.example.user_management.service.ExternalApiService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/public")
public class AsyncApiCall {

    private ExternalApiService externalApiService;

    @GetMapping("/get-external-api-data")
    public ResponseEntity<?> getData() {
        try {
            CompletableFuture<Map<String, Object>> futureResponse = externalApiService.ParallelApiCalls();
            Map<String, Object> response = futureResponse.get(); // Wait for the result
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Exception occurred while calling api: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

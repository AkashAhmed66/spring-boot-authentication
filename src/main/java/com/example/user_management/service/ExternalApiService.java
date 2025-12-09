package com.example.user_management.service;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface ExternalApiService {
    public CompletableFuture<Map<String, Object>> ParallelApiCalls();
}

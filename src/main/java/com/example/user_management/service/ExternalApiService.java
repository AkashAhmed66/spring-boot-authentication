package com.example.user_management.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface ExternalApiService {
    public CompletableFuture<Map<String, Object>> ParallelApiCalls();
    public CompletableFuture<List<Map<String, Object>>> TwoAsyncServiceMergeelApiCalls();
}

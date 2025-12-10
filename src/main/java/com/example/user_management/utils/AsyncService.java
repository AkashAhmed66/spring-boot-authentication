package com.example.user_management.utils;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AsyncService {

    public String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    private void delayRandom() {
        int delay = ThreadLocalRandom.current().nextInt(2000, 5001); // 2–5 sec
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Delay: " + delay + " ms");
    }

    @Async("taskExecutor")
    public CompletableFuture<Map<String, Object>> asyncMethodOne() {
        delayRandom();

        Map<String, Object> response = Map.of(
                "method", "asyncMethodOne",
                "status", "completed at " + getCurrentTime(),
                "message", "This is static data from Method One"
        );

        System.out.println("Async Method One Completed");
        return CompletableFuture.completedFuture(response);
    }

    @Async("taskExecutor")
    public CompletableFuture<Map<String, Object>> asyncMethodTwo() {
        delayRandom();

        Map<String, Object> response = Map.of(
                "method", "asyncMethodTwo",
                "status", "completed at " + getCurrentTime(),
                "message", "This is static data from Method Two"
        );

        System.out.println("Async Method Two Completed");
        return CompletableFuture.completedFuture(response);
    }
}

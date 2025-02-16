package org.example.Annotations;

// Implement a Custom Caching System with @CacheResult
// ✅ Problem Statement:
// Define @CacheResult to store method return values and avoid repeated execution.
// 🔹 Requirements:
// Apply @CacheResult to a computationally expensive method.
// Implement a cache (HashMap) to store previously computed results.
// If method is called with the same input, return cached result instead of re-computation.

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Define @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {
}

class ExpensiveComputation {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeFactorial(int n) {
        if (cache.containsKey(n)) {
            System.out.println("Returning cached result for " + n);
            return cache.get(n);
        }

        System.out.println("Computing factorial for " + n);
        int result = (n <= 1) ? 1 : n * computeFactorial(n - 1);
        cache.put(n, result);
        return result;
    }
}

public class Problem12 {
    public static void main(String[] args) throws Exception {
        ExpensiveComputation computation = new ExpensiveComputation();

        // Calling method multiple times to test caching
        System.out.println("Factorial of 5: " + computation.computeFactorial(5));
        System.out.println("Factorial of 5 (cached): " + computation.computeFactorial(5));
        System.out.println("Factorial of 6: " + computation.computeFactorial(6));
    }
}


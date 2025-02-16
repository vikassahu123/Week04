package org.example.Reflection;

// Method Execution Timing Using Reflection
// ✅ Problem Statement:
// Use Reflection to measure the execution time of methods in a given class dynamically.

import java.lang.reflect.Method;

// Sample class with methods to be measured
class MathOperations1 {
    public void fastMethod() {
        for (int i = 0; i < 1000; i++); // Quick loop
    }

    public void slowMethod() {
        try {
            Thread.sleep(500); // Simulating delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Problem12 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = MathOperations1.class;
        Object obj = clazz.getDeclaredConstructor().newInstance();

        // Iterate through all methods and measure execution time
        for (Method method : clazz.getDeclaredMethods()) {
            long startTime = System.nanoTime();
            method.invoke(obj); // Execute method dynamically
            long endTime = System.nanoTime();

            long executionTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds
            System.out.println("Method: " + method.getName() + " | Execution Time: " + executionTime + " ms");
        }
    }
}


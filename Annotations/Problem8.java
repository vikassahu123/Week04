package org.example.Annotations;

// Create an Annotation for Logging Method Execution Time
// ✅ Problem Statement:
// Define an annotation @LogExecutionTime to measure method execution time.
// 🔹 Requirements:
// Apply @LogExecutionTime to a method.
// Use System.nanoTime() before and after execution.
// Print execution time.
// Apply it on different methods and compare the time taken.

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Define @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {}

class PerformanceTest {
    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Fast method running...");
    }

    @LogExecutionTime
    public void slowMethod() {
        System.out.println("Slow method running...");
        try {
            Thread.sleep(500); // Simulate a slow operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Problem8 {
    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();

        // Measure execution time for methods annotated with @LogExecutionTime
        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(test); // Execute the method
                long endTime = System.nanoTime();
                System.out.println("Execution time of " + method.getName() + ": " + (endTime - startTime) + " nanoseconds");
                System.out.println("------------------------");
            }
        }
    }
}


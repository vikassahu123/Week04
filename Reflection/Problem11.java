package org.example.Reflection;

// Dependency Injection using Reflection
// ✅ Problem Statement:
// Implement a simple DI container that scans classes with @Inject annotation
// and injects dependencies dynamically.

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

// Define @Inject annotation for fields that require dependency injection
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

// Service class to be injected
class Service {
    public void serve() {
        System.out.println("Service is running...");
    }
}

// Client class that depends on Service
class Client {
    @Inject
    private Service service;

    public void doWork() {
        service.serve();
        System.out.println("Client is working...");
    }
}

// Simple Dependency Injection container
class DIContainer {
    public static <T> T createInstance(Class<T> clazz) throws Exception {
        // Create instance of the given class
        T instance = clazz.getDeclaredConstructor().newInstance();

        // Iterate over declared fields
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Constructor<?> constructor = fieldType.getDeclaredConstructor();
                Object dependency = constructor.newInstance();

                field.setAccessible(true); // Allow private field modification
                field.set(instance, dependency);
            }
        }
        return instance;
    }
}

public class Problem11 {
    public static void main(String[] args) throws Exception {
        // Create instance of Client with dependencies injected
        Client client = DIContainer.createInstance(Client.class);

        // Call method to verify DI
        client.doWork();
    }
}

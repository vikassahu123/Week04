package org.example.Reflection;
// Create a Custom Object Mapper using Reflection
// ✅ Problem Statement:
// Implement a method toObject(Class<T> clazz, Map<String, Object> properties)
// that uses Reflection to set field values from a given Map.

import java.lang.reflect.Field;
import java.util.Map;

// Sample class to demonstrate object mapping
class Person1 {
    private String name;
    private int age;

    // Display method to check values
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Problem8 {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create a new instance of the class
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Iterate through map entries and set field values
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true); // Allow access to private fields
                field.set(obj, entry.getValue());
            }

            return obj; // Return the populated object
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Example properties map
        Map<String, Object> properties = Map.of(
                "name", "Alice",
                "age", 25
        );

        // Convert map to Person1 object
        Person1 person = toObject(Person1.class, properties);

        // Display the populated object
        if (person != null) {
            person.display();
        }
    }
}

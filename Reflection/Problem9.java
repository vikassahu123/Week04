package org.example.Reflection;

// Generate a JSON Representation using Reflection
// ✅ Problem Statement:
// Write a program that converts an object to a JSON-like string
// using Reflection by inspecting its fields and values.

import java.lang.reflect.Field;

// Sample class with fields to be converted to JSON
class Person2 {
    private String name;
    private int age;

    // Constructor
    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Problem9 {
    public static String toJson(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            StringBuilder json = new StringBuilder("{");

            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true); // Allow access to private fields
                String fieldName = fields[i].getName();
                Object fieldValue = fields[i].get(obj);

                json.append("\"").append(fieldName).append("\": ");

                if (fieldValue instanceof String) {
                    json.append("\"").append(fieldValue).append("\"");
                } else {
                    json.append(fieldValue);
                }

                if (i < fields.length - 1) {
                    json.append(", ");
                }
            }

            json.append("}");
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public static void main(String[] args) {
        // Create an object of Person1
        Person2 person = new Person2("Alice", 25);

        // Convert object to JSON string
        String jsonString = toJson(person);

        // Print JSON output
        System.out.println(jsonString);
    }
}

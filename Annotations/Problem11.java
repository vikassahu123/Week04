package org.example.Annotations;
// Define an annotation @JsonField to mark fields for JSON serialization
// ✅ Problem Statement:
// Define an annotation @JsonField to mark fields for JSON serialization.
// 🔹 Requirements:
// @JsonField(name = "user_name") should map field names to custom JSON keys.
// Apply it on a User class.
// Write a method to convert object to JSON string by reading the annotations.

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

// Define @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name(); // Custom JSON key name
}

class User1 {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "email_address")
    private String email;

    private int age; // Not annotated, should be ignored in JSON

    public User1(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true); // Allow access to private fields
                JsonField annotation = field.getAnnotation(JsonField.class);
                String key = annotation.name();
                String value = field.get(obj).toString();
                json.append("\"").append(key).append("\": \"").append(value).append("\", ");
            }
        }

        if (json.length() > 1) {
            json.setLength(json.length() - 2); // Remove trailing comma and space
        }
        json.append("}");
        return json.toString();
    }
}

public class Problem11 {
    public static void main(String[] args) throws IllegalAccessException {
        User1 user = new User1("JohnDoe", "john@example.com", 25);
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}

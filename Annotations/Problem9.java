package org.example.Annotations;

// Create a @MaxLength Annotation for Field Validation
// ✅ Problem Statement:
// Define a field-level annotation @MaxLength(int value) that restricts the maximum length of a String field.
// 🔹 Requirements:
// Apply it to a User class field (username).
// Validate length in the constructor.
// Throw IllegalArgumentException if the limit is exceeded.

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

// Define @MaxLength annotation with an integer value
@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10) // Restrict username to a maximum of 10 characters
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
    }

    private void validateMaxLength(String username) {
        try {
            Field field = User.class.getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                int maxLength = field.getAnnotation(MaxLength.class).value();
                if (username.length() > maxLength) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength + " characters.");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void display() {
        System.out.println("Username: " + username);
    }
}

public class Problem9 {
    public static void main(String[] args) {
        try {
            User user1 = new User("JohnDoe"); // Valid
            user1.display();

            User user2 = new User("VeryLongUsername"); // Exceeds max length, throws exception
            user2.display();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


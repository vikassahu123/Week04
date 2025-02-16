package org.example.Reflection;

// Access and Modify Static Fields using Reflection
// ✅ Problem Statement:
// Create a Configuration class with a private static field API_KEY.
// Use Reflection to modify its value and print it.

import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "OLD_KEY"; // Private static field

    // Method to display API key
    public static void displayKey() {
        System.out.println("API Key: " + API_KEY);
    }
}

public class Problem7 {
    public static void main(String[] args) {
        try {
            // Display original API_KEY
            Configuration.displayKey();

            // Access private static field 'API_KEY' using Reflection
            Field apiKeyField = Configuration.class.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true); // Allow access to private field

            // Modify the private static field value
            apiKeyField.set(null, "NEW_SECRET_KEY");

            // Display modified API_KEY
            Configuration.displayKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


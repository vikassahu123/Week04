//Exercise 2: Use @Deprecated to Mark an Old Method
//✅ Problem Statement:
//Create a class LegacyAPI with an old method oldFeature(), which should not be used anymore. Instead, introduce a new method newFeature().
//        🔹 Steps to Follow:
//Define a class LegacyAPI.
//Mark oldFeature() as @Deprecated.
//Call both methods and observe the warning.


package org.example.Annotations;

class LegacyAPI {
    @Deprecated
    void oldFeature() { // Old method (not recommended for use)
        System.out.println("This is an old feature. Use newFeature() instead.");
    }

    void newFeature() { // New recommended method
        System.out.println("This is the new feature.");
    }
}

public class Problem2 {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // Deprecated method (will show a warning)
        api.newFeature(); // New method
    }
}


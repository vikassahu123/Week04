package org.example.Reflection;

// Invoke Private Method using Reflection
// ✅ Problem Statement:
// Define a class Calculator with a private method multiply(int a, int b).
// Use Reflection to invoke this method and display the result.

import java.lang.reflect.Method;

class Calculator {
    // Private method
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        try {
            // Create an instance of Calculator
            Calculator calculator = new Calculator();

            // Access private method 'multiply' using Reflection
            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true); // Allow access to private method

            // Invoke the method with arguments (5, 4)
            int result = (int) multiplyMethod.invoke(calculator, 5, 4);

            // Display the result
            System.out.println("Multiplication Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

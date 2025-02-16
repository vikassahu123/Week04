package org.example.Reflection;

// Dynamic Method Invocation using Reflection
// ✅ Problem Statement:
// Define a class MathOperations with multiple public methods (add, subtract, multiply).
// Use Reflection to dynamically call any method based on user input.

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    // Addition method
    public int add(int a, int b) {
        return a + b;
    }

    // Subtraction method
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplication method
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Create an instance of MathOperations
            MathOperations mathOps = new MathOperations();

            // Get user input for method name
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            // Get user input for two integer values
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Get the method dynamically
            Method method = MathOperations.class.getMethod(methodName, int.class, int.class);

            // Invoke the method dynamically
            int result = (int) method.invoke(mathOps, num1, num2);

            // Display the result
            System.out.println("Result: " + result);
        } catch (NoSuchMethodException e) {
            System.out.println("Invalid method name! Please enter add, subtract, or multiply.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


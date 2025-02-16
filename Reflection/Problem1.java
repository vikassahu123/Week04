package org.example.Reflection;

// Get Class Information using Reflection
// ✅ Problem Statement:
// Write a program to accept a class name as input and display its methods, fields, and constructors using Reflection.

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter full class name (e.g., java.lang.String): ");
        String className = scanner.nextLine();

        try {
            // Load the class dynamically
            Class<?> cls = Class.forName(className);

            // Display class name
            System.out.println("\nClass: " + cls.getName());

            // Display methods
            System.out.println("\nMethods:");
            for (Method method : cls.getDeclaredMethods()) {
                System.out.println("  " + method);
            }

            // Display fields
            System.out.println("\nFields:");
            for (Field field : cls.getDeclaredFields()) {
                System.out.println("  " + field);
            }

            // Display constructors
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                System.out.println("  " + constructor);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found! Please enter a valid class name.");
        }
    }
}

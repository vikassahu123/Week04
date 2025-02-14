//7. finally Block Execution
//💡 Problem Statement:
//Write a program that performs integer division and demonstrates the finally block execution.
//The program should:
//Take two integers from the user.
//Perform division.
//Handle ArithmeticException (if dividing by zero).
//Ensure "Operation completed" is always printed using finally.
//Expected Behavior:
//        If valid, print the result.
//If an exception occurs, handle it and still print "Operation completed".

package org.example.ExceptionHandling;


import java.util.Scanner;

     public class finallyBlockExecution {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.print("Enter the numerator: ");
                int numerator = scanner.nextInt();

                System.out.print("Enter the denominator: ");
                int denominator = scanner.nextInt();

                // Perform division
                int result = numerator / denominator;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                // Handle division by zero
                System.out.println("Error: Division by zero is not allowed.");
            } finally {
                // This block is always executed
                System.out.println("Operation completed");
            }


        }
    }


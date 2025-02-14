//9. Nested try-catch Block
//💡 Problem Statement:
//Write a Java program that:
//Takes an array and a divisor as input.
//Tries to access an element at an index.
//Tries to divide that element by the divisor.
//Uses nested try-catch to handle:
//ArrayIndexOutOfBoundsException if the index is invalid.
//ArithmeticException if the divisor is zero.
//Expected Behavior:
//        If valid, print the division result.
//If the index is invalid, catch and display "Invalid array index!".
//If division by zero, catch and display "Cannot divide by zero!".


package org.example.ExceptionHandling;


import java.util.Scanner;

    public class Nested_try_catchBlock {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int[] array = {10, 20, 30, 40, 50};

            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            System.out.print("Enter divisor: ");
            int divisor = scanner.nextInt();

            try {
                try {
                    int element = array[index];
                    int result = element / divisor;
                    System.out.println("Result: " + result);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid array index!");
                }
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        }
    }


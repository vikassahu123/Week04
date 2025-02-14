//4. Multiple Catch Blocks
//💡 Problem Statement:
//Create a Java program that performs array operations.
//Accept an integer array and an index number.
//Retrieve and print the value at that index.
//Handle the following exceptions:
//ArrayIndexOutOfBoundsException if the index is out of range.
//NullPointerException if the array is null.
//Expected Behavior:
//        If valid, print "Value at index X: Y".
//If the index is out of bounds, display "Invalid index!".
//If the array is null, display "Array is not initialized!".


package org.example.ExceptionHandling;

import java.util.Scanner;

    public class MultipleCatchBlocks {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Example array (you can change or initialize it to null for testing)
            Integer[] numbers = {10, 20, 30, 40, 50};
            // numbers = null; // Uncomment this line to test NullPointerException

            try {
                System.out.print("Enter the index: ");
                int index = scanner.nextInt();

                // Attempt to access the element at the given index
                System.out.println("Value at index " + index + ": " + numbers[index]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid index!");
            } catch (NullPointerException e) {
                System.out.println("Array is not initialized!");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred.");
            }


        }
    }


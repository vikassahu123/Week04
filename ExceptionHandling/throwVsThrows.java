//6. throw vs. throws (Exception Propagation)
//        💡 Problem Statement:
//Create a method calculateInterest(double amount, double rate, int years) that:
//Throws IllegalArgumentException if amount or rate is negative.
//Propagates the exception using throws and handles it in main().
//Expected Behavior:
//If valid, return and print the calculated interest.
//If invalid, catch and display "Invalid input: Amount and rate must be positive".

package org.example.ExceptionHandling;

    public class throwVsThrows {

        // Method to calculate interest, throws IllegalArgumentException if amount or rate is negative
        public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
            if (amount < 0 || rate < 0) {
                throw new IllegalArgumentException("Amount and rate must be positive");
            }
            return amount * rate * years / 100; // Simple interest formula
        }

        public static void main(String[] args) {
            double amount = 1000;
            double rate = 5;
            int years = 2;

            try {
                // Call method to calculate interest
                double interest = calculateInterest(amount, rate, years);
                System.out.println("Calculated Interest: " + interest);
            } catch (IllegalArgumentException e) {
                // Handle exception and display error message
                System.out.println("Invalid input: " + e.getMessage());
            }
        }
    }



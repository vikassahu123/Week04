package org.example.junitProblems;
public class Problem4 {

    // Method to perform division
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

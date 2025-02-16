//Exercise 3: Suppress Unchecked Warnings
//✅ Problem Statement:
//Create an ArrayList without generics and use @SuppressWarnings("unchecked") to hide compilation warnings.


package org.example.Annotations;

import java.util.ArrayList;

public class Problem3 {
    @SuppressWarnings("unchecked") // Suppresses unchecked warnings
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // No generics used
        list.add("Hello");
        list.add(123);

        System.out.println(list);
    }
}

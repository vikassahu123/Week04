package org.example.Reflection;

// Dynamically Create Objects using Reflection
// ✅ Problem Statement:
// Write a program to create an instance of a Student class dynamically using Reflection without using the new keyword.

class Student {
    private String name;

    // Constructor
    public Student() {
        this.name = "Default Student";
    }

    // Method to display student name
    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class Problem4 {
    public static void main(String[] args) {
        try {
            // Create an instance of Student dynamically using Reflection
            Student student = (Student) Class.forName("Student").getDeclaredConstructor().newInstance();

            // Call method on the dynamically created object
            student.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


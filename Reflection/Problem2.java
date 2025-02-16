package org.example.Reflection;

// Access Private Field using Reflection
// ✅ Problem Statement:
// Create a class Person with a private field age. Use Reflection to modify and retrieve its value.

import java.lang.reflect.Field;

class Person {
    private int age; // Private field

    // Constructor
    public Person(int age) {
        this.age = age;
    }

    // Method to display age
    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class Problem2 {
    public static void main(String[] args) {
        try {
            // Create an instance of Person
            Person person = new Person(25);
            person.displayAge();

            // Access private field 'age' using Reflection
            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true); // Allow access to private field

            // Modify the private field value
            ageField.set(person, 30);

            // Retrieve and print modified value
            System.out.println("Modified Age: " + ageField.get(person));

            // Display updated age
            person.displayAge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



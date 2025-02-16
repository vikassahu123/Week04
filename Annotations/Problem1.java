//Exercise 1: Use @Override Correctly
//✅ Problem Statement:
//Create a parent class Animal with a method makeSound(). Then, create a Dog class that overrides this method using @Override.
//🔹 Steps to Follow:
//Define a makeSound() method in Animal class.
//Override it in Dog class with @Override.
//Instantiate Dog and call makeSound().


package org.example.Annotations;

class Animal {
    void makeSound() { // Method to make sound
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() { // Overriding makeSound() in Dog class
        System.out.println("Dog barks");
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Dog myDog = new Dog(); // Creating Dog object
        myDog.makeSound(); // Calls overridden method
    }
}

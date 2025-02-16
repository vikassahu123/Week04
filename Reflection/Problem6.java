package org.example.Reflection;

// Retrieve Annotations at Runtime using Reflection
// ✅ Problem Statement:
// Create a custom annotation @Author(name="Author Name").
// Apply it to a class and use Reflection to retrieve and display the annotation value at runtime.

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;

// Define custom annotation @Author
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

// Apply @Author annotation to a class
@Author(name = "John Doe")
class Book {
    public void display() {
        System.out.println("Book class method.");
    }
}

public class Problem6 {
    public static void main(String[] args) {
        // Retrieve and display annotation value
        Class<Book> obj = Book.class;

        if (obj.isAnnotationPresent(Author.class)) {
            Author author = obj.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        } else {
            System.out.println("No @Author annotation found.");
        }
    }
}


//Create a @Todo Annotation for Pending Tasks
//✅ Problem Statement:
//Define an annotation @Todo to mark pending features in a project.
//        🔹 Requirements:
//The annotation should have fields:
//task() (String) → Description of the task
//assignedTo() (String) → Developer responsible
//priority() (default: "MEDIUM")
//Apply it to multiple methods.
//Retrieve and print all pending tasks using Reflection.


        package org.example.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Define @Todo annotation with fields
@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM"; // Default priority
}

class Project {
    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    public void userLogin() {
        System.out.println("User login feature.");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDB() {
        System.out.println("Database optimization in progress.");
    }

    @Todo(task = "Improve UI design", assignedTo = "Charlie", priority = "LOW")
    public void improveUI() {
        System.out.println("UI improvements.");
    }
}

public class Problem7 {
    public static void main(String[] args) throws Exception {
        Method[] methods = Project.class.getDeclaredMethods();

        // Retrieve and print all @Todo annotations
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("Method: " + method.getName());
                System.out.println("------------------------");
            }
        }

        // Call methods
        Project project = new Project();
        project.userLogin();
        project.optimizeDB();
        project.improveUI();
    }
}

//Exercise 4: Create a Custom Annotation and Use It
//✅ Problem Statement:
//Create a custom annotation @TaskInfo to mark tasks with priority and assigned person.
//        🔹 Steps to Follow:
//Define an annotation @TaskInfo with fields priority and assignedTo.
//Apply this annotation to a method in TaskManager class.
//Retrieve the annotation details using Reflection API.

package org.example.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Define custom annotation
@Retention(RetentionPolicy.RUNTIME) // Retain at runtime for reflection
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Alice") // Applying annotation
    public void completeTask() {
        System.out.println("Task completed.");
    }
}

public class Problem4 {
    public static void main(String[] args) throws Exception {
        // Get method details using reflection
        Method method = TaskManager.class.getMethod("completeTask");

        // Check if annotation is present
        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }

        // Call the method
        new TaskManager().completeTask();
    }
}


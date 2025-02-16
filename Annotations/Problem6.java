//Create an Annotation to Mark Important Methods
//✅ Problem Statement:
//Define a custom annotation @ImportantMethod that can be applied to methods to indicate their importance.
//        🔹 Requirements:
//Define @ImportantMethod with an optional level parameter (default: "HIGH").
//Apply it to at least two methods.
//Retrieve and print annotated methods using Reflection API.


package org.example.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Define custom annotation with an optional level parameter
@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH"; // Default level is HIGH
}

class Operations {
    @ImportantMethod // Uses default level "HIGH"
    public void criticalTask() {
        System.out.println("Executing critical task...");
    }

    @ImportantMethod(level = "MEDIUM") // Custom level
    public void secondaryTask() {
        System.out.println("Executing secondary task...");
    }

    public void normalTask() {
        System.out.println("Executing normal task...");
    }
}

public class Problem6 {
    public static void main(String[] args) throws Exception {
        Method[] methods = Operations.class.getDeclaredMethods();

        // Check for @ImportantMethod annotation and print details
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName() + " (Level: " + annotation.level() + ")");
            }
        }

        // Call the methods
        Operations op = new Operations();
        op.criticalTask();
        op.secondaryTask();
        op.normalTask();
    }
}

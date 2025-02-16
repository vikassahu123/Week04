//Exercise 5: Create and Use a Repeatable Annotation
//✅ Problem Statement:
//Define an annotation @BugReport that can be applied multiple times on a method.
//        🔹 Steps to Follow:
//Define @BugReport with a description field.
//Use @Repeatable to allow multiple bug reports.
//Apply it twice on a method.
//Retrieve and print all bug reports.


package org.example.Annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Container annotation to hold multiple @BugReport annotations
@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

// Define repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

class Software {
    @BugReport(description = "Null pointer exception when input is null")
    @BugReport(description = "Performance issue with large data sets")
    public void processData() {
        System.out.println("Processing data...");
    }
}

public class Problem5 {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("processData");

        // Check if BugReports annotation is present
        if (method.isAnnotationPresent(BugReports.class)) {
            BugReport[] bugReports = method.getAnnotation(BugReports.class).value();
            for (BugReport bug : bugReports) {
                System.out.println("Bug Report: " + bug.description());
            }
        }

        // Call the method
        new Software().processData();
    }
}


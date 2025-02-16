package org.example.Annotations;

// Implement a Role-Based Access Control with @RoleAllowed
// ✅ Problem Statement:
// Define a class-level annotation @RoleAllowed to restrict method access based on roles.
// 🔹 Requirements:
// @RoleAllowed("ADMIN") should only allow ADMIN users to execute the method.
// Simulate user roles and validate access before invoking the method.
// If a non-admin tries to access it, print Access Denied!

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Define @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value(); // Role required to access the method
}

class SecureService {
    @RoleAllowed("ADMIN") // Only ADMIN can access this method
    public void performAdminTask() {
        System.out.println("Admin task executed successfully!");
    }

    public void generalTask() {
        System.out.println("General task executed.");
    }
}

public class Problem10 {
    private static String currentUserRole = "USER"; // Simulated user role

    public static void main(String[] args) throws Exception {
        SecureService service = new SecureService();
        Method[] methods = SecureService.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (currentUserRole.equals(roleAllowed.value())) {
                    method.invoke(service); // Execute method if role matches
                } else {
                    System.out.println("Access Denied! " + method.getName() + " requires " + roleAllowed.value() + " role.");
                }
            } else {
                method.invoke(service); // Execute methods without restriction
            }
        }
    }
}


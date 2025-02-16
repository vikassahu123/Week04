package org.example.Reflection;

// Custom Logging Proxy Using Reflection
// ✅ Problem Statement:
// Implement a Dynamic Proxy that intercepts method calls on an interface
// (e.g., Greeting.sayHello()) and logs the method name before executing it.

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Define an interface with a method to be intercepted
interface Greeting {
    void sayHello(String name);
}

// Implementation of the Greeting interface
class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// Custom InvocationHandler to log method calls
class LoggingHandler implements InvocationHandler {
    private final Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Method called: " + method.getName());
        return method.invoke(target, args); // Execute original method
    }
}

public class Problem10 {
    public static void main(String[] args) {
        // Create the original object
        Greeting original = new GreetingImpl();

        // Create a dynamic proxy
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingHandler(original)
        );

        // Call method on proxy instance
        proxyInstance.sayHello("Alice");
    }
}


//Hospital Triage System
//Simulate a hospital triage system using a PriorityQueue where patients with higher severity are treated first.
//Example:
//Patients: [("John", 3), ("Alice", 5), ("Bob", 2)] → Order: Alice, John, Bob.

package org.example.queueProblems;
import java.util.*;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // Sorting in descending order (higher severity first)
    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class QueueThird {
    public static void main(String[] args) {
        // PriorityQueue with custom ordering based on severity (higher first)
        PriorityQueue<Patient> queue = new PriorityQueue<>();

        // Adding patients
        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        // Treating patients based on priority
        System.out.println("Order of treatment:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll()); // Remove highest priority patient
        }
    }
}

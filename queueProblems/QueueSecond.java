//Generate Binary Numbers Using a Queue
//Generate the first N binary numbers (as strings) using a queue.
//Example:
//N=5 → Output: ["1", "10", "11", "100", "101"].
//

package org.example.queueProblems;
import java.util.List;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSecond {
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1"); // Start with "1"

        for (int i = 0; i < N; i++) {
            String binary = queue.remove(); // Dequeue the front element
            result.add(binary); // Store the binary number

            // Generate next two binary numbers
            queue.add(binary + "0");
            queue.add(binary + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        List<String> binaryNumbers = generateBinaryNumbers(N);

        System.out.println("First " + N + " binary numbers: " + binaryNumbers);
    }
}

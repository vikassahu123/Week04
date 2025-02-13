//Reverse a Queue
//Reverse the elements of a queue using only queue operations (e.g., add, remove, isEmpty).
//Example:
//Input: [10, 20, 30] → Output: [30, 20, 10].

package org.example.queueProblems;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;
import java.util.function.Predicate;

public class QueueFirst {

    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        while (!queue.isEmpty()) {  // stack is use for geting element from last to front --> so this become reverse.
            st.add(i, queue.poll());
            i++;
        }


            while (!st.isEmpty()) {
                queue.add(st.pop());
            }

    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        reverseQueue(queue);
        System.out.println(queue);




    }
}

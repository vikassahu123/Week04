//Circular Buffer Simulation
//Implement a circular buffer (fixed-size queue) using an array-based queue. When full, overwrite the oldest element.
//        Example:
//Buffer size=3: Insert 1, 2, 3 → Insert 4 → Buffer: [2, 3, 4].

package org.example.queueProblems;

public class QueueFive {
    private int[] buffer;
    private int size;
    private int front, rear;
    private boolean isFull;

    public QueueFive(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.front = 0;
        this.rear = 0;
        this.isFull = false;
    }

    // Inserting an element into the circular buffer
    public void enqueue(int value) {
        if (isFull) {
            // Overwriting the oldest element by moving the front pointer
            front = (front + 1) % size;
        }

        buffer[rear] = value;
        rear = (rear + 1) % size;

        // Condition to check if buffer is full (If rear catches up with front, buffer is full)
        isFull = (rear == front);
    }

    // Retrieving all elements from the buffer (without removing)
    public void displayBuffer() {
        if (!isFull && rear == front) {
            System.out.println("Buffer is empty!");
            return;
        }

        System.out.print("Circular Buffer: ");
        int i = front;
        while (true) {
            System.out.print(buffer[i] + " ");
            i = (i + 1) % size;
            if (i == rear && !isFull) break;
            if (i == front && isFull) break;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueFive cb = new QueueFive(3);

        cb.enqueue(10);
        cb.enqueue(20);
        cb.enqueue(30);
        cb.displayBuffer();

        cb.enqueue(40);
        cb.displayBuffer();

        cb.enqueue(50);
        cb.displayBuffer();
    }
}

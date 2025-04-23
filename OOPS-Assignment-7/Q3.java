
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Stack {

    private int[] array;
    private int capacity;
    private int top;

    // Lock for synchronization
    private final ReentrantLock lock = new ReentrantLock();
    // Condition for stack full
    private final Condition stackFull = lock.newCondition();
    // Condition for stack empty
    private final Condition stackEmpty = lock.newCondition();

    public Stack(int size) {
        capacity = size;
        array = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int value) throws InterruptedException {
        lock.lock();
        try {
            // Wait if stack is full
            while (isFull()) {
                System.out.println(Thread.currentThread().getName() + " waiting, stack is full");
                stackFull.await();
            }

            // Push element
            array[++top] = value;
            System.out.println(Thread.currentThread().getName() + " pushed: " + value + " at position: " + top);

            // Signal that stack is no longer empty
            stackEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int pop() throws InterruptedException {
        lock.lock();
        try {
            // Wait if stack is empty
            while (isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " waiting, stack is empty");
                stackEmpty.await();
            }

            // Pop element
            int value = array[top--];
            System.out.println(Thread.currentThread().getName() + " popped: " + value);

            // Signal that stack is no longer full
            stackFull.signalAll();

            return value;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return top + 1;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class MultithreadedStack {

    public static void main(String[] args) {
        // Create a stack with capacity 10
        Stack stack = new Stack(10);

        // Producer threads to push elements
        Thread producer1 = new Thread(() -> {
            try {
                for (int i = 1; i <= 7; i++) {
                    stack.push(i * 10);
                    Thread.sleep(100); // Slow down for demonstration
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Producer-1");

        Thread producer2 = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    stack.push(i * 100);
                    Thread.sleep(150); // Slow down for demonstration
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Producer-2");

        // Consumer thread to pop elements when stack is full
        Thread consumer = new Thread(() -> {
            try {
                // Wait until stack is full or both producers are done
                Thread.sleep(1000);

                System.out.println("\n" + Thread.currentThread().getName()
                        + " checking if stack is full...");

                // Pop all elements from the stack
                System.out.println("\n" + Thread.currentThread().getName()
                        + " popping all elements from the stack:");
                while (!stack.isEmpty()) {
                    stack.pop();
                    Thread.sleep(200); // Slow down for demonstration
                }

                System.out.println("\nStack is now empty.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer");

        // Start all threads
        producer1.start();
        producer2.start();
        consumer.start();

        // Wait for all threads to complete
        try {
            producer1.join();
            producer2.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class SimpleStack {

    private int[] array;
    private int capacity;
    private int top;

    public SimpleStack(int size) {
        capacity = size;
        array = new int[capacity];
        top = -1;
    }

    public synchronized boolean isEmpty() {
        return top == -1;
    }

    public synchronized boolean isFull() {
        return top == capacity - 1;
    }

    public synchronized int size() {
        return top + 1;
    }

    public synchronized void push(int value) throws InterruptedException {

        while (isFull()) {
            System.out.println(Thread.currentThread().getName() + " waiting, stack is full");
            wait();
        }

        array[++top] = value;
        System.out.println(Thread.currentThread().getName() + " pushed: " + value + " at position: " + top);

        notifyAll();
    }

    public synchronized int pop() throws InterruptedException {

        while (isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " waiting, stack is empty");
            wait();
        }

        int value = array[top--];
        System.out.println(Thread.currentThread().getName() + " popped: " + value);

        notifyAll();

        return value;
    }
}

public class Q3 {

    public static void main(String[] args) {

        SimpleStack stack = new SimpleStack(10);

        Thread producer1 = new Thread(() -> {
            try {
                for (int i = 1; i <= 7; i++) {
                    stack.push(i * 10);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }
        }, "Producer-1");

        Thread producer2 = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    stack.push(i * 100);
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
            }
        }, "Producer-2");

        Thread consumer = new Thread(() -> {
            try {

                Thread.sleep(1000);

                System.out.println("\n" + Thread.currentThread().getName()
                        + " checking stack size : " + stack.size() + "...");

                System.out.println("\n" + Thread.currentThread().getName()
                        + " popping all elements from the stack:");
                while (!stack.isEmpty()) {
                    stack.pop();
                    Thread.sleep(200);
                }

                System.out.println("\nStack is now empty.");
            } catch (InterruptedException e) {
            }
        }, "Consumer");

        producer1.start();
        producer2.start();
        consumer.start();

        try {
            producer1.join();
            producer2.join();
            consumer.join();
        } catch (InterruptedException e) {
        }
    }
}

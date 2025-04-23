
class BlockSynchronization {

    private int counter = 0;
    private static int classCounter = 0;

    public void incrementCounter() {

        synchronized (this) {
            counter++;
            System.out.println(Thread.currentThread().getName() + " increment counter to: " + counter);
        }

    }

    public static void incrementClassCounter() {

        synchronized (BlockSynchronization.class) {
            classCounter++;
            System.out.println(Thread.currentThread().getName() + " - Class counter: " + classCounter);
        }

    }

    public int getCounter() {
        return counter;
    }

    public static int getClassCounter() {
        return classCounter;
    }
}

public class Q2 {

    public static void main(String[] args) {
        BlockSynchronization obj1 = new BlockSynchronization();
        BlockSynchronization obj2 = new BlockSynchronization();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                obj1.incrementCounter();
                BlockSynchronization.incrementClassCounter();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                obj1.incrementCounter();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }, "Thread-2");

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                obj2.incrementCounter();
                BlockSynchronization.incrementClassCounter();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
        }

        System.out.println("Final counter value for obj1: " + obj1.getCounter());
        System.out.println("Final counter value for obj2: " + obj2.getCounter());
        System.out.println("Final class counter value: " + BlockSynchronization.getClassCounter());
    }
}

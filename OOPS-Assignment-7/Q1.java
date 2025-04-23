
class Synchronization {

    private int counter = 0;
    private static int classCounter = 0;

    // Object-level
    public synchronized void incrementCounter() {
        counter++;
        System.out.println(Thread.currentThread().getName() + " increment counter to: " + counter);
    }

    // Class-level 
    public static synchronized void incrementClassCounter() {
        classCounter++;
        System.out.println(Thread.currentThread().getName() + " - Class counter: " + classCounter);
    }

    public int getCounter() {
        return counter;
    }

    public static int getClassCounter() {
        return classCounter;
    }
}

class Q1 {

    public static void main(String[] args) {
        Synchronization obj1 = new Synchronization();
        Synchronization obj2 = new Synchronization();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                obj1.incrementCounter();
                Synchronization.incrementClassCounter();
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
                Synchronization.incrementClassCounter();
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
        System.out.println("Final class counter value: " + Synchronization.getClassCounter());
    }
}

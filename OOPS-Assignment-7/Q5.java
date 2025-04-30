
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// I have lock in this question because 
// I have used the synchronized in Question 3 (somewhat same)
class PubSub {

    private int[] buffer;
    private int count;
    private int in;
    private int out;
    private int capacity;

    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public PubSub(int size) {
        this.in = 0;
        this.out = 0;
        this.count = 0;
        this.capacity = size;
        this.buffer = new int[capacity];
    }

    public void producer(int item) throws InterruptedException {
        lock.lock();
        try {
            while (count == capacity) {
                System.out.println(Thread.currentThread().getName()
                        + " - Buffer full, waiting to produce: " + item);
                notFull.await();
            }

            buffer[in] = item;
            in = (in + 1) % capacity;
            count++;

            System.out.println(Thread.currentThread().getName()
                    + " produced: " + item + " | Buffer count: " + count);

            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int consumer() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                System.out.println(Thread.currentThread().getName()
                        + " - Buffer empty, waiting to consume");
                notEmpty.await();
            }

            int item = buffer[out];
            out = (out + 1) % capacity;
            count--;

            System.out.println(Thread.currentThread().getName()
                    + " consumed: " + item + " | Buffer count: " + count);

            notFull.signalAll();
            return item;
        } finally {
            lock.unlock();
        }
    }

}

class Q5 {

    public static void main(String[] args) {
        PubSub ps = new PubSub(5);
        int noOfPub = 2;
        int noOfSub = 4;

        Thread[] pubs = new Thread[noOfPub];
        Thread[] subs = new Thread[noOfSub];

        for (int i = 0; i < noOfPub; i++) {
            pubs[i] = new Thread(() -> {
                try {
                    for (int k = 0; k < 10; k++) {
                        ps.producer(k);
                        Thread.sleep((100));
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Producer " + (i + 1));
        }

        for (int i = 0; i < noOfSub; i++) {
            subs[i] = new Thread(() -> {
                try {
                    for (int k = 0; k < 10; k++) {
                        ps.consumer();
                        Thread.sleep((300));
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Consumer " + (i + 1));
        }

        for (int i = 0; i < noOfPub; i++) {
            pubs[i].start();
        }
        for (int i = 0; i < noOfSub; i++) {
            subs[i].start();
        }

        for (int i = 0; i < noOfPub; i++) {
            try {
                pubs[i].join();
            } catch (InterruptedException e) {
            }
        }
        for (int i = 0; i < noOfSub; i++) {
            try {
                subs[i].join(10000);
            } catch (InterruptedException e) {
            }
        }
    }
}

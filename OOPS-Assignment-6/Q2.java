
import java.util.Random;

class SearchTask extends Thread {

    private int[] array;
    private int start, end, target;
    private boolean found = false;
    private long timeTaken;

    public SearchTask(int[] array, int start, int end, int target) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.target = target;
    }

    public void run() {
        long startTime = System.nanoTime();

        for (int i = start; i < end; i++) {
            if (array[i] == target) {
                found = true;
                System.out.println("Thread " + this.getName() + " found the element at index " + i);
                break;
            }
        }

        long endTime = System.nanoTime();
        timeTaken = (endTime - startTime) / 1_000_000; // Convert to milliseconds

        System.out.println("Thread " + this.getName() + " finished in " + timeTaken + " ms");
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public boolean isFound() {
        return found;
    }
}

public class Q2 {

    public static void main(String[] args) {
        int size = 10_000_000;
        int[] array = new int[size];
        Random rand = new Random();

        // Fill array with random numbers
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10_000_000);
        }

        int target = array[rand.nextInt(size)]; // Pick a random value that is guaranteed to exist

        int numThreads = 4;
        SearchTask[] threads = new SearchTask[numThreads];
        int chunkSize = size / numThreads;

        System.out.println("Searching for: " + target);

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? size : start + chunkSize;
            threads[i] = new SearchTask(array, start, end, target);
            threads[i].setName("T" + (i + 1));
            threads[i].start();
        }

        // Wait for all threads to complete
        for (SearchTask thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }

        System.out.println("Search completed.");
    }
}

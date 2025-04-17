
import java.util.Random;

class SearchTask extends Thread {

    private int[] arr;
    private int start, end, target;
    private boolean found = false;
    private long timeTaken;

    public SearchTask(int[] arr, int start, int end, int target) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.target = target;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();

        for (int i = start; i < end; i++) {
            if (arr[i] == target) {
                found = true;
                System.out.println("Thread " + getName() + " found the element at index : " + i);
                break;
            }
        }

        long endTime = System.nanoTime();
        timeTaken = (endTime - startTime) / 1_000_000; // to milliseconds

        System.out.println("Thread " + getName() + " finished : " + timeTaken + " ms");
    }
}

public class Q2 {

    public static void main(String[] args) {
        int n = 500_000; // same as 500000, this syntax make it readable
        int[] arr = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10_000_000);
        }
        /* choosing high value to avoid duplicate target but 
        there is no problem with duplicate value, all thread 
        will notify if they found the target in their range but 
        if there are multiple target in the same range if a 
        thread then It will only notify the first one found.
         */

        int target = arr[rand.nextInt(n)];

        int numThreads = 5;
        SearchTask[] threads = new SearchTask[numThreads];
        int chunkSize = n / numThreads;

        System.out.println("Searching for: " + target);

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? n : start + chunkSize;
            threads[i] = new SearchTask(arr, start, end, target);
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

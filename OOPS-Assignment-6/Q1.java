
class MyThread extends Thread {

    @Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("MyThread: " + i + " - " + Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("MyThread interrupted.");
			}
		}
	}
}

class MyRunnable implements Runnable {

    @Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("MyRunnable: " + i + " - " + Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("MyRunnable interrupted.");
			}
		}
	}
}

public class Q1 {

    public static void main(String[] args) {
        // Using extends Thread
        MyThread t1 = new MyThread();
        t1.start();

        // Using implements Runnable
        MyRunnable runnable = new MyRunnable();
        Thread t2 = new Thread(runnable);
        t2.start();

        // Thread t3 = new Thread(() -> {
		// 	Thread t = Thread.currentThread();
        //     System.out.println("Name: " + t.getName());
        //     System.out.println("ID: " + t.threadId());
        //     System.out.println("Priority: " + t.getPriority());
        //     System.out.println("State: " + t.getState());
        //     System.out.println("Alive: " + t.isAlive());
        //     System.out.println("Daemon: " + t.isDaemon());
        // });
		// t3.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        }
    }
}

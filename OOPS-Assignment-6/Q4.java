
class MyThread extends Thread {

    public MyThread(String name, int priority) {
        setName(name);
        setPriority(priority);
    }

    @Override
    public void run() {
        System.out.println("Thread Name : " + Thread.currentThread().getName());
        System.out.println("Thread Priority : " + Thread.currentThread().getPriority());
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + ": " + i);
        }
        System.out.println(getName() + " finished.\n");
    }
}

class Q4 {

    public static void main(String[] args) {
        MyThread t1 = new MyThread("LowPriorityThread", Thread.MIN_PRIORITY);     // 1
        MyThread t2 = new MyThread("NormalPriorityThread", Thread.NORM_PRIORITY); // 5
        MyThread t3 = new MyThread("HighPriorityThread", Thread.MAX_PRIORITY);    // 10

        // Highest priority thread will run before the lowwer priority thread but its not garunteed
        t1.start();
        t2.start();
        t3.start();
    }
}

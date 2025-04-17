
class YieldThread extends Thread {

    public YieldThread() {
        setName("YieldThread");
    }

    @Override
    public void run() {
        System.out.println(getName() + ": Started");
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + ": " + i);
            Thread.yield(); // Suggests CPU to switch to another thread
        }
        System.out.println(getName() + ": Finished");
    }
}

class SleepThread extends Thread {

    SleepThread() {
        setName("SleepThread");
    }

    @Override
    public void run() {
        System.out.println("SleepThread: Started");
        for (int i = 1; i <= 3; i++) {
            System.out.println("SleepThread: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("SleepThread interrupted");
            }
        }
        System.out.println("SleepThread: Finished");
    }
}

class JoinThread extends Thread {

    Thread toJoin;

    public JoinThread(Thread toJoin) {
        this.toJoin = toJoin;
    }

    @Override
    public void run() {
        System.out.println("JoinThread: Waiting for SleepThread to finish...");
        try {
            toJoin.join(); // Wait for SleepThread to finish
        } catch (InterruptedException e) {
            System.out.println("JoinThread interrupted");
        }

        System.out.println("JoinThread: SleepThread has finished, now running...");
        for (int i = 1; i <= 3; i++) {
            System.out.println("JoinThread: " + i);
        }
        System.out.println("JoinThread: Finished");
    }
}

public class Q3 {

    public static void main(String[] args) {
        YieldThread yt = new YieldThread();
        SleepThread st = new SleepThread();
        JoinThread jt = new JoinThread(st);

        yt.start();  // May give up CPU using yield()
        st.start();  // Sleeps between iterations
        jt.start();  // Waits for SleepThread using join()
    }
}

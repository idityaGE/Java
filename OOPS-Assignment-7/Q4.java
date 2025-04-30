
class Resource1 {

    private String name = "Resource 1";

    public synchronized String getResource() {
        System.out.println(Thread.currentThread().getName() + " acquired lock on " + name);
        return name;
    }

    public synchronized void useResource(Resource2 r2) {
        System.out.println(Thread.currentThread().getName() + " trying to use " + r2.getName());
        r2.getResource();
    }

    public String getName() {
        return name;
    }
}

class Resource2 {

    private String name = "Resource 2";

    public synchronized String getResource() {
        System.out.println(Thread.currentThread().getName() + " acquired lock on " + name);
        return name;
    }

    public synchronized void useResource(Resource1 r1) {
        System.out.println(Thread.currentThread().getName() + " trying to use " + r1.getName());
        r1.getResource();
    }

    public String getName() {
        return name;
    }
}

class Q4 {

    public static void main(String[] args) {

        final Resource1 r1 = new Resource1();
        final Resource2 r2 = new Resource2();

        Thread t1 = new Thread(() -> {
            try {
                r1.getResource();

                Thread.sleep(100); 
                
                System.out.println(Thread.currentThread().getName() + " trying to access Resource2");
                r1.useResource(r2);

            } catch (InterruptedException e) {
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            try {
                r2.getResource();

                Thread.sleep(100);

                System.out.println(Thread.currentThread().getName() + " trying to access Resource1");
                r2.useResource(r1);

            } catch (InterruptedException e) {
            }
        }, "Thread-2");

        Thread monitor = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("\n***** DEADLOCK DETECTED *****");
                System.out.println("Thread-1 state: " + t1.getState());
                System.out.println("Thread-2 state: " + t2.getState());
                System.out.println("\nExplaining the deadlock:");
                System.out.println("1. Thread-1 holds lock on Resource1 and waits for Resource2");
                System.out.println("2. Thread-2 holds lock on Resource2 and waits for Resource1");
                System.out.println("3. Neither thread can proceed, resulting in deadlock");
            } catch (InterruptedException e) {
            }
        }, "Monitor");

        monitor.setDaemon(true);

        System.out.println("Starting threads...");
        t1.start();
        t2.start();
        monitor.start();

        try {
            t1.join(5000); // Wait with timeout
            t2.join(5000);
        } catch (Exception e) {
        }

        System.out.println("Main thread completed. Program execution will hang due to deadlock.");
    }
}

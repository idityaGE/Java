
interface Vehicle {

    void start(); // Abstract method (public & abstract by default)

    void stop();
}

class Car implements Vehicle {

    public void start() {
        System.out.println("Car is starting");
    }

    public void stop() {
        System.out.println("Car is stopping");
    }
}

public class GlobalObject {

    public static void main(String[] args) {
        Vehicle myCar = new Car();
        Vehicle myCar2 = myCar;

        if (myCar == myCar2) {
            System.out.println("Hello");
        }
        myCar.start();
        myCar.stop();
        System.out.println(myCar.toString());
        System.out.println(myCar2.toString());
        System.out.println(myCar.hashCode());
        System.out.println(myCar2.hashCode());
    }
}

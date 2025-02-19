
interface Animal {

    int leg = 4;

    void makeSound();

    // void sleep();
    default void sleep() {
        System.out.println("Animal is sleeping...");
    }

    private void takebath() {
        System.out.println("Animal takebath");
    }

    static void act() {
        System.out.println("Animal is acting...");
    }

    default void show() {
        System.out.println("Default method in B");
    }
}

interface Pet {

    void play();

    void sleep();

    default void show() {
        System.out.println("Default method in A");
    }
}

class Dog implements Pet, Animal {

    public Dog() {}

    @Override
    public void sleep() {
        System.out.println("Sleep from Dog class");
    }

    @Override
    public void play() {
        System.out.println("Play from Dog");
    }

    @Override
    public void makeSound() {
        System.out.println("Dog Barks");
    }

    @Override // must override to solve the confilict
    public void show() {
        System.out.println("Overriding default show()");
    }

}

public class Interfcae {

    public static void main(String[] args) {
        Dog ob = new Dog();
        ob.sleep();
    }
}

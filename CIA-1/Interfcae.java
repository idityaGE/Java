
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
}

interface Pet {

    void play();

    void sleep();
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

}

public class Interfcae {

    public static void main(String[] args) {
        Dog ob = new Dog();
        ob.sleep();
    }
}

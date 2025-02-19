
abstract class Animal {

    // can have variables
    private String name;
    protected int age;

    // can have constuctor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Abstract Method
    abstract void makeSound();

    // Concrete method
    public void displayInfo() {
        System.out.println("Animal: " + name + ", Age : " + age);
    }

    // static Method
    static void sleep() {
        System.out.println("Animal Sleeping ....");
    }
}

class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Dog Barks");
    }

    static void sleep() {
        System.out.println("Dogs Sleeping ...");
    }
}

public class Abstract {

    public static void main(String[] args) {
        Animal.sleep();
        Dog.sleep();
        
        Animal ob;
        ob = new Dog("Bruno", 14);
        ob.sleep();
        
        Dog ob1;
        ob1 = new Dog("Shimba", 12);
        ob1.sleep();
        ob1.makeSound();
    }
}

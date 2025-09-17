// Required Enums for Food Type
enum FoodType {
    MEAT, SEEDS, WORMS, PLANKTON
}

// Abstract Base Class: Animal
abstract class Animal {
    protected String name;
    protected int age;
    protected String healthStatus;

    public Animal(String name, int age, String healthStatus) {
        this.name = name;
        this.age = age;
        this.healthStatus = healthStatus;
    }

    public abstract void move();

    public void feed(FoodType food) {
        System.out.println(name + " is fed with " + food);
    }

    public void feed(FoodType food, int quantity) {
        System.out.println(name + " is fed with " + quantity + " units of " + food);
    }

    public abstract void sound();
}

// Subclass: Mammal
class Mammal extends Animal {
    public Mammal(String name, int age, String healthStatus) {
        super(name, age, healthStatus);
    }

    @Override
    public void move() {
        System.out.println(name + " walks around.");
    }

    @Override
    public void sound() {
        System.out.println(name + " makes a mammal sound.");
    }
}

// Subclass: Bird
class Bird extends Animal {
    public Bird(String name, int age, String healthStatus) {
        super(name, age, healthStatus);
    }

    @Override
    public void move() {
        System.out.println(name + " flies around.");
    }

    @Override
    public void sound() {
        System.out.println(name + " chirps.");
    }
}

// Subclass: Fish
class Fish extends Animal {
    public Fish(String name, int age, String healthStatus) {
        super(name, age, healthStatus);
    }

    @Override
    public void move() {
        System.out.println(name + " swims around.");
    }

    @Override
    public void sound() {
        System.out.println(name + " makes a bubbling sound."); // Not realistic, but for the sake of this example
    }
}

// Test class
public class ZooManagement {
    public static void main(String[] args) {
        Mammal lion = new Mammal("Lion", 5, "Healthy");
        lion.move();
        lion.sound();
        lion.feed(FoodType.MEAT);
        lion.feed(FoodType.MEAT, 5);

        Bird parrot = new Bird("Parrot", 2, "Healthy");
        parrot.move();
        parrot.sound();
        parrot.feed(FoodType.SEEDS);

        Fish goldfish = new Fish("Goldfish", 1, "Healthy");
        goldfish.move();
        goldfish.sound();
        goldfish.feed(FoodType.PLANKTON, 3);
    }
}

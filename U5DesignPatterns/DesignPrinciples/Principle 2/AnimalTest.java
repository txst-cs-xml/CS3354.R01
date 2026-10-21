import java.util.ArrayList;
import java.util.List;

// AFTER: clients depend on the Animal contract.
public class AnimalTest {
    public static void main(String[] args) {
        List<Animal> animals = makeSomeAnimals();
        makeAllSounds(animals);
    }

    public static List<Animal> makeSomeAnimals() {
        // Concrete types are selected where objects are created.
        Animal dog = new Dog();
        Animal cat = new Cat();
        List<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(cat);
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Duck());
        return animals;
    }

    public static void makeAllSounds(List<Animal> animals) {
        for (Animal animal : animals) {
            // No casts or knowledge of bark/meow/quack are needed.
            animal.makeSound();
        }
    }

    // An abstract class can define a contract, just as an interface can.
    public abstract static class Animal {
        public abstract void makeSound();
    }

    public static class Dog extends Animal {
        @Override
        public void makeSound() {
            bark();
        }

        private void bark() {
            System.out.println("Woof");
        }
    }

    public static class Cat extends Animal {
        @Override
        public void makeSound() {
            meow();
        }

        private void meow() {
            System.out.println("Meow");
        }
    }

    public static class Duck extends Animal {
        @Override
        public void makeSound() {
            quack();
        }

        private void quack() {
            System.out.println("Quack");
        }
    }
}

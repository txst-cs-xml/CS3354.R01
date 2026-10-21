// BEFORE: clients depend on concrete types and their specific methods.
public class AnimalTestBefore {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Dog anotherDog = new Dog();
        Cat anotherCat = new Cat();
        Duck duck = new Duck();
        makeAllSounds(dog, cat, anotherDog, anotherCat, duck);
    }

    public static void makeAllSounds(
            Dog dog, Cat cat, Dog anotherDog, Cat anotherCat, Duck duck) {
        // Supporting a new animal type requires editing this client method.
        dog.bark();
        cat.meow();
        anotherDog.bark();
        anotherCat.meow();
        duck.quack();
    }

    public static class Dog {
        public void bark() {
            System.out.println("Woof");
        }
    }

    public static class Cat {
        public void meow() {
            System.out.println("Meow");
        }
    }

    public static class Duck {
        public void quack() {
            System.out.println("Quack");
        }
    }
}

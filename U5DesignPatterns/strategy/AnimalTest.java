
import java.util.ArrayList;

public class AnimalTest {
 
	public static void main(String[] args) {
		AnimalTest at = new AnimalTest();
		ArrayList<Animal> animals = at.makeSomeAnimals();
		animals.forEach(Animal::makeSound);  // can call makeSound on any Animal
	}
	public ArrayList<Animal> makeSomeAnimals() {
		Animal dog = new Dog();
		Animal cat = new Cat();
		// treat dogs and cats as their supertype, Animal
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(dog);
		animals.add(cat);
		animals.add(new Dog());
		animals.add(new Cat());
		animals.add(new Duck());
		return animals;
	}
	
	public abstract class Animal {
		abstract void makeSound();
	}
	public class Dog extends Animal {
		void makeSound() {
			bark();
		}
		void bark() {
			System.out.println("Woof");
		}
	}
	public class Cat extends Animal {
		void makeSound() {
			meow();
		}
		void meow() {
			System.out.println("Meow");
		}
	}
	public class Duck extends Animal {
		void makeSound() {
			quick();
		}
		void quick() {
			System.out.println("quick");
		}
	}
}

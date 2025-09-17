// Superclass: Animal
abstract class Animal {
    // Field in the superclass
    String type = "Generic Animal";
    
    // Method in the superclass
    abstract void sound();
}

// Subclass: Dog
class Dog extends Animal {
    // Field in the subclass
    String breed = "Labrador";
    
    public void dogMethod() {
        System.out.println("A method defined in the dog class");
    }
    
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

// Subclass: Cat
class Cat extends Animal {
    // Field in the subclass
    String color = "Black";
    
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

// public class TestPolymorphism {
//     public static void main(String[] args) {
//         Animal myAnimal = new Dog();
//         myAnimal.sound();  // Outputs: Dog barks (polymorphism)

//         myAnimal = new Cat();
//         myAnimal.sound();  // Outputs: Cat meows (polymorphism)

//         myAnimal = new Animal();
//         myAnimal.sound();  // Outputs: Animal makes a sound

//         Dog dog = new Dog();
//         printSound(dog);

//         Cat cat = new Cat();
//         printSound(cat);

//     }

//     public static void printSound(Animal animal) {
//         animal.sound();
//         animal = new Animal();
//     }
// }

public class TestCasting {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.dogMethod();
        dog.sound();
        Animal animal = dog; // upcasting
        animal.sound();
        //animal.dogMethod(); // Error 

        if(animal instanceof Dog) {
            Dog mydog = (Dog)animal;
            mydog.dogMethod();
        }
        else {
            System.out.println("Invalid Downcasting");
        }

        if(animal instanceof Cat) {
            Cat mycat = (Cat)animal;
        }
        else {
            System.out.println("Invalid Downcasting");
        }
    }
}


// // Main class demonstrating runtime polymorphism and casting
// public class TestPolymorphism {
//     public static void main(String[] args) {
//         // Runtime Polymorphism: Superclass reference, subclass object
//         Animal myAnimal = new Dog();
//         myAnimal.sound();  // Outputs: Dog barks (polymorphism)

//         // Accessing superclass field
//         System.out.println("Type: " + myAnimal.type);  // Outputs: Generic Animal
        
//         // The following line will cause a compile-time error because breed is not a field in Animal
//         // System.out.println("Breed: " + myAnimal.breed);  // Error: Cannot find symbol

//         // Upcasting example
//         Dog myDog = new Dog();
//         Animal myUpcastedAnimal = myDog;  // Upcasting Dog to Animal
//         myUpcastedAnimal.sound();  // Outputs: Dog barks (polymorphism)
//         System.out.println("Breed: " + myUpcastedAnimal.breed); // Error: cannot find breed 

//         // Downcasting example with instanceof check
//         if (myUpcastedAnimal instanceof Dog) {
//             Dog downcastedDog = (Dog) myUpcastedAnimal;  // Downcasting back to Dog
//             System.out.println("Breed after downcasting: " + downcastedDog.breed);  // Outputs: Labrador
//         } else {
//             System.out.println("The object is not a Dog.");
//         }

//         // Demonstrating with Cat
//         Animal myCat = new Cat();
//         myCat.sound();  // Outputs: Cat meows (polymorphism)
//         System.out.println("Type: " + myCat.type);  // Outputs: Generic Animal

//         // Attempting downward casting to access specific fields of Cat
//         if (myCat instanceof Cat) {
//             Cat downcastedCat = (Cat) myCat;  // Downcasting back to Cat
//             System.out.println("Color after downcasting: " + downcastedCat.color);  // Outputs: Black
//         } else {
//             System.out.println("The object is not a Cat.");
//         }
//     }
// }

# Design Principle 2: Program to an Interface

> Program to an interface, not an implementation.

This means **program to a supertype**: declare variables, parameters, and return types using a shared contract when that contract supplies the operations you need. Client code can then use different concrete implementations through the same operations.

“Interface” here does not require Java's `interface` keyword. An abstract class can also define a contract. In this example, the abstract class `Animal` promises a `makeSound()` operation, and each subclass supplies its implementation.

## Before: depend on concrete types

[AnimalTestBefore.java](AnimalTestBefore.java) declares concrete `Dog`, `Cat`, and `Duck` variables. Its client method, `makeAllSounds()`, must know each type and its specific method:

```java
dog.bark();
cat.meow();
duck.quack();
```

To support a cow, the client method would need another parameter and a call to `moo()`. The client is coupled to the details of each animal.

## After: depend on a shared contract

[AnimalTest.java](AnimalTest.java) is the after version. The original file already applied the principle through its abstract `Animal` class. This revision separates object creation from the sound-making client, declares collections using `List`, and corrects the duck's `quick()` method to `quack()`.

```java
Animal dog = new Dog();
dog.makeSound();
```

The variable's declared type is `Animal`, while the object's actual type is `Dog`. The compiler checks that `Animal` offers `makeSound()`. At runtime, Java selects `Dog.makeSound()` through dynamic dispatch. The client does not need to call `bark()` itself.

The client processes every animal through the same contract:

```java
public static void makeAllSounds(List<Animal> animals) {
    for (Animal animal : animals) {
        animal.makeSound();
    }
}
```

| Before | After |
| --- | --- |
| Client parameters use concrete animal types. | Client accepts a `List<Animal>`. |
| Client calls `bark()`, `meow()`, and `quack()`. | Client calls `makeSound()`. |
| A new type requires editing the sound-making client. | A new `Animal` subclass works with the existing client. |

The collection declaration also applies the principle:

```java
List<Animal> animals = new ArrayList<>();
```

`List` is an interface; `ArrayList` is its concrete implementation. Creation code could choose another compatible list implementation without changing `makeAllSounds()`.

Concrete types still appear where objects are created. `makeSomeAnimals()` chooses which animals to construct; `makeAllSounds()` only uses their contract. The principle reduces implementation dependencies in clients rather than eliminating concrete classes everywhere.

## Extend the example

Add this nested class inside `AnimalTest`:

```java
public static class Cow extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Moo");
    }
}
```

Then add `animals.add(new Cow());` before the return in `makeSomeAnimals()`. The existing `makeAllSounds()` method needs no changes.

Alternatively, `Animal` could be a Java interface declaring `void makeSound();`, with the concrete classes using `implements Animal`. The client would still use the same contract.

## Run both versions

With a JDK installed, run these commands from the `Principle 2` folder:

```sh
mkdir -p out
javac -d out AnimalTestBefore.java AnimalTest.java
java -cp out AnimalTestBefore
java -cp out AnimalTest
```

Both versions print:

```text
Woof
Meow
Woof
Meow
Quack
```

The observable behavior is the same; the improvement is how the client depends on the animals. Helper classes are nested so both examples can compile together.

## When to apply it

Use a meaningful supertype when multiple implementations share behavior that a client needs. Declaring everything as `Object` would lose access to `makeSound()` and force casts. Implementations should honor the shared contract so clients can use them interchangeably.

Principle 1 focuses on separating what varies. Principle 2 focuses on how clients refer to and use those parts: through an abstraction. The principles often work together.

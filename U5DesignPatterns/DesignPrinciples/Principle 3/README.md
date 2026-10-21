# Design Principle 3: Favor Composition over Inheritance

> Favor composition over inheritance. A **HAS-A** relationship can be more flexible than an **IS-A** relationship.

Inheritance gives a subclass the fields and behavior of its parent. It works well when the subclass truly satisfies the parent's contract and the inherited behavior is stable. It becomes restrictive when subclasses need different combinations of behavior or must change behavior while the program is running.

Composition builds an object from other objects. Instead of inheriting how to fly or quack, a `Duck` **has a** `FlyBehavior` and **has a** `QuackBehavior`. Each behavior can vary independently.

## Before: behavior through inheritance

[DuckInheritanceBefore.java](DuckInheritanceBefore.java) puts `fly()` and `quack()` in the base `Duck` class. This causes several problems:

- `RubberDuck` inherits `fly()` even though it cannot fly and must override it.
- Each new way of flying requires another duck subclass or override.
- Combining flight and quack behaviors can lead to many subclasses.
- An object's inherited behavior is fixed by its runtime class.

For example, `RocketDuck` exists only to replace the inherited flight implementation. If several duck types need rocket flight, the same override may be repeated.

## After: behavior through composition

[DuckCompositionAfter.java](DuckCompositionAfter.java) extracts the varying behaviors into two families:

```java
interface FlyBehavior {
    void fly();
}

interface QuackBehavior {
    void quack();
}
```

`Duck` stores one implementation of each interface:

```java
class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;
}
```

The relationship is now **HAS-A**: a duck has flying and quacking behavior objects. A mallard can combine `FlyWithWings` with `Quack`, while a rubber duck can combine `FlyNoWay` with `Squeak`.

The rubber duck later receives `FlyRocketPowered` through `setFlyBehavior()`. Its behavior changes at runtime without changing the `Duck` class or creating a special `RocketDuck` subclass.

| Inheritance version | Composition version |
| --- | --- |
| Behavior is defined by the class hierarchy. | Behavior is supplied by collaborating objects. |
| Subclasses override unwanted behavior. | Each object receives only the behavior it needs. |
| Sharing behavior can require duplicate overrides. | Multiple objects can reuse one behavior class. |
| Runtime behavior is fixed by the object's class. | A behavior can be replaced at runtime. |

This design is an example of the **Strategy pattern**: each behavior interface represents a family of interchangeable algorithms.

## Composition is a preference, not a prohibition

“Favor composition” does not mean inheritance is always wrong. Inheritance remains useful when:

- the subtype genuinely satisfies the parent's contract;
- shared behavior represents a stable IS-A relationship;
- clients can safely substitute the subtype for the parent type.

Composition is usually a better choice when behavior varies independently, different combinations are needed, or behavior must change at runtime. It adds extra objects and interfaces, so very small programs may not need the added structure.

## Run the examples

From the `Principle 3` folder, run:

```sh
mkdir -p out
javac -d out DuckInheritanceBefore.java DuckCompositionAfter.java
java -cp out DuckInheritanceBefore
java -cp out DuckCompositionAfter
```

Both examples print:

```text
Flying with wings
Squeak
Cannot fly
Flying with a rocket
```

The observable behaviors are the same, but the after version assigns rocket flight to the existing rubber duck at runtime.

Try adding a `MuteQuack` implementation and assigning it to a duck. The `Duck` class will not need to change.

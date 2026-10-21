# Design Principle 1: Encapsulate What Varies

> Identify the aspects of your application that vary and separate them from what stays the same.

When one part of a program changes often, give it a separate home and a clear interface. The rest of the program can use that interface without knowing the details. You can then change or extend the variable behavior while leaving the stable code alone.

Here, **encapsulation** means more than making fields private: it means hiding a changing implementation behind a boundary, such as an interface and a set of classes.

## Example 1: Shipping rules before and after

[ShippingBefore.java](ShippingBefore.java) mixes shipping prices with checkout logic. `Checkout` chooses a price using an `if/else` chain. Each new shipping option requires another change inside `Checkout`.

[ShippingAfter.java](ShippingAfter.java) separates those responsibilities:

| Part | Role |
| --- | --- |
| `Checkout.totalInCents()` | Stable rule: add shipping to the subtotal. |
| `ShippingPolicy` | Interface through which checkout requests a shipping cost. |
| `StandardShipping`, `ExpressShipping` | Variable pricing rules, each in its own class. |
| `StorePickup` | New behavior added without editing `Checkout`. |

To change the standard shipping price, edit `StandardShipping`. To add another option, implement `ShippingPolicy` and pass that object to `Checkout`. The code that selects or constructs the policy still needs to know about the new option; the checkout calculation does not.

The examples use integer cents to avoid floating-point rounding for money. Prices are illustrative, and taxes, discounts, and input validation are omitted to keep the focus on the principle.

## Example 2: Duck flying behavior

[DuckDemo.java](DuckDemo.java) keeps shared swimming behavior in `Duck` and moves varying flight behavior into implementations of `FlyBehavior`.

A mallard receives `FlyWithWings`, while a model duck receives `CannotFly`. The model duck later receives `RocketFlight` through `setFlyBehavior()`. Its flying behavior changes at runtime without changing the `Duck` class or creating another duck object.

Both examples use the **Strategy pattern**: a containing object delegates work to an interchangeable behavior object. Strategy is one way to apply this broader design principle; not every application needs a separate class for each variation.

## Run the examples

With a JDK installed, run these commands from the `Principle 1` folder:

```sh
mkdir -p out
javac -d out ShippingBefore.java ShippingAfter.java DuckDemo.java
java -cp out ShippingBefore
java -cp out ShippingAfter
java -cp out DuckDemo
```

`ShippingBefore` prints:

```text
Standard total (cents): 10500
Express total (cents): 11500
```

`ShippingAfter` preserves those totals and adds pickup:

```text
Standard total (cents): 10500
Express total (cents): 11500
Pickup total (cents): 10000
```

`DuckDemo` prints:

```text
Swimming on the water.
Flying with wings!
I cannot fly.
Flying with a rocket!
```

Each source file is self-contained, with helper types nested inside its public class.

## Applying the principle

1. Identify behavior that changes independently, such as pricing, sorting, or notification delivery.
2. Separate it from the stable workflow that uses it.
3. Give the workflow a small interface for invoking that behavior.
4. Supply an implementation where the objects are created, or replace it at runtime if needed.

This reduces the number of places you must edit and lets you reuse or test behaviors independently. It also introduces extra types and indirection, so use it for meaningful variation rather than splitting every line of code into a class.

Try adding `OvernightShipping` without editing `Checkout`, or adding a new `FlyBehavior` without editing `Duck`.

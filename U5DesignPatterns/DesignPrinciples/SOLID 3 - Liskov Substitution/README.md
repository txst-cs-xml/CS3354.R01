# Liskov Substitution Principle (LSP)

Based on the Liskov Substitution Principle examples in *m5.2.1DesignPriciples.pdf*, printed slides 16–20 (the numbers shown on the slides, not PDF page positions).

A subtype must be usable wherever its supertype is expected without breaking that supertype's behavioral contract. Matching method signatures is not enough: callers must still be able to rely on the promised behavior.

## Before

`Rectangle` promises independent width and height setters. `Square extends Rectangle` overrides either setter to change both dimensions, preserving square geometry but breaking the rectangle API's contract.

The same client sets width to 5 and then height to 4. A rectangle has area 20. A square ends with both sides equal to 4, so its area is 16. The program deliberately prints this mismatch rather than crashing: it is the defect being demonstrated.

## After

`Rectangle` and `Square` independently implement `Shape`, whose contract only requires `area()`. A rectangle holds width and height; a square holds a side. Both use immutable dimensions. The client requests an area, with no promise of independent resizing, so either implementation satisfies its expectations.

This changes the abstraction and the client rather than pretending that the old independent-resizing contract works for squares. LSP does not require different shapes to return equal areas. It requires each to honor the same promised operation. A mathematical “is a” relationship alone does not justify inheritance for a mutable API.

The slide's after snippet mixes `int area()` and `double area()` and omits method bodies. This runnable adaptation consistently uses `public int area()` and explicit constructors. Dimensions are small positive integers for the demonstration; general geometry validation and overflow handling are outside its scope.

**Try it:** implement another `Shape` and pass it to `printArea()` without type checks.

## Files and running

- [LSPBefore.java](LSPBefore.java): runnable violation of the principle.
- [LSPAfter.java](LSPAfter.java): runnable refactoring following the principle.

With JDK 8 or newer installed, run from this folder:

```sh
mkdir -p out
javac -d out LSPBefore.java LSPAfter.java
java -cp out LSPBefore
java -cp out LSPAfter
```

Helper types are nested inside each example's public class, so the files can compile together without name collisions. No external libraries are needed.

Before output:

```text
Expected area: 20, actual: 20
Expected area: 20, actual: 16
```

After output:

```text
Area: 20
Area: 16
```

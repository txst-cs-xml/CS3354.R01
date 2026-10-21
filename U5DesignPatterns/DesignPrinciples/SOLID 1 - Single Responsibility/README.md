# Single Responsibility Principle (SRP)

Based on the Single Responsibility Principle examples in *m5.2.1DesignPriciples.pdf*, printed slides 6–10 (the numbers shown on the slides, not PDF page positions).

A class should have one reason to change: one cohesive responsibility. This does not mean one method per class. Several methods can support the same responsibility.

## Before

`Order` manages items and totals, formats printed output, and stores a snapshot. Business-rule changes, presentation changes, and storage changes all require editing the same class.

## After

| Class | Responsibility | Example reason to change |
| --- | --- | --- |
| `Order` | Order data and business rules | Change total calculation rules |
| `OrderViewer` | Presentation | Change receipt formatting |
| `OrderRepository` | Persistence | Replace in-memory storage with a database |

The demo creates the same order and produces the same total in both versions. In the after version, the caller coordinates three classes. Presentation and storage changes can now be made independently of order calculations.

The lecture's placeholder methods are reduced to a runnable subset: item management, total calculation, printing, and saving. Storage uses in-memory snapshots and money uses integer cents. `getItems()` returns a copy, and items are immutable, so callers cannot modify the order through its returned list. No actual database or printer is involved.

**Try it:** change receipt formatting in `OrderViewer` without editing `Order` or `OrderRepository`. Avoid splitting related business operations merely to make classes smaller.

## Files and running

- [SRPBefore.java](SRPBefore.java): runnable violation of the principle.
- [SRPAfter.java](SRPAfter.java): runnable refactoring following the principle.

With JDK 8 or newer installed, run from this folder:

```sh
mkdir -p out
javac -d out SRPBefore.java SRPAfter.java
java -cp out SRPBefore
java -cp out SRPAfter
```

Helper types are nested inside each example's public class, so the files can compile together without name collisions. No external libraries are needed.

Before output:

```text
Notebook: 500 cents
Pen: 200 cents
Total: 700 cents
Saved items: 2
```

After output:

```text
Notebook: 500 cents
Pen: 200 cents
Total: 700 cents
Saved items: 2
```

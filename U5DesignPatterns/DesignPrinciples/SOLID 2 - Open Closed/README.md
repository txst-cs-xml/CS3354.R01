# Open/Closed Principle (OCP)

Based on the Open/Closed Principle examples in *m5.2.1DesignPriciples.pdf*, printed slides 11–15 (the numbers shown on the slides, not PDF page positions).

Software should be open for extension but closed for modification. Design a stable extension point so adding a supported kind of behavior does not require rewriting the client that uses it.

## Before

The lecture's `GraphicEditor` checks numeric shape types. Drawing behavior lives in its conditional branches. Adding a triangle requires modifying the editor; an unknown type currently prints an unsupported message.

## After

An abstract `Shape` declares `draw()`. `Rectangle`, `Circle`, and the added `Triangle` implement their own drawing behavior. `GraphicEditor.drawShape()` simply calls `shape.draw()`.

The added triangle demonstrates extension without modifying the editor. The setup code still creates the new shape; closed for modification does not mean that no code anywhere may change. Bug fixes and changes to requirements can still require edits. The extension point here specifically supports adding shape types.

Drawing is represented by console output so the example requires no graphics library. Keep regression checks for existing shapes when extending the system; extensibility does not guarantee that testing other behavior is unnecessary.

**Try it:** add `Ellipse extends Shape` and pass it to the existing editor without adding a type check.

## Files and running

- [OCPBefore.java](OCPBefore.java): runnable violation of the principle.
- [OCPAfter.java](OCPAfter.java): runnable refactoring following the principle.

With JDK 8 or newer installed, run from this folder:

```sh
mkdir -p out
javac -d out OCPBefore.java OCPAfter.java
java -cp out OCPBefore
java -cp out OCPAfter
```

Helper types are nested inside each example's public class, so the files can compile together without name collisions. No external libraries are needed.

Before output:

```text
Drawing rectangle
Drawing circle
Unsupported shape type: 3
```

After output:

```text
Drawing rectangle
Drawing circle
Drawing triangle
```

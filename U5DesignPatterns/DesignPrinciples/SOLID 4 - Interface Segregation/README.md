# Interface Segregation Principle (ISP)

Based on the Interface Segregation Principle examples in *m5.2.1DesignPriciples.pdf*, printed slides 21–23 (the numbers shown on the slides, not PDF page positions).

Clients should not be forced to depend on methods they do not use. Give each client a focused capability interface, and let a class implement multiple capabilities when appropriate.

## Before

`IMachine` combines printing, scanning, and faxing. `SimplePrinter` must implement all three even though it only prints. The lecture marks scanning and faxing as inapplicable; this runnable version throws and catches `UnsupportedOperationException` to make that mismatch visible.

Even `printDocument()` depends on the entire `IMachine` interface despite needing only `print()`.

## After

`IPrinter`, `IScanner`, and `IFax` describe separate capabilities. `SimplePrinter` implements only `IPrinter`; `MultiFunctionPrinter` implements all three. Each client function accepts only the interface it needs.

A simple printer can be passed to `printDocument()` but cannot be passed to `scanDocument()` at compile time. No dummy methods or runtime failure are needed. All operations print messages rather than accessing physical devices.

ISP concerns the scope of interfaces and client dependencies. SRP concerns reasons for a class to change. They complement each other, but ISP does not require every interface to contain exactly one method; related methods can belong to one cohesive capability.

**Try it:** add a device that implements `IPrinter` and `IScanner` but not `IFax`.

## Files and running

- [ISPBefore.java](ISPBefore.java): runnable violation of the principle.
- [ISPAfter.java](ISPAfter.java): runnable refactoring following the principle.

With JDK 8 or newer installed, run from this folder:

```sh
mkdir -p out
javac -d out ISPBefore.java ISPAfter.java
java -cp out ISPBefore
java -cp out ISPAfter
```

Helper types are nested inside each example's public class, so the files can compile together without name collisions. No external libraries are needed.

Before output:

```text
Printing document
SimplePrinter cannot scan
SimplePrinter cannot fax
```

After output:

```text
Printing document
Printing document
Scanning document
Faxing document
```

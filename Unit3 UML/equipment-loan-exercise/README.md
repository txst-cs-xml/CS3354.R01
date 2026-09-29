# Equipment-loan class diagram exercise

Draw a UML class diagram from the supplied Java files.

The system must satisfy these rules:

1. Each loan records exactly one borrower and one item.
2. Completed loans remain in the system as history.
3. An item has at most one active loan at a time.
4. A borrower has at most three active loans at a time.

Include each domain class and interface, its attributes and methods, visibility,
relationships, and association multiplicities. Mark abstract classes and methods.
Show navigation where the code stores a reference. Include constraints that cannot
be expressed using the multiplicities of the stored relationships alone.

You may omit constructors, Java library types, and `Demo` from the diagram.
Treat `List<T>` as a collection of `T`, rather than drawing a separate `List` class.
Avoid showing a reference twice as both an attribute and an association unless
your instructor requests both forms.

Assumptions: this is a single-threaded, in-memory program with one `LoanSystem`.
Each real borrower and physical item is represented by one reused Java object.
Client code creates and completes loans through `LoanSystem`. History lasts for
the running program; saving data to disk is outside this exercise.

Ownership comments are part of the design specification. The catalog groups
independently existing items. A loan's period is exclusively owned by that loan.
Decide which UML relationships express these intentions.

To run with Java 8 or later, open a terminal in this folder:

```sh
mkdir -p out
javac -d out *.java
java -cp out Demo
```

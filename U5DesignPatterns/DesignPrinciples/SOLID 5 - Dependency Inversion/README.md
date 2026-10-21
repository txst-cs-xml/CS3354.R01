# Dependency Inversion Principle (DIP)

Based on the Dependency Inversion Principle examples in *m5.2.1DesignPriciples.pdf*, printed slides 24–26 (the numbers shown on the slides, not PDF page positions).

High-level policy should not depend directly on low-level implementation details. Both should depend on abstractions, and the abstractions should not depend on those details.

## Before

`ReportGenerator` is the high-level report policy. It constructs a concrete `MySQLDatabase` and stores it in a concrete field. Switching data sources requires changing the report class, and supplying controlled test data is difficult.

Dependency: `ReportGenerator -> MySQLDatabase`.

## After

`IDatabase` defines the `getData()` operation the report needs, returning a neutral `Data` object with no MySQL-specific types. `ReportGenerator` depends on that contract. `MySQLDatabase` and `InMemoryDatabase` implement it.

Dependencies: `ReportGenerator -> IDatabase <- MySQLDatabase` (and `InMemoryDatabase`). The arrows describe code dependencies, not the runtime direction of data flow.

Constructor injection supplies an `IDatabase` to the generator. `main()` chooses the implementation, so the report logic runs unchanged with either data source. The second source returns 3 orders to visibly demonstrate that substitution.

Dependency injection is the mechanism used here; DIP is the design of the dependencies. Injecting a concrete `MySQLDatabase` alone would still couple the generator to that detail. No dependency-injection framework is required.

Both data sources are simulations. `MySQLDatabase` returns fixed sample data; it does not connect to MySQL or require drivers, credentials, or a running server. This fills in the lecture's placeholders while keeping the example self-contained.

**Try it:** supply an `IDatabase` implementation returning zero orders without changing `ReportGenerator`.

## Files and running

- [DIPBefore.java](DIPBefore.java): runnable violation of the principle.
- [DIPAfter.java](DIPAfter.java): runnable refactoring following the principle.

With JDK 8 or newer installed, run from this folder:

```sh
mkdir -p out
javac -d out DIPBefore.java DIPAfter.java
java -cp out DIPBefore
java -cp out DIPAfter
```

Helper types are nested inside each example's public class, so the files can compile together without name collisions. No external libraries are needed.

Before output:

```text
Report: 12 orders
```

After output:

```text
Report: 12 orders
Report: 3 orders
```

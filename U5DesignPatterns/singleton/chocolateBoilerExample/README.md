# Singleton chocolate boiler: shared production equipment

Requires Java 11 or newer. Run from the `singleton` directory:

```sh
mkdir -p /tmp/singleton-examples/boiler
javac -d /tmp/singleton-examples/boiler chocolateBoilerExample/*.java
java -cp /tmp/singleton-examples/boiler ChocolateController
java -cp /tmp/singleton-examples/boiler ChocolateBoilerChecks
```

The application models two production lines sharing one 100-liter boiler.
One line requests three 60-liter milk chocolate batches; the other requests two
40-liter dark chocolate batches. Both obtain the same `ChocolateBoiler` instance.
The controller waits for both lines and reports **5 batches, 260 liters, EMPTY**.
Thread scheduling changes the order of batches across runs.

The allowed lifecycle is:

```text
EMPTY --fill(recipe, liters)--> FILLED --boil()--> BOILED --drain()--> EMPTY
```

The boiler rejects invalid recipes, quantities outside 1–100 liters, filling an
occupied boiler, boiling an empty or already boiled boiler, and draining before
boiling. Exceptions make misuse visible. Rejected requests leave state intact.
Draining resets the contents and updates shared production totals. The original
`fill()` method remains available and fills a 100-liter milk chocolate batch.

A private constructor and synchronized `getInstance()` create one shared object.
Synchronized state methods protect individual operations. That alone does not
make a sequence of calls atomic: a second line could otherwise boil or drain the
first line's batch between its calls. `produceBatch()` holds the boiler monitor
for the entire fill/boil/drain cycle. Concurrent production lines use this method;
individual methods are provided for the lifecycle demonstration and checks.
Java's reentrant monitors allow `produceBatch()` to call the synchronized methods.

`ChocolateBoilerChecks` verifies concurrent singleton access, capacity and state
validation, reset after draining, and exact totals from four competing lines.
Run checks in a fresh JVM because the singleton retains state for the JVM's life.

This is a simulation: boiling updates state immediately. It has no heater,
sensors, timing, or actual equipment safety controls. A Java singleton exists
within a class loader in one JVM; multiple control processes would require
coordination outside this singleton. Global access also couples callers to the
concrete boiler; passing a shared boiler interface to clients is useful when
isolated tests or alternative hardware implementations are needed.

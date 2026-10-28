# Singleton logger: a chocolate shop checkout

Requires Java 11 or newer. Run commands from the `singleton` directory.
The examples intentionally use the default package, so compile each into its
own output directory (both versions contain a class named `Application`).

```sh
mkdir -p /tmp/singleton-examples/logger /tmp/singleton-examples/non-singleton
javac -d /tmp/singleton-examples/logger LoggerExample/Singleton/*.java
java -cp /tmp/singleton-examples/logger Application /tmp/chocolate-shop.log
java -cp /tmp/singleton-examples/logger LoggerChecks
javac -d /tmp/singleton-examples/non-singleton LoggerExample/NonSingleton/*.java
java -cp /tmp/singleton-examples/non-singleton Application
```

`Application` wires together an `OrderService`, `InventoryService`, and simulated
`PaymentService`. Each service independently calls `Logger.getInstance()`.
Orders demonstrate successful checkout, declined payment with stock returned,
and insufficient stock. Prices use integer cents. Payments never contact a real
payment service.

The singleton has a private constructor, one static instance, and a synchronized
access method. All services share its minimum log level, message counter, and
output file. Changing the level once changes logging throughout the application.
Messages contain timestamps, sequence numbers, severity, and thread names.
File output appends across runs; sequence numbers restart with each JVM.
Without a file argument, the application writes `application.log` in its working
directory. File failures propagate instead of being silently ignored.

`LoggerChecks` verifies concurrent instance access, filtering, and ordered file
writes without lost messages. Run it in a fresh JVM. Synchronizing instance
creation is only half the story: log writes and configuration also need
synchronization because the instance contains mutable shared state.

The non-singleton comparison creates separate order and payment loggers: enabling
debug on one does not affect the other, and each starts its own message count.
Multiple instances are not inherently a design error; explicitly passing one
shared logger to the services is also a valid design and makes testing easier.

This is a teaching implementation. It opens the file for each message to keep
resource management visible and simple. A production logging library would add
features such as rotation, structured records, and efficient output buffering.
A singleton is shared within its class loader in one JVM, not across separate
processes. Shared global state also makes isolated tests harder. The checkout
simulation is not a transactional order or payment system.

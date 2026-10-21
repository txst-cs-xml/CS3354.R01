# Design Principle 3: Strive for Loosely Coupled Designs

> Strive for loosely coupled designs between objects that interact.

Coupling describes how much one object knows about and depends on another. In a tightly coupled design, an object knows concrete class names, method details, and often how many collaborators exist. A change to one object can therefore force changes in several others.

In a loosely coupled design, interacting objects depend on a small, stable contract. They know what operation is available but do not need to know the concrete implementation. This limits the effect of change and makes objects easier to extend, reuse, and test independently.

## Before: concrete displays are built into the station

[WeatherStationBefore.java](WeatherStationBefore.java) contains a weather station that holds one `CurrentConditionsDisplay` and one `StatisticsDisplay`. When measurements change, the station calls each concrete display differently:

```java
currentDisplay.update(temperature, humidity);
statisticsDisplay.update(temperature);
```

This creates several dependencies:

- `WeatherStation` knows every concrete display class.
- It knows the parameters required by each display.
- Adding or removing a display requires editing `WeatherStation`.
- The number and kinds of displays are fixed by its fields and constructor.

The classes work, but changes to display requirements spread into the weather station.

## After: communicate through an observer contract

[WeatherStationAfter.java](WeatherStationAfter.java) introduces one small interface:

```java
interface WeatherObserver {
    void update(double temperature, double humidity);
}
```

Every interested display implements `WeatherObserver`. The station stores a `List<WeatherObserver>` and sends the same notification to each observer. It does not know whether an observer presents current conditions, records statistics, calculates a heat index, or performs some future task.

```text
WeatherStation -> WeatherObserver <- Display implementations
```

The station and displays still depend on each other enough to collaborate. Loose coupling means minimizing unnecessary knowledge, not removing all relationships.

## What improves

| Before | After |
| --- | --- |
| Station fields use concrete display types. | The station stores `WeatherObserver` references. |
| Each display may require a different call. | Every observer receives the same notification. |
| Adding a display changes station code. | A display implements the interface and registers itself. |
| Displays are fixed when the station is created. | Observers can be added and removed at runtime. |

`HeatIndexDisplay` demonstrates the extension: it is added without modifying `WeatherStation`. The sample also removes the statistics display at runtime. The station iterates over a copy of its observer list, so a callback could safely add or remove an observer without causing a concurrent-modification failure in this simple, single-threaded example.

This example uses the **Observer pattern**, a common way to apply loose coupling when one object must notify an unknown set of interested objects. An interface alone does not guarantee low coupling; the interface should remain focused and should avoid exposing implementation details.

The heat-index calculation is intentionally simplified so the example stays focused on object relationships rather than meteorology.

## Run both versions

From the `Principle 3` folder:

```sh
mkdir -p out
javac -d out WeatherStationBefore.java WeatherStationAfter.java
java -cp out WeatherStationBefore
java -cp out WeatherStationAfter
```

The before version prints:

```text
Current conditions: 78.5 F and 65.0% humidity
Temperature recorded: 78.5 F
```

The after version prints:

```text
Current conditions: 78.5 F and 65.0% humidity
Temperature recorded: 78.5 F
Simplified heat index: 80.5 F
After removing the statistics display:
Current conditions: 80.0 F and 55.0% humidity
Simplified heat index: 80.0 F
```

## Relationship to the earlier principles

- Principle 1 encapsulates the parts that vary. Here, display behavior varies independently of the weather station.
- Principle 2 programs to a supertype. Here, the station declares collaborators as `WeatherObserver` rather than concrete displays.
- Principle 3 describes the result: the station and displays have fewer dependencies on each other's details.

To extend the example, create another `WeatherObserver`, register it in `main()`, and confirm that `WeatherStation` needs no changes.

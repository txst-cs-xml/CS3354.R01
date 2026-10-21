import java.util.ArrayList;
import java.util.List;

// AFTER: the station and displays interact through a small observer contract.
public class WeatherStationAfter {
    interface WeatherObserver {
        void update(double temperature, double humidity);
    }

    static class WeatherStation {
        private final List<WeatherObserver> observers = new ArrayList<>();

        void addObserver(WeatherObserver observer) {
            observers.add(observer);
        }

        void removeObserver(WeatherObserver observer) {
            observers.remove(observer);
        }

        void measurementsChanged(double temperature, double humidity) {
            // The station treats every listener through the same contract.
            for (WeatherObserver observer : new ArrayList<>(observers)) {
                observer.update(temperature, humidity);
            }
        }
    }

    static class CurrentConditionsDisplay implements WeatherObserver {
        @Override
        public void update(double temperature, double humidity) {
            System.out.printf(
                    "Current conditions: %.1f F and %.1f%% humidity%n",
                    temperature, humidity);
        }
    }

    static class StatisticsDisplay implements WeatherObserver {
        @Override
        public void update(double temperature, double humidity) {
            System.out.printf("Temperature recorded: %.1f F%n", temperature);
        }
    }

    // This new display requires no changes to WeatherStation.
    static class HeatIndexDisplay implements WeatherObserver {
        @Override
        public void update(double temperature, double humidity) {
            double heatIndex = temperature + (humidity >= 60.0 ? 2.0 : 0.0);
            System.out.printf("Simplified heat index: %.1f F%n", heatIndex);
        }
    }

    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        WeatherObserver current = new CurrentConditionsDisplay();
        WeatherObserver statistics = new StatisticsDisplay();
        WeatherObserver heatIndex = new HeatIndexDisplay();

        station.addObserver(current);
        station.addObserver(statistics);
        station.addObserver(heatIndex);
        station.measurementsChanged(78.5, 65.0);

        station.removeObserver(statistics);
        System.out.println("After removing the statistics display:");
        station.measurementsChanged(80.0, 55.0);
    }
}

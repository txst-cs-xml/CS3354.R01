// BEFORE: the weather station depends directly on every concrete display.
public class WeatherStationBefore {
    static class CurrentConditionsDisplay {
        void update(double temperature, double humidity) {
            System.out.printf(
                    "Current conditions: %.1f F and %.1f%% humidity%n",
                    temperature, humidity);
        }
    }

    static class StatisticsDisplay {
        void update(double temperature) {
            System.out.printf("Temperature recorded: %.1f F%n", temperature);
        }
    }

    static class WeatherStation {
        private final CurrentConditionsDisplay currentDisplay;
        private final StatisticsDisplay statisticsDisplay;

        WeatherStation(
                CurrentConditionsDisplay currentDisplay,
                StatisticsDisplay statisticsDisplay) {
            this.currentDisplay = currentDisplay;
            this.statisticsDisplay = statisticsDisplay;
        }

        void measurementsChanged(double temperature, double humidity) {
            // The station knows each display type and how to call it.
            currentDisplay.update(temperature, humidity);
            statisticsDisplay.update(temperature);
        }
    }

    public static void main(String[] args) {
        CurrentConditionsDisplay current = new CurrentConditionsDisplay();
        StatisticsDisplay statistics = new StatisticsDisplay();
        WeatherStation station = new WeatherStation(current, statistics);

        station.measurementsChanged(78.5, 65.0);
    }
}

import java.util.ArrayList;
import java.util.List;

class EmployeeTimeClock {
    private static final double OVERTIME_RATE = 1.5; // Overtime pay rate (1.5 times regular pay)
    private List<TimeEntry> timeEntries;
    private double hourlyWage;

    public EmployeeTimeClock(double hourlyWage) {
        this.timeEntries = new ArrayList<>();
        this.hourlyWage = hourlyWage;
    }

    public void clockIn(int year, int month, int day, int hour, int minute) {
        TimeEntry entry = new TimeEntry(year, month, day, hour, minute, true);
        timeEntries.add(entry);
    }

    public void clockOut(int year, int month, int day, int hour, int minute) {
        TimeEntry entry = new TimeEntry(year, month, day, hour, minute, false);
        timeEntries.add(entry);
    }

    public double calculateWorkHours() {
        double totalWorkHours = 0.0;
        int size = timeEntries.size();

        if (size % 2 != 0) {
            System.out.println("Incomplete clock-in/clock-out entries.");
            return totalWorkHours;
        }

        for (int i = 0; i < size; i += 2) {
            TimeEntry clockIn = timeEntries.get(i);
            TimeEntry clockOut = timeEntries.get(i + 1);

            if (clockOut.isBefore(clockIn)) {
                System.out.println("Invalid clock-in/clock-out times.");
                return totalWorkHours;
            }

            totalWorkHours += clockIn.calculateHoursWorked(clockOut);
        }

        return totalWorkHours;
    }

    public double calculateOvertimePay() {
        double workHours = calculateWorkHours();
        if (workHours > 40.0) {
            double overtimeHours = workHours - 40.0;
            return overtimeHours * OVERTIME_RATE * hourlyWage;
        } else {
            return 0.0;
        }
    }
}

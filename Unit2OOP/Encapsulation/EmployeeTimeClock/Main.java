public class Main {
    public static void main(String[] args) {
        EmployeeTimeClock timeClock = new EmployeeTimeClock(15.0); // Hourly wage of $15.0

        // Clock in and out multiple times for demonstration
        timeClock.clockIn(2023, 9, 1, 8, 0);
        timeClock.clockOut(2023, 9, 1, 12, 0);
        timeClock.clockIn(2023, 9, 1, 13, 0);
        timeClock.clockOut(2023, 9, 1, 17, 0);
        timeClock.clockIn(2023, 9, 2, 8, 0);
        timeClock.clockOut(2023, 9, 2, 17, 30);

        double workHours = timeClock.calculateWorkHours();
        double overtimePay = timeClock.calculateOvertimePay();

        System.out.println("Total Work Hours: " + workHours + " hours");
        System.out.println("Overtime Pay: $" + overtimePay);
    }
}
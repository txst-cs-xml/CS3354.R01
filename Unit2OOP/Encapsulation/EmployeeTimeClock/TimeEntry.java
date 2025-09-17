class TimeEntry {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private boolean isClockIn;

    public TimeEntry(int year, int month, int day, int hour, int minute, boolean isClockIn) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.isClockIn = isClockIn;
    }

    public boolean isBefore(TimeEntry other) {
        return this.year < other.year ||
               (this.year == other.year && this.month < other.month) ||
               (this.year == other.year && this.month == other.month && this.day < other.day) ||
               (this.year == other.year && this.month == other.month && this.day == other.day &&
                this.hour < other.hour) ||
               (this.year == other.year && this.month == other.month && this.day == other.day &&
                this.hour == other.hour && this.minute < other.minute);
    }

    public double calculateHoursWorked(TimeEntry clockOut) {
        int minutesWorked = (clockOut.year - this.year) * 365 * 24 * 60 +
                            (clockOut.month - this.month) * 30 * 24 * 60 +
                            (clockOut.day - this.day) * 24 * 60 +
                            (clockOut.hour - this.hour) * 60 +
                            (clockOut.minute - this.minute);
        return minutesWorked / 60.0;
    }
}
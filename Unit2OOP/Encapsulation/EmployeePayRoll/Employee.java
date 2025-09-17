class Employee {
    private String employeeID;
    private String firstName;
    private String lastName;
    private double hourlyRate;
    private int hoursWorked;

    public Employee(String employeeID, String firstName, String lastName, double hourlyRate, int hoursWorked) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeID + ", Name: " + firstName + " " + lastName;
    }
}
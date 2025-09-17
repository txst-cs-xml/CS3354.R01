class PayrollSystem {
    private double taxRate;

    public PayrollSystem(double taxRate) {
        this.taxRate = taxRate;
    }

    public double deductTaxes(double salary) {
        return salary * (taxRate / 100.0);
    }

    public void generatePayStub(Employee employee) {
        double salary = employee.calculateSalary();
        double taxes = deductTaxes(salary);
        double netSalary = salary - taxes;

        System.out.println("Pay Stub for " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("Employee ID: " + employee.getEmployeeID());
        System.out.println("Hourly Rate: $" + employee.getHourlyRate());
        System.out.println("Hours Worked: " + employee.getHoursWorked());
        System.out.println("Gross Salary: $" + salary);
        System.out.println("Taxes Deducted: $" + taxes);
        System.out.println("Net Salary: $" + netSalary);
        System.out.println();
    }
}
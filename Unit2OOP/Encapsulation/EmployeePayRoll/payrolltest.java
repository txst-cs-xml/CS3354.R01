public class payrolltest {
    public static void main(String[] args) {
        Employee employee1 = new Employee("E1001", "John", "Doe", 15.0, 40);
        Employee employee2 = new Employee("E1002", "Jane", "Smith", 20.0, 35);

        PayrollSystem payrollSystem = new PayrollSystem(15.0); // 15% tax rate

        payrollSystem.generatePayStub(employee1);
        payrollSystem.generatePayStub(employee2);
    }
}

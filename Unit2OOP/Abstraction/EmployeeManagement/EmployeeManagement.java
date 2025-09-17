// Base Class: Employee
abstract class Employee {
    protected String name;
    protected int ID;
    protected double salary;

    // Final attributes to ensure they remain unchanged in subclasses.
    final protected String companyName = "XYZ Corp.";
    final protected String baseOfficeLocation = "New York";

    public Employee(String name, int ID, double salary) {
        this.name = name;
        this.ID = ID;
        this.salary = salary;
    }

    public abstract void jobDescription();

    public abstract double bonus();
}

// Subclass: Manager
class Manager extends Employee {
    private double performanceRating; // Assume this is a value between 1 to 5.

    public Manager(String name, int ID, double salary, double performanceRating) {
        super(name, ID, salary);
        this.performanceRating = performanceRating;
    }

    @Override
    public void jobDescription() {
        System.out.println(name + " manages teams and oversees projects.");
    }

    @Override
    public double bonus() {
        return salary * (performanceRating / 10);
    }
}

// Subclass: Technician
class Technician extends Employee {
    public Technician(String name, int ID, double salary) {
        super(name, ID, salary);
    }

    @Override
    public void jobDescription() {
        System.out.println(name + " repairs and maintains equipment.");
    }

    @Override
    public double bonus() {
        return salary * 0.05; // flat 5% bonus
    }
}

// Subclass: Salesperson
class Salesperson extends Employee {
    private int numberOfProductsSold;

    public Salesperson(String name, int ID, double salary, int numberOfProductsSold) {
        super(name, ID, salary);
        this.numberOfProductsSold = numberOfProductsSold;
    }

    @Override
    public void jobDescription() {
        System.out.println(name + " sells products to customers.");
    }

    @Override
    public double bonus() {
        return numberOfProductsSold * 10; // $10 bonus per product sold
    }
}

// Test class
public class EmployeeManagement {
    public static void main(String[] args) {
        Manager mike = new Manager("Mike", 101, 90000, 4.5);
        mike.jobDescription();
        System.out.println("Bonus: $" + mike.bonus());

        Technician lisa = new Technician("Lisa", 102, 60000);
        lisa.jobDescription();
        System.out.println("Bonus: $" + lisa.bonus());

        Salesperson john = new Salesperson("John", 103, 50000, 100);
        john.jobDescription();
        System.out.println("Bonus: $" + john.bonus());
    }
}

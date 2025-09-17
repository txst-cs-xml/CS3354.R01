// Superclass
class Vehicle {
    private String brand;
    private int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void start() {
        System.out.println("Starting the vehicle");
    }

    public void stop() {
        System.out.println("Stopping the vehicle");
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }
}

// Subclass
class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, int year, int numberOfDoors) {
        super(brand, year); // Call the constructor of the superclass
        // this.brand = brand;
        // this.year = year;
        this.numberOfDoors = numberOfDoors;
    }

    // Override the start method from the superclass
    @Override
    public void start() {
        System.out.println("Starting the car");
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }
}

class Truck extends Vehicle {
    private int numberOfWheels;

    public Truck(String brand, int year, int numberOfWheels) {
        super(brand, year);
        this.numberOfWheels = numberOfWheels;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void start() {
        System.out.println("Starting the truck");
    }

    public void stop() {
        System.out.println("Stopping the truck");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an instance of the subclass Car
        // Car myCar = new Car("Toyota", 2022, 4);

        // Access methods and fields from the superclass
        // System.out.println("Brand: " + myCar.getBrand());
        // System.out.println("Year: " + myCar.getYear());

        // // Access methods and fields from the subclass
        // System.out.println("Number of Doors: " + myCar.getNumberOfDoors());

        // // Call the overridden start method
        // myCar.start();

        // // Call the stop method inherited from the superclass
        // myCar.stop();


        // Truck myTruck = new Truck("Ford", 2021, 6);
        // System.out.println("Brand: " + myTruck.getBrand());
        // System.out.println("Year: " + myTruck.getYear());
        // System.out.println("Number of Wheels: " + myTruck.getNumberOfWheels());
        // myTruck.start();
        // myTruck.stop();

        // Vehicle myVehicle = new Vehicle("Honda", 2020);
        // System.out.println("Brand: " + myVehicle.getBrand());   
        // System.out.println("Year: " + myVehicle.getYear());
        // myVehicle.start();
        // myVehicle.stop();

        // Car myCar = new Car("Toyota", 2022, 4);
        // myCar.start();
        // myCar.stop();
        // System.out.println(myCar.getBrand());

        Car car1 = new Car("Toyota", 2022, 4);
        System.out.println(car1.toString());
        Car car2 = new Car("Toyota", 2022, 4);
        System.out.println(car2.toString());
        Truck truck = new Truck("Toyota", 2020, 8);
        System.out.println(truck.toString());

    }
}

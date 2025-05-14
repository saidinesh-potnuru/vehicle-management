import java.util.*;

abstract class Vehicle {
    protected String vehicleNumber;
    protected String brand;
    protected int year;

    public Vehicle(String vehicleNumber, String brand, int year) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.year = year;
    }

    public abstract double calculateMaintenanceCost();

    public void displayInfo() {
        System.out.println("Vehicle No: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }
}

class Car extends Vehicle {
    private int numDoors;

    public Car(String vehicleNumber, String brand, int year, int numDoors) {
        super(vehicleNumber, brand, year);
        this.numDoors = numDoors;
    }

    @Override
    public double calculateMaintenanceCost() {
        return 2000 + (2025 - year) * 150;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Car");
        System.out.println("Doors: " + numDoors);
        System.out.println("Maintenance Cost: ₹" + calculateMaintenanceCost());
    }
}

class Bike extends Vehicle {
    private boolean hasGear;

    public Bike(String vehicleNumber, String brand, int year, boolean hasGear) {
        super(vehicleNumber, brand, year);
        this.hasGear = hasGear;
    }

    @Override
    public double calculateMaintenanceCost() {
        return 1000 + (2025 - year) * 100;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Bike");
        System.out.println("Has Gear: " + hasGear);
        System.out.println("Maintenance Cost: ₹" + calculateMaintenanceCost());
    }
}

class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String vehicleNumber, String brand, int year, double loadCapacity) {
        super(vehicleNumber, brand, year);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateMaintenanceCost() {
        return 3000 + (2025 - year) * 200;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Truck");
        System.out.println("Load Capacity: " + loadCapacity + " tons");
        System.out.println("Maintenance Cost: ₹" + calculateMaintenanceCost());
    }
}

class VehicleManager {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Car car) {
        vehicles.add(car);
    }

    public void addVehicle(Bike bike) {
        vehicles.add(bike);
    }

    public void addVehicle(Truck truck) {
        vehicles.add(truck);
    }

    public void displayAllVehicles() {
        for (Vehicle v : vehicles) {
            System.out.println("----------------------------");
            v.displayInfo();
        }
    }
}

public class VehicleManagement {
    public static void main(String[] args) {
        VehicleManager manager = new VehicleManager();

        manager.addVehicle(new Car("MH12AB1234", "Toyota", 2020, 4));
        manager.addVehicle(new Bike("MH14XY4567", "Honda", 2021, true));
        manager.addVehicle(new Truck("MH01CD7890", "Tata", 2018, 15.5));

        System.out.println("=== Vehicle Records ===");
        manager.displayAllVehicles();
    }
}

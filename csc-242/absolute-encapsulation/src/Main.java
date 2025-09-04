







public final class ImmutableCar {
/*
 * TODO 4: Implement immutability.
 * Create a new class ImmutableCar with:
 * - Private final fields for brand, model, and year
 * - A constructor to initialize these fields
 * - No setter methods, only getters
 */
    private final String brand;
    // TODO do the others

    public ImmutableCar(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    // TODO: try to create a constructor without initializing all the final fields.

    public String getBrand() {
        return brand;
    }

   // TODO try to implement a setBrand method

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

public class Main {
    public static void main(String[] args) {
        // Test Car and Dealership
        Car car = new Car("Toyota", "Camry", 2021);
        Dealership dealership = new Dealership();
        dealership.displayCarBrand(car);

        // Test CompanyCar and Employee
        CompanyCar companyCar = new CompanyCar("Tesla", "Model S", 2022);
        Employee employee = new Employee(companyCar);
        System.out.println("\nTesting CompanyCar with Employee:");
        employee.operateVehicle();  // Test various speed settings

        // Test ImmutableCar
        ImmutableCar immutableCar = new ImmutableCar("Honda", "Civic", 2020);
        System.out.println("\nImmutable Car Details:");
        System.out.println("Brand: " + immutableCar.getBrand());
        System.out.println("Model: " + immutableCar.getModel());
        System.out.println("Year: " + immutableCar.getYear());

        // Demonstrate thread-safe access with location field in Car
        Car carWithLocation = new Car("Nissan", "Altima", 2019);
        carWithLocation.setLocation("New York City");
        System.out.println("\nCar Location: " + carWithLocation.getLocation());
    }
}


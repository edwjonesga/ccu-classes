import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private Car car;
    private CompanyCar companyCar;
    private ImmutableCar immutableCar;
    private Employee employee;

    @BeforeEach
    public void setup() {
        car = new Car("Toyota", "Camry", 2021);
        companyCar = new CompanyCar("Tesla", "Model S", 2022);
        immutableCar = new ImmutableCar("Honda", "Civic", 2020);
        employee = new Employee(companyCar);
    }

    @Test
    public void testCarEncapsulation() {
        assertEquals("Toyota", car.getBrand());
        assertEquals("Camry", car.getModel());
        assertEquals(2021, car.getYear());
    }

    @Test
    public void testCompanyCarSpeedLimit() {
        companyCar.setSpeed(100);
        assertEquals(100, companyCar.getSpeed(), "Speed should be set to 100 mph.");

        companyCar.setSpeed(200);
        assertEquals(200, companyCar.getSpeed(), "Speed should be set to 200 mph.");

        companyCar.setSpeed(250);  // Exceeds limit
        assertEquals(200, companyCar.getSpeed(), "Speed should not exceed 200 mph.");
    }

    @Test
    public void testEmployeeVehicleOperation() {
        employee.operateVehicle();
        assertEquals(200, companyCar.getSpeed(), "Speed should be capped at 200 mph.");
    }

    @Test
    public void testImmutableCar() {
        assertEquals("Honda", immutableCar.getBrand());
        assertEquals("Civic", immutableCar.getModel());
        assertEquals(2020, immutableCar.getYear());

        // No setters available, verify immutability by lack of state-changing methods.
    }

    @Test
    public void testDealershipDisplayCarBrand() {
        Dealership dealership = new Dealership();
        dealership.displayCarBrand(car);
        // Output test could be verified by capturing system output using System.setOut, if needed.
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MainTest {

    @Test
    void testEveryThingReallyIsAnObjectReturnsCarInstance() {
        Main main = new Main();
        Object obj = main.everyThingReallyIsAnObject();
        assertNotNull(obj, "The returned object should not be null.");
        assertTrue(obj instanceof Main.Car, "The returned object should be an instance of the Car class.");
    }

    @Test
    void testAddColorToCarSetsColorCorrectly() {
        Main main = new Main();
        Main.Car car = main.addColorToCar("Red");
        assertNotNull(car, "The returned car should not be null.");
        assertEquals("Red", car.getColor(), "The car's color should be 'Red'.");
    }

    @Test
    void testCarHasEngineInstanceVariable() throws NoSuchFieldException {
        Field engineField = Main.Car.class.getDeclaredField("engine");
        assertNotNull(engineField, "Car class should have an instance variable of type Engine.");
        assertTrue(engineField.getType().equals(Main.Engine.class), "The engine field should be of type Engine.");
        assertTrue(Modifier.isPrivate(engineField.getModifiers()), "The engine field should be private.");
    }

    @Test
    void testCarConstructorHasEngineParameter() {
        Constructor<?>[] constructors = Main.Car.class.getDeclaredConstructors();
        boolean hasEngineParam = false;

        for (Constructor<?> constructor : constructors) {
            for (var parameter : constructor.getParameters()) {
                if (parameter.getType().equals(Main.Engine.class)) {
                    hasEngineParam = true;
                    break;
                }
            }
        }

        assertTrue(hasEngineParam, "Car constructor should have a parameter of type Engine.");
    }

    @Test
    void testCarHasEngineGetter() {
        Main main = new Main();
        Main.Engine engine = new Main.Engine();
        Main.Car car = main.carHasAEngine(engine);

        // Ensure the Car object is not null and has the correct Engine
        assertNotNull(car, "The returned Car object should not be null.");
        assertNotNull(car.getEngine(), "The Car should have an Engine instance.");
        assertEquals(engine, car.getEngine(), "The Car's Engine should match the one passed to the constructor.");
    }

    @Test
    void testStartCarStartsEngine() {
        Main main = new Main();
        Main.Engine engine = new Main.Engine();
        Main.Car car = main.carHasAEngine(engine);
        car = main.startCar(car);

        assertTrue(car.isStarted(), "The car should be started.");
    }

    @Test
    void testCreateYourselfWithThisReturnsAllConstructors() throws NoSuchFieldException {
        Main main = new Main();
        Main.Car[] cars = main.createYourselfWithThis();

        assertNotNull(cars, "The returned array of cars should not be null.");

        // Verify the number of constructors matches the number of Car instances
        Constructor<?>[] constructors = Main.Car.class.getDeclaredConstructors();
        assertEquals(constructors.length, cars.length, "The number of cars should match the number of constructors.");

        // Verify each Car instance has valid parameters
        for (Main.Car car : cars) {
            assertNotNull(car.getColor(), "The car's color should not be null.");
            assertNotNull(car.getEngine(), "The car's engine should not be null.");
        }

        // Verify there is a protected field named 'brand'
        Field brandField = Main.Car.class.getDeclaredField("brand");
        assertNotNull(brandField, "The Car class should have a protected field named 'brand'.");
        assertTrue(Modifier.isProtected(brandField.getModifiers()), "The 'brand' field should be protected.");
    }

    @Test
    void testAnSUVIsACar() throws NoSuchFieldException, IllegalAccessException {
        Main main = new Main();
        Main.Car suv = main.anSUVIsACar();

        // Ensure the SUV object is not null
        assertNotNull(suv, "The returned SUV object should not be null.");

        // Verify the SUV is an instance of Car
        assertTrue(suv instanceof Main.Car, "The SUV should be an instance of the Car class.");

        // Cast the object to SUV to call its specific method
        Main.SUV castedSUV = (Main.SUV) suv;
        castedSUV.updateBrand("UpdatedBrand");

        // Check the protected field 'brand' in the Car class
        Field brandField = Main.Car.class.getDeclaredField("brand");
        assertNotNull(brandField, "The Car class should have a protected field named 'brand'.");
        assertTrue(Modifier.isProtected(brandField.getModifiers()), "The 'brand' field should be protected.");

        // Access the brand field using reflection to ensure it's updated correctly in the SUV
        brandField.setAccessible(true);
        String brandValue = (String) brandField.get(suv);
        assertNotNull(brandValue, "The brand field in SUV should not be null.");
        assertEquals("UpdatedBrand", brandValue, "The brand field in SUV should be 'UpdatedBrand'.");
    }
}

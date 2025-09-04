public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        // Example calls
        Object obj = main.everyThingReallyIsAnObject();
        System.out.println(obj);

        // TODO: Uncomment after implementing carHasAEngine and igniteCar
        // Engine engine = new Engine();
        // Car carWithEngine = main.carHasAEngine(engine);
        // System.out.println(main.igniteCar(carWithEngine));
    }

    /**
     * Method to return an object. Students should modify this method
     * to create and return an instance of the Car class.
     */
    public Object everyThingReallyIsAnObject() {
        // TODO: Replace this null with an instance of Car
        return null;
    }

    /**
     * Method to create a Car and set its color.
     * This method is intentionally left unimplemented for students to complete.
     *
     * @param color The color to assign to the car.
     * @return A Car object with the specified color.
     */
    public Car addColorToCar(String color) {
        // TODO: Implement this method to create a new Car instance with the given color
        return null;
    }

    /**
     * Method to demonstrate a Car HAS-A relationship with an Engine.
     * @param e An Engine object to associate with the Car.
     * @return A Car object with the specified Engine.
     */
    public Car carHasAEngine(Engine e) {
        // TODO: Update the Car class to include an Engine instance variable
        // TODO: Ensure that Car's constructor accepts an Engine as a parameter
        // TODO: Make the Engine instance variable private
        // TODO: Add a getter method in the Car class for the Engine
        return null;
    }

    /**
     * Method to "start" a Car.
     * This implements starting a car
     *
     * @return Car that is started and running
     */
    public Car startCar(Car car) {
        // TODO: implement a function to start the car that 
        // TODO: calls a function on the engine to start the car
        // TODO: implement a function on car called isStarted
        // TODO: That checks the engine to see if the engine is running and returns that value
        // NOTE: The code should return a car that has isStarted returning true
        return car;
    }
   /**
     * Method to demonstrate inheritance by creating an SUV that extends Car.
     *
     * @return A Car object created from an SUV.
     */
    public Car anSUVIsACar() {
        // TODO: Create an SUV class that extends Car
        // TODO: Add a protected field named "brand" in the Car class
        // TODO: In the SUV class, add a function called updateBrand(String newBrand) that changes the brand of the SUV
        // TODO: Create an SUV instance, set its brand, and return it as a Car object
        return null;
    }

    // Stub Engine class
    class Engine {
        // leave this constucgtor so that the tests dont fail
        public Engine() {
          // Feel free to add code here if necessary
        }

        // Implement methods here
    }

    // Skeleton Car class
    class Car {
        public Car() {
        }

    }
}

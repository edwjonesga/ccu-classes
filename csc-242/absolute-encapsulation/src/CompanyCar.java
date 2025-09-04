public class CompanyCar extends Car {
   /*
 * TODO 3: Create an example for controlled access through methods.
 * Add a private speed field and provide a setSpeed() method that validates speed (e.g., not exceeding 200 mph).
 */
    private int speed;

    public CompanyCar(String brand, String model, int year) {
      // call super constructor
    }

    public void setSpeed(int speed) {
        // TODO: Ensure that speed is never greater than 200 mph
        
    }

    public int getSpeed() {
        return speed;
    }
}

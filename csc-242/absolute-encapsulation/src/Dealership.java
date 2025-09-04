public class Dealership {
/*
 * TODO 2: Implement access control.
 * Modify the Car class to use appropriate access modifiers (public, private, protected) and discuss their impact.
 * Hint: Try changing access levels and observe how it affects access in another class.
 */

/*
 * Dealership class attempts to access Car's private brand field.
 * TODO: Modify the Car class to allow uncontrolled access to brand in Dealership 
 */
    public void displayCarBrand(Car car) {
        // TODO: Access the car's brand field and display it (I know... its bad.)
        System.out.println("Car brand: " + car.brand); 
    }
   // TODO: implement a change brand method to change the brand of the car.
   // How wrong does writing this code feel... ugh!
   
}

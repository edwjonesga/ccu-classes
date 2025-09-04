public class Employee {
    private CompanyCar companyCar;

    public Employee(CompanyCar companyCar) {
        this.companyCar = companyCar;
    }

    public void operateVehicle() {
        companyCar.setSpeed(100);
        System.out.println("Current speed: " + companyCar.getSpeed());

        companyCar.setSpeed(200);
        System.out.println("Current speed: " + companyCar.getSpeed());

        companyCar.setSpeed(250);  // Exceeds initial limit of 200 mph

       // TODO: Modify Company car to reduce speed to 150 Notice how we don't have to change Employee class... it just takes on the new behaviour
    }
}

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SmartHomeRepository repository = new SmartHomeRepository();
        HomeController homeController = new HomeController(repository);

        SmartLight livingRoomLight = new SmartLight("Living Room Light");
        SecurityCamera frontDoorCamera = new SecurityCamera();
        SmartThermostat homeThermostat = new SmartThermostat();

        homeController.addDevice(livingRoomLight);
        homeController.addDevice(frontDoorCamera);
        homeController.addDevice(homeThermostat);

        // Retrieve devices by capability
        System.out.println("Dimmable Devices: " + homeController.getAllDimmableDevices().size());
        System.out.println("Motion Sensing Devices: " + homeController.getAllMotionSensingDevices().size());
        System.out.println("Temperature Controllable Devices: " + homeController.getAllTemperatureControllableDevices().size());
    }
}


public class HomeController {
// HomeController class
// TODO: This class should go in: edu.ccu.students.<username>.smarthome.controller
    private static HomeController instance;
    private SmartHomeRepository repository;

    private HomeController(SmartHomeRepository repository) {
        // TODO: constructor logic for singleton HomeController
    }

    public static HomeController getInstance(SmartHomeRepository repository) {
        // TODO: implement singleton logic
        return null;
    }

    public void addDevice(SmartDevice device) {
        // TODO: add the smart device to the repository
    }
}

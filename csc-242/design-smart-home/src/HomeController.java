public class HomeController {
    private static HomeController instance;
    private SmartHomeRepository repository;

    private HomeController(SmartHomeRepository repository) {
        // TODO: Implement constructor logic
    }

    public static HomeController getInstance(SmartHomeRepository repository) {
        // TODO: Implement Singleton logic
        return null;
    }

    public void addDevice(SmartDevice device) {
        // TODO: Implement method
    }
}

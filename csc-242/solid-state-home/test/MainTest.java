import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class MainTest {
    @Test
    public void testDeviceRegistration() {
        SmartHomeRepository repository = new SmartHomeRepository();
        HomeController homeController = new HomeController(repository);

        SmartLight light = new SmartLight("Test Light");
        homeController.addDevice(light);

        List<SmartDevice> devices = homeController.getAllDevices();
        assertEquals(1, devices.size());
        assertEquals("Test Light", devices.get(0).getName());
    }

    @Test
    public void testDimmableDevices() {
        SmartHomeRepository repository = new SmartHomeRepository();
        HomeController homeController = new HomeController(repository);

        SmartLight light = new SmartLight("Dimmable Light");
        homeController.addDevice(light);

        List<Dimmable> dimmables = homeController.getAllDimmableDevices();
        assertEquals(1, dimmables.size());
    }

    @Test
    public void testMotionSensingDevices() {
        SmartHomeRepository repository = new SmartHomeRepository();
        HomeController homeController = new HomeController(repository);

        SecurityCamera camera = new SecurityCamera();
        homeController.addDevice(camera);

        List<MotionSensing> motionDevices = homeController.getAllMotionSensingDevices();
        assertEquals(1, motionDevices.size());
    }
}

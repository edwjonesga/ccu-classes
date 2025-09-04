import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class MainTest {
    
    private boolean eventReceived = false;
    @Test
    public void testSingletonHomeController() {
        SmartHomeRepository repo1 = new SmartHomeRepository();
        SmartHomeRepository repo2 = new SmartHomeRepository();
        
        HomeController controller1 = HomeController.getInstance(repo1);
        HomeController controller2 = HomeController.getInstance(repo2);
        
        assertSame(controller1, controller2, "HomeController should be a singleton instance");
    }
    
    @Test
    public void testFactoryCreatesDevices() {
        SmartDevice light = SmartDeviceFactory.createDevice("light", "Living Room Light");
        SmartDevice lock = SmartDeviceFactory.createDevice("lock", "Front Door Lock");
        
        assertNotNull(light, "Factory should create a SmartLight");
        assertNotNull(lock, "Factory should create a SmartLock");
    }
    
    @Test
    public void testSmartHomeObserverPattern() {
        SmartHomeEventManager eventManager = new SmartHomeEventManager();
        
        SmartHomeObserver testObserver = new SmartHomeObserver() {
            
            @Override
            public void onEvent(HomeEvent event) {
                eventReceived = true;
            }
            
        };
        eventReceived = false;
        eventManager.addObserver(testObserver);
        eventManager.notifyObservers(HomeEvent.MOTION_DETECTED);
        
        // TODO: Verify expected behavior after event notification
        assertTrue(eventReceived, "Observer should have received an event");
    }
    
    @Test
    public void testSmartHomeRepositoryBuilder() {
        SmartHomeRepository repository = new SmartHomeRepositoryBuilder()
            .addSmartLight("Kitchen Light")
            .addSmartLock("Front Door")
            .addSmartThermostat("Living Room Thermostat")
            .build();
        
        assertNotNull(repository, "Repository should be built successfully");
        assertEquals(3, repository.getAllDevices().size(), "Repository should contain 3 devices");
    }
    
    @Test
    public void testUsageTrackerPowerableDevice() {
        SmartLight light = new SmartLight("Test Light");
        SmartLightUsageTracker trackedLight = new SmartLightUsageTracker(light);
        
        trackedLight.turnOn();
        // Simulate time passing
        trackedLight.turnOff();
        
        assertTrue(trackedLight.getTotalUsageTime() > 0, "Usage time should be greater than zero");
    }
}

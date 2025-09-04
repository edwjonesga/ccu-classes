import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Assignment: "Home Event Advantage" 🏠⚡
 * 
 * This test class checks that:
 * 1. All SmartDevices fire HomeEvents.
 * 2. SmartHomeObserver interface accepts HomeEvent.
 * 3. HomeController implements SmartHomeObserver and logs telemetry.
 * 4. Devices and observers live in proper edu.ccu.students.*.smartHome.* packages.
 * 5. Main.java returns all required objects via factory methods.
 */

public class MainTest {

    private TestObserver observer;
    private List<HomeEvent> receivedEvents;

    @BeforeEach
    public void setup() {
        receivedEvents = new ArrayList<>();
        observer = new TestObserver(receivedEvents);
    }

    @Test
    public void testSmartLightFiresHomeEvent() {
        SmartLight light = Main.getNewSmartLight("Kitchen Light");
        assertPackageName(light);

        light.addSmartHomeEventListener(observer);
        light.turnOn();

        assertEquals(1, receivedEvents.size());
        HomeEvent event = receivedEvents.get(0);
        assertEquals(HomeEventType.LIGHT_ON, event.type());
        assertEquals("Kitchen Light", event.sourceDevice().getName());
    }

    @Test
    public void testSmartLockFiresHomeEvent() {
        SmartLock lock = Main.getNewSmartLock("Front Door");
        assertPackageName(lock);

        lock.addSmartHomeEventListener(observer);
        lock.operate();

        assertEquals(1, receivedEvents.size());
        HomeEvent event = receivedEvents.get(0);
        assertEquals(HomeEventType.LOCK_OPENED, event.type());
        assertEquals("Front Door", event.sourceDevice().getName());
    }

    @Test
    public void testHomeControllerTelemetryReceivesAllEvents() {
        HomeController controller = Main.getHomeController();
        assertPackageName(controller);

        SmartLight light = Main.getNewSmartLight("Living Room Light");
        SmartLock lock = Main.getNewSmartLock("Back Door");

        // Add devices to controller, which should internally register them as observers
        controller.addDevice(light);
        controller.addDevice(lock);

        light.turnOn();
        lock.operate();

        List<HomeEvent> telemetry = controller.getTelemetry();
        assertEquals(2, telemetry.size());
        assertTrue(telemetry.stream().anyMatch(e -> e.sourceDevice().equals(light)));
        assertTrue(telemetry.stream().anyMatch(e -> e.sourceDevice().equals(lock)));
    }

    private void assertPackageName(Object obj) {
        String pkg = obj.getClass().getPackageName();
        assertTrue(pkg.startsWith("edu.ccu.students.") && pkg.contains(".smartHome"),
            "Class should be in a package starting with edu.ccu.students.<username>.smartHome");
    }

    static class TestObserver implements SmartHomeObserver {
        private final List<HomeEvent> eventLog;

        TestObserver(List<HomeEvent> eventLog) {
            this.eventLog = eventLog;
        }

        @Override
        public void onSmartHomeEvent(HomeEvent event) {
            eventLog.add(event);
        }
    }
}

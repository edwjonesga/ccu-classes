public class MainTest {

    // Inner test device with flags
    public static class TestSmartDevice {
        public boolean turnedOn = false;
        public boolean turnedOff = false;
        public boolean operated = false;
        public boolean checkedIsOn = false;
        public boolean nameWasSet = false;

        private String name;

        public void turnOn() {
            turnedOn = true;
        }

        public void turnOff() {
            turnedOff = true;
        }

        public boolean isOn() {
            checkedIsOn = true;
            return true;
        }

        public void operate() {
            operated = true;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            nameWasSet = true;
            this.name = name;
        }
    }

    private final String className = "MainTest$TestSmartDevice";

    @Test
    public void testSmartDeviceAdapter() {
        SmartDeviceAdapter adapter = new SmartDeviceAdapter(className);
        adapter.setName("Thermostat");
        assertEquals("Thermostat", adapter.getName());

        TestSmartDevice instance = (TestSmartDevice) adapter.getDeviceInstance();
        assertTrue(instance.nameWasSet);
    }

    @Test
    public void testPowerableAdapter() {
        PowerableAdapter adapter = new PowerableAdapter(className);
        adapter.turnOn();
        adapter.turnOff();
        assertTrue(adapter.isOn());

        TestSmartDevice instance = (TestSmartDevice) adapter.getDeviceInstance();
        assertTrue(instance.turnedOn);
        assertTrue(instance.turnedOff);
        assertTrue(instance.checkedIsOn);
    }

    @Test
    public void testSecureDeviceAdapter() {
        SecureDeviceAdapter adapter = new SecureDeviceAdapter(className);
        adapter.operate();

        TestSmartDevice instance = (TestSmartDevice) adapter.getDeviceInstance();
        assertTrue(instance.operated);
    }
}

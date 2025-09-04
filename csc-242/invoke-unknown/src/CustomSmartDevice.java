public class CustomSmartDevice {
    private String deviceName;

    public String getName() {
        return deviceName;
    }

    public void setName(String name) {
        this.deviceName = name;
        System.out.println("[CustomSmartDevice] Name set to: " + name);
    }

    public void turnOn() {
        System.out.println("[CustomSmartDevice] Device is now ON");
    }

    public void turnOffDevice() {
        System.out.println("[CustomSmartDevice] Device has been turned OFF");
    }

    public boolean isOnDevice() {
        System.out.println("[CustomSmartDevice] Checking if device is on...");
        return true;
    }

    public void engageSecurity() {
        System.out.println("[CustomSmartDevice] Security system engaged");
    }
}

public class UsageTrackerPowerableDevice implements Powerable {
    private long startTime;
    private long totalUsageTime;

    public UsageTrackerPowerableDevice(Powerable device) {
        super(device);
        // TODO: Implement constructor logic
    }

    public void turnOn() {
        // TODO: Record start time
        super.turnOn();
    }

    public void turnOff() {
        // TODO: Calculate and store usage time
        super.turnOff();
    }

    public long getTotalUsageTime() {
        // TODO: Implement method
        return 0;
    }
}

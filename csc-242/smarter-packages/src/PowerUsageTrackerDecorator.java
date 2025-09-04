public abstract class PowerUsageTrackerDecorator implements Powerable {
// PowerUsageTrackerDecorator abstract class
// TODO: This class should go in: edu.ccu.students.<username>.smarthome.decorator
    protected Powerable device;

    public PowerUsageTrackerDecorator(Powerable device) {
        // TODO: initialize with a device
    }

    public void turnOn() {
        // TODO: start tracking and delegate
    }

    public void turnOff() {
        // TODO: stop tracking and delegate
    }

    public boolean isOn() {
        // TODO: return power state
        return false;
    }
}

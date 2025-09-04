public class PowerableAdapter implements Powerable {

    public PowerableAdapter(String className) {
        // create an instance of the specified class and assign it to instance
    }

    public void setTurnOnMethodName(String methodName) {
    }

    public void setTurnOffMethodName(String methodName) {
    }

    public void setIsOnMethodName(String methodName) {
    }

    @Override
    public void turnOn() {
        // TODO: use reflection to invoke the method stored in turnOnMethod
        // Hint: instance.getClass().getMethod(...).invoke(instance);
    }

    @Override
    public void turnOff() {
        // TODO: same as turnOn but with turnOffMethod
    }

    @Override
    public boolean isOn() {
        // TODO: invoke isOnMethod and return the boolean result
        return false; // placeholder
    }
    public Object getDeviceInstance(){}
}

public class SmartDeviceAdapter implements SmartDevice {
    private final Object instance;
    private String getNameMethod = "getName";
    private String setNameMethod = "setName";

    public SmartDeviceAdapter(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            this.instance = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Could not instantiate: " + className, e);
        }
    }

    // Example: adapter.setGetNameMethodName("fetchDeviceName");
    public void setGetNameMethodName(String methodName) {
        this.getNameMethod = methodName;
    }

    public void setSetNameMethodName(String methodName) {
        this.setNameMethod = methodName;
    }

    @Override
    public String getName() {
        // TODO: use reflection to invoke the method named by getNameMethod
        return null; // replace with actual result
    }

    @Override
    public void setName(String name) {
        // TODO: use reflection to invoke the method named by setNameMethod with the given name
        // Hint: getMethod(..., String.class)
    }
    public Object getDeviceInstance(){ return instance;}
}

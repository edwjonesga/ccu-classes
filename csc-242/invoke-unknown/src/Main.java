// SmartDeviceAdapter

// PowerableAdapter

// SecureDeviceAdapter

// This class has some methods that match the interface names and some that don't.

public class Main {
    public static void main(String[] args) {
        try {
            String className = "CustomSmartDevice";

            SmartDeviceAdapter smartAdapter = new SmartDeviceAdapter(className);
            smartAdapter.setName("Microwave");
            System.out.println("Name: " + smartAdapter.getName());

            PowerableAdapter powerAdapter = new PowerableAdapter(className);
            powerAdapter.setTurnOffMethodName("turnOffDevice");
            powerAdapter.setIsOnMethodName("isOnDevice");
            powerAdapter.turnOn();
            System.out.println("Power status: " + powerAdapter.isOn());
            powerAdapter.turnOff();

            SecureDeviceAdapter secureAdapter = new SecureDeviceAdapter(className);
            secureAdapter.setOperateMethodName("engageSecurity");
            secureAdapter.operate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



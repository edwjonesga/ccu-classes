
import java.util.ArrayList;
import java.util.List;

public class AuroraSmartLight {
    private final String name;
    public AuroraSmartLight(String name){
        this.name = name;
    }
    // TODO: This class should wrap a regular SmartLight

    // TODO: Add a LightBulbFrame to visually represent the light

    // TODO: Maintain a list of SmartSwitchFrame instances
    private final List<SmartSwitchFrame> switches = new ArrayList<>();

    // TODO: Allow adding any number of switches
    public void addSwitch(SmartSwitchFrame switchFrame) {
        switches.add(switchFrame);
        // TODO: Wire up the switch to control the wrapped SmartLight
    }

    // TODO: Use the LightBulbFrame constructor reference (LightBulbFrame::new)
    //       to launch the bulb view when the SmartLight turns on

    // ❓ Reflection Prompt for Students:
    // Think carefully—what is this class?
    // Is it a controller for SmartLight?
    // Is it a new kind of SmartDevice?
    // Is it a decorator that adds behavior to something powerable?
    // Should it implement SmartDevice, or wrap one?

    // TODO: Implement setup logic and connection with SmartHomeObserver
}


import java.awt.FlowLayout;
import javax.swing.JFrame;
 
import javax.swing.JLabel;
import javax.swing.JToggleButton;

public class SmartSwitchFrame extends JFrame {
    private final SmartLight light;
    private final JToggleButton toggleButton;

    public SmartSwitchFrame(SmartLight light) {
        this.light = light;
        this.toggleButton = new JToggleButton("Toggle");

        setLayout(new FlowLayout());
        add(new JLabel(light.getName()));
        add(toggleButton);

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // TODO: Add a home event listener to the smart light using a method reference

        // TODO: Add an action listener to the toggle button using a lambda expression
        // toggleButton.addActionListener(...);
    }

    // TODO: Create a method that sets the toggle based on a HomeEvent
    private void updateFromEvent(HomeEvent event) {
        // TODO: Check the event type
        // If LIGHT_ON → toggleButton.setSelected(true), set background to yellow
        // If LIGHT_OFF → toggleButton.setSelected(false), reset background color
    }
}

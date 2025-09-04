
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LightBulbFrame extends JFrame {
    private final SmartDevice device;
    private final JPanel bulbPanel;

    public LightBulbFrame(HomeEvent event) {
        this.device = event.sourceDevice();
        this.bulbPanel = new JPanel();

        setUndecorated(true);
        setSize(100, 100);
        setLocationRelativeTo(null); // Center on screen

        bulbPanel.setBackground(Color.WHITE);
        add(bulbPanel);

        setVisible(true);

        // TODO: Add a SmartHomeObserver to the smart device using an anonymous class
        // The observer should call disposeFrame() when the device turns off
    }

    private void disposeFrame() {
        dispose();
    }
}

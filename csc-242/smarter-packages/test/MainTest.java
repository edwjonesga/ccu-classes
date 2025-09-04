import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testHomeControllerInstance() {
        // This is just a smoke test to verify the method can be called without error
        HomeController controller = HomeController.getInstance(null);
    }
}

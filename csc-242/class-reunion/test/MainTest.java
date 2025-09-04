import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    
    @Test
    void testTimer() {
        Timer timer = new Timer();
        timer.start();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        assertTrue(timer.getElapsedTimeInSeconds() >= 1);
        timer.stop();
        assertTrue(timer.getElapsedTimeInSeconds() >= 1);
        timer.reset();
        assertEquals(0, timer.getElapsedTimeInSeconds());
    }
    
    @Test
    void testSongAndPlaylist() {
        Song song = new Song("Title", "Artist", 180);
        Playlist playlist = new Playlist();
        playlist.addSong(song);
        assertTrue(playlist.contains(song));
        playlist.removeSong(song);
        assertFalse(playlist.contains(song));
    }
    
    @Test
    void testDocumentHierarchy() {
        Document doc = new Report();
        Document invoice = new Invoice();
        assertTrue(doc instanceof Report);
        assertTrue(invoice instanceof Invoice);
    }
    
    @Test
    void testStudentCourseEnrollment() {
        Student student = new Student("Alice");
        Course course = new Course("Math 101");
        Enrollment enrollment = new Enrollment(student, course);
        assertEquals("Alice", enrollment.getStudent().getName());
        assertEquals("Math 101", enrollment.getCourse().getTitle());
    }
    
    @Test
    void testPaymentMethods() {
        PaymentMethod cc = new CreditCard();
        PaymentMethod paypal = new PayPal();
        cc.processPayment(100.00);
        paypal.processPayment(50.00);
        assertEquals(100.00, ((CreditCard) cc).getLastTransactionAmount());
        assertEquals(50.00, ((PayPal) paypal).getLastTransactionAmount());
    }
    
    @Test
    void testEmployeeAndManager() {
        Employee employee = new Employee("Alice", 50000);
        Manager manager = new Manager("Bob", 50000);
        assertEquals(50000, employee.getSalary());
        assertEquals(55000, manager.getSalary());
    }
}

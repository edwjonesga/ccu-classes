import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testSavingsAccount() {
        BankAccount savings = new SavingsAccount("Alice", 1000);

        // Test initial balance
        assertEquals(1000, savings.checkBalance(), "Initial balance should be 1000");

        // Test deposit method
        savings.deposit(500);
        assertEquals(1500, savings.checkBalance(), "Balance after depositing 500 should be 1500");

        // Test withdraw method
        savings.withdraw(300);
        assertEquals(1200, savings.checkBalance(), "Balance after withdrawing 300 should be 1200");

        // Test multiple deposits using overloaded method
        double[] deposits = {100, 200, 150};
        savings.deposit(deposits);
        assertEquals(1650, savings.checkBalance(), "Balance after multiple deposits should be 1650");

        // Test calculateInterest for savings account (assumed 3% interest)
        double interest = savings.calculateInterest();
        assertEquals(1650 * 0.03, interest, 0.01, "Savings account interest should be 3% of the balance");
    }

    @Test
    public void testCheckingAccount() {
        BankAccount checking = new CheckingAccount("Bob", 500);

        // Test initial balance
        assertEquals(500, checking.checkBalance(), "Initial balance should be 500");

        // Test deposit method
        checking.deposit(200);
        assertEquals(700, checking.checkBalance(), "Balance after depositing 200 should be 700");

        // Test withdraw method
        checking.withdraw(100);
        assertEquals(600, checking.checkBalance(), "Balance after withdrawing 100 should be 600");

        // Test calculateInterest for checking account (assumed 1% interest)
        double interest = checking.calculateInterest();
        assertEquals(600 * 0.01, interest, 0.01, "Checking account interest should be 1% of the balance");
    }

    @Test
    public void testBusinessAccount() {
        BankAccount business = new BusinessAccount("Charlie", 10000);

        // Test initial balance
        assertEquals(10000, business.checkBalance(), "Initial balance should be 10000");

        // Test deposit method
        business.deposit(5000);
        assertEquals(15000, business.checkBalance(), "Balance after depositing 5000 should be 15000");

        // Test withdraw method
        business.withdraw(7000);
        assertEquals(8000, business.checkBalance(), "Balance after withdrawing 7000 should be 8000");

        // Test calculateInterest for business account (assumed 5% interest)
        double interest = business.calculateInterest();
        assertEquals(8000 * 0.05, interest, 0.01, "Business account interest should be 5% of the balance");
    }

    @Test
    public void testWithdrawException() {
        BankAccount savings = new SavingsAccount("Alice", 500);

        // Test that an exception is thrown when withdrawing more than the balance
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            savings.withdraw(1000);  // Exceeds available balance
        });

        String expectedMessage = "Insufficient funds";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), "Exception message should indicate insufficient funds");
    }

    @Test
    public void testSetAccountHolderValidation() {
        BankAccount savings = new SavingsAccount("Alice", 1000);

        // Test setting a valid account holder name
        savings.setAccountHolder("Bob");
        assertEquals("Bob", savings.getAccountHolder(), "Account holder should be set to Bob");

        // Test setting an invalid account holder name (empty string)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            savings.setAccountHolder("");
        });

        String expectedMessage = "Account holder name cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), "Exception message should indicate invalid account holder name");
    }
}

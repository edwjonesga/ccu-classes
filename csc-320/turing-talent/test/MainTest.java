import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MainTest {

    private boolean matchesIgnoringLeadingTrailingUnderscores(String expected, String actual) {
        expected = expected.replaceAll("^_+|_+$", ""); // Remove leading and trailing underscores
        actual = actual.replaceAll("^_+|_+$", "");
        return actual.equals(expected);
    }

    @Test
    public void testUnaryAdder() {
        UnaryAdder adder = new UnaryAdder("111+11");
        String result = adder.compute();
        assertTrue(matchesIgnoringLeadingTrailingUnderscores("11111_", result), "Unary adder failed");
    }

    @Test
    public void testBinaryIncrementer() {
        BinaryIncrementer incrementer = new BinaryIncrementer("1011");
        String result = incrementer.compute();
        assertTrue(matchesIgnoringLeadingTrailingUnderscores("1100_", result), "Binary incrementer failed");
    }

    @Test
    public void testBinaryDecrementer() {
        BinaryDecrementer decrementer = new BinaryDecrementer("1011");
        String result = decrementer.compute();
        assertTrue(matchesIgnoringLeadingTrailingUnderscores("1010_", result), "Binary decrementer failed");
    }

    @Test
    public void testPalindromeChecker() {
        PalindromeChecker checker = new PalindromeChecker("11011");
        String result = checker.check();
        assertTrue(matchesIgnoringLeadingTrailingUnderscores("11011_", result), "Palindrome checker failed");
    }

    @Test
    public void testFailedPalindromeChecker() {
        PalindromeChecker checker = new PalindromeChecker("11010");
        String result = checker.check();
        assertFalse(matchesIgnoringLeadingTrailingUnderscores("11010_", result), "Palindrome checker should have failed but passed");
    }

    @Test
    public void testBinaryAdder() {
        BinaryAdder binaryAdder = new BinaryAdder("1010+101");
        String result = binaryAdder.compute();
        assertTrue(matchesIgnoringLeadingTrailingUnderscores("1111_", result), "Binary adder failed");
    }

    @Test
    public void testBinaryAdderFailure() {
        BinaryAdder binaryAdder = new BinaryAdder("1010+11");
        String result = binaryAdder.compute();
        assertFalse(matchesIgnoringLeadingTrailingUnderscores("1111_", result), "Binary adder should have failed but passed");
    }
}
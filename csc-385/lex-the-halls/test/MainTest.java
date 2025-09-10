import org.junit.Test;
import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.List;

public class MainTest {

    @Test
    public void testAllValidTokens() throws Exception {
        String input = """
            int x = 10;
            if (x > 5) {
                print("x is greater than 5");
            } else {
                print("x is 5 or less");
            }

            // loop example
            for (int i = 0; i <= 5; i = i + 1) {
                print(i);
            }

            /* multi-line
               comment */
            y = x * (x + 2) / 3 - 1;
            print(y);
            """;

        MyParser parser = new MyParser(new StringReader(input));
        List<String> tokens = parser.Start();

        assertEquals(List.of(
            "int", "x", "=", "10", ";",
            "if", "(", "x", ">", "5", ")", "{",
            "print", "(", "\"x is greater than 5\"", ")", ";",
            "}", "else", "{",
            "print", "(", "\"x is 5 or less\"", ")", ";",
            "}",
            "for", "(", "int", "i", "=", "0", ";", "i", "<=", "5", ";", "i", "=", "i", "+", "1", ")", "{",
            "print", "(", "i", ")", ";",
            "}",
            "y", "=", "x", "*", "(", "x", "+", "2", ")", "/", "3", "-", "1", ";",
            "print", "(", "y", ")", ";"
        ), tokens);
    }

    @Test(expected = ParseException.class)
    public void testInvalidTokenThrows() throws Exception {
        String input = "int z = 99; @bad;";
        MyParser parser = new MyParser(new StringReader(input));
        parser.Start(); // Should throw due to '@'
    }
}

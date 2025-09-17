import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.util.List;

public class MainTest {

    // ---------- VALID INPUT TESTS ----------

    @Test
    public void testAssignmentTokens() throws Exception {
        String input = "int x = 42;";
        MyParser parser = new MyParser(new StringReader(input));
        List<String> tokens = parser.Assignment();
        assertEquals(List.of("int", "x", "=", "42", ";"), tokens);
    }

    @Test
    public void testDeclarationTokens() throws Exception {
        String input = "int y;";
        MyParser parser = new MyParser(new StringReader(input));
        List<String> tokens = parser.Declaration();
        assertEquals(List.of("int", "y", ";"), tokens);
    }

    @Test
    public void testPrintStatementTokens() throws Exception {
        String input = "print(\"hello\");";
        MyParser parser = new MyParser(new StringReader(input));
        List<String> tokens = parser.PrintStatement();
        assertEquals(List.of("print", "(", "\"hello\"", ")", ";"), tokens);
    }

    @Test
    public void testIfStatementTokens() throws Exception {
        String input = "if (x > 0) { print(\"yes\"); }";
        MyParser parser = new MyParser(new StringReader(input));
        List<String> tokens = parser.IfStatement();
        assertEquals(List.of("if", "(", "x", ">", "0", ")", "{", "print", "(", "\"yes\"", ")", ";", "}"), tokens);
    }

    @Test
    public void testWhileStatementTokens() throws Exception {
        String input = "while (i < 10) { print(i); }";
        MyParser parser = new MyParser(new StringReader(input));
        List<String> tokens = parser.WhileStatement();
        assertEquals(List.of("while", "(", "i", "<", "10", ")", "{", "print", "(", "i", ")", ";", "}"), tokens);
    }

    @Test
    public void testForStatementTokens() throws Exception {
        String input = "for (int i = 0; i < 5; i = i + 1) { print(i); }";
        MyParser parser = new MyParser(new StringReader(input));
        List<String> tokens = parser.ForStatement();
        assertEquals(List.of(
                "for", "(", "int", "i", "=", "0", ";",
                "i", "<", "5", ";",
                "i", "=", "i", "+", "1", ")", "{",
                "print", "(", "i", ")", ";", "}"
        ), tokens);
    }

    @Test
    public void testFunctionDeclarationTokens() throws Exception {
        String input = "int add(int a, int b) { return a + b; }";
        MyParser parser = new MyParser(new StringReader(input));
        List<String> tokens = parser.FunctionDeclaration();
        assertEquals(List.of(
                "int", "add", "(", "int", "a", ",", "int", "b", ")", "{",
                "return", "a", "+", "b", ";", "}"
        ), tokens);
    }

    // ---------- SYNTAX ERROR TESTS ----------

    @Test
    public void testAssignmentMissingEqualsSign() {
        String input = "int x 42;";
        MyParser parser = new MyParser(new StringReader(input));
        assertThrows(ParseException.class, parser::Assignment);
    }

    @Test
    public void testDeclarationMissingSemicolon() {
        String input = "int y";
        MyParser parser = new MyParser(new StringReader(input));
        assertThrows(ParseException.class, parser::Declaration);
    }

    @Test
    public void testPrintMissingClosingParen() {
        String input = "print(\"hello\";";
        MyParser parser = new MyParser(new StringReader(input));
        assertThrows(ParseException.class, parser::PrintStatement);
    }

    @Test
    public void testIfStatementMissingBlock() {
        String input = "if (x > 0) print(\"yes\");";
        MyParser parser = new MyParser(new StringReader(input));
        assertThrows(ParseException.class, parser::IfStatement);
    }

    @Test
    public void testWhileStatementMissingParens() {
        String input = "while i < 10 { print(i); }";
        MyParser parser = new MyParser(new StringReader(input));
        assertThrows(ParseException.class, parser::WhileStatement);
    }

    @Test
    public void testForStatementMissingParens() {
        String input = "for int i = 0; i < 5; i = i + 1 { print(i); }";
        MyParser parser = new MyParser(new StringReader(input));
        assertThrows(ParseException.class, parser::ForStatement);
    }

    @Test
    public void testFunctionDeclarationMissingParams() {
        String input = "int add { return 0; }";
        MyParser parser = new MyParser(new StringReader(input));
        assertThrows(ParseException.class, parser::FunctionDeclaration);
    }

    @Test
    public void testInvalidTokenThrowsException() {
        String input = "int x = 42 @";
        MyParser parser = new MyParser(new StringReader(input));
        assertThrows(ParseException.class, parser::Assignment);
    }
}

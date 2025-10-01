import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.StringReader;

public class MainTest {

    // ---------- VALID INPUT TESTS ----------

    @Test
    public void testAssignmentAST() throws Exception {
        String input = "x = 42;";
        MyParser parser = new MyParser(new StringReader(input));
        ASTTestTree tree = parser.Assignment().toASTTestTree();
        assertEquals("(= x 42)", tree.toString());
    }

    @Test
    public void testDeclarationAST() throws Exception {
        String input = "int y;";
        MyParser parser = new MyParser(new StringReader(input));
        ASTTestTree tree = parser.Declaration().toASTTestTree();
        assertEquals("(decl int y)", tree.toString());
    }

    @Test
    public void testIfStatementAST() throws Exception {
        String input = "if (x > 0) { y = y * 2; }";
        MyParser parser = new MyParser(new StringReader(input));
        ASTTestTree tree = parser.IfStatement().toASTTestTree();
        assertEquals("(if (> x 0) (block (= y (* y 2))))", tree.toString());
    }

    @Test
    public void testWhileStatementAST() throws Exception {
        String input = "while (i < 10) { i = i + 1; }";
        MyParser parser = new MyParser(new StringReader(input));
        ASTTestTree tree = parser.WhileStatement().toASTTestTree();
        assertEquals("(while (< i 10) (block (= i (+ i 1))))", tree.toString());
    }

    @Test
    public void testForStatementAST() throws Exception {
        String input = "for (int i = 0; i < 5; i = i + 1) { y = y * 2; }";
        MyParser parser = new MyParser(new StringReader(input));
        ASTTestTree tree = parser.ForStatement().toASTTestTree();
        assertEquals(
            "(for (decl int i (= i 0)) (< i 5) (= i (+ i 1)) (block (= y (* y 2))))",
            tree.toString()
        );
    }

    @Test
    public void testFunctionDeclarationAST() throws Exception {
        String input = "int add(int a, int b) { return a + b; }";
        MyParser parser = new MyParser(new StringReader(input));
        ASTTestTree tree = parser.FunctionDeclaration().toASTTestTree();
        assertEquals(
            "(func int add (params (param int a) (param int b)) (block (return (+ a b))))",
            tree.toString()
        );
    }

    // ---------- SYNTAX ERROR TESTS ----------

    @Test
    public void testAssignmentMissingEqualsSign() {
        String input = "x 42;";
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
    public void testIfStatementMissingBlock() {
        String input = "if (x > 0) y = y * 2;";
        MyParser parser = new MyParser(new StringReader(input));
        assertThrows(ParseException.class, parser::IfStatement);
    }

    @Test
    public void testWhileStatementMissingParens() {
        String input = "while i < 10 { i = i + 1; }";
        MyParser parser = new MyParser(new StringReader(input));
        assertThrows(ParseException.class, parser::WhileStatement);
    }

    @Test
    public void testForStatementMissingParens() {
        String input = "for int i = 0; i < 5; i = i + 1 { y = y * 2; }";
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

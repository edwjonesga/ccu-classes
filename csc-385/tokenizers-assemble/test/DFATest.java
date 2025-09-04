import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

public class DFATest {

    // Individual DFA instances (for unit testing only)
    private DFA identifierDFA;
    private DFA keywordIfDFA;
    private DFA keywordPrintDFA;
    private DFA numberDFA;
    private DFA equalsDFA;
    private DFA doubleEqualsDFA;
    private DFA plusDFA;

    // Orchestrator (assumed to have all DFAs pre-registered by student)
    private TokenizerOrchestrator orchestrator;

    @BeforeEach
    public void setUp() {
        identifierDFA = new IdentifierDFA();
        keywordIfDFA = new KeywordDFA("if");
        keywordPrintDFA = new KeywordDFA("print");
        numberDFA = new IntegerDFA();
        equalsDFA = new EqualsDFA();
        doubleEqualsDFA = new DoubleEqualsDFA();
        plusDFA = new PlusDFA();

        // This should point to the student's implementation
        orchestrator = new TokenizerOrchestratorImplementation();
    }

    // =======================
    // Individual DFA Tests
    // =======================

    @Test
    public void testIdentifier() {
        feed("x", identifierDFA);
        assertTrue(identifierDFA.isAccepting());
        assertEquals("x", identifierDFA.getCurrentLexeme());

        identifierDFA.reset();
        feed("var123", identifierDFA);
        assertTrue(identifierDFA.isAccepting());
        assertEquals("var123", identifierDFA.getCurrentLexeme());

        identifierDFA.reset();
        feed("1bad", identifierDFA);
        assertFalse(identifierDFA.isAccepting());
    }

    @Test
    public void testKeywordIf() {
        feed("if", keywordIfDFA);
        assertTrue(keywordIfDFA.isAccepting());

        keywordIfDFA.reset();
        feed("iffy", keywordIfDFA);
        assertFalse(keywordIfDFA.isAccepting());
    }

    @Test
    public void testKeywordPrint() {
        feed("print", keywordPrintDFA);
        assertTrue(keywordPrintDFA.isAccepting());

        keywordPrintDFA.reset();
        feed("printer", keywordPrintDFA);
        assertFalse(keywordPrintDFA.isAccepting());
    }

    @Test
    public void testNumber() {
        feed("42", numberDFA);
        assertTrue(numberDFA.isAccepting());

        numberDFA.reset();
        feed("003", numberDFA);
        assertTrue(numberDFA.isAccepting());

        numberDFA.reset();
        feed("abc", numberDFA);
        assertFalse(numberDFA.isAccepting());
    }

    @Test
    public void testEquals() {
        feed("=", equalsDFA);
        assertTrue(equalsDFA.isAccepting());

        equalsDFA.reset();
        feed("==", equalsDFA);
        assertFalse(equalsDFA.isAccepting());
    }

    @Test
    public void testDoubleEquals() {
        feed("==", doubleEqualsDFA);
        assertTrue(doubleEqualsDFA.isAccepting());

        doubleEqualsDFA.reset();
        feed("=", doubleEqualsDFA);
        assertFalse(doubleEqualsDFA.isAccepting());
    }

    @Test
    public void testPlus() {
        feed("+", plusDFA);
        assertTrue(plusDFA.isAccepting());

        plusDFA.reset();
        feed("++", plusDFA);
        assertFalse(plusDFA.isAccepting());
    }

    // =======================
    // Orchestrator Integration Tests
    // =======================

    @Test
    public void testSimpleCodeSnippet() {
        String input = "if x == 10\nprint x\nx = x + 1";

        List<Token> tokens = orchestrator.tokenize(input);

        List<String> expected = List.of(
            "Keyword: if",
            "Identifier: x",
            "Comparison: ==",
            "Number: 10",
            "Keyword: print",
            "Identifier: x",
            "Identifier: x",
            "Assignment: =",
            "Identifier: x",
            "Arithmetic: +",
            "Number: 1"
        );

        List<String> actual = new ArrayList<>();
        for (Token token : tokens) {
            actual.add(token.getType() + ": " + token.getLexeme());
        }

        assertEquals(expected, actual);
    }

    @Test
    public void testUnknownTokenBehavior() {
        String input = "if @print";

        List<Token> tokens = orchestrator.tokenize(input);
        boolean containsUnknown = tokens.stream()
                .anyMatch(t -> t.getType().equalsIgnoreCase("UNKNOWN"));

        assertTrue(containsUnknown || tokens.size() < 3,
            "Unrecognized token should be handled or skipped");
    }

    @Test
    public void testWhitespaceHandling() {
        String input = "   \n\t  if   \n  ";

        List<Token> tokens = orchestrator.tokenize(input);

        assertEquals(1, tokens.size());
        assertEquals("Keyword", tokens.get(0).getType());
        assertEquals("if", tokens.get(0).getLexeme());
    }

    // =======================
    // Utility
    // =======================

    private void feed(String input, DFA dfa) {
        for (char c : input.toCharArray()) {
            dfa.processChar(c);
        }
    }
}

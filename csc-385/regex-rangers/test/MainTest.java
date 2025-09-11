import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private RegexOrchestrator orchestrator;

    @BeforeEach
    public void setUp() {
        orchestrator = new TokenizerOrchestratorImplementation();

        // Register tokenizers in priority order
        orchestrator.registerTokenizer(new IfTokenizer());
        orchestrator.registerTokenizer(new PrintTokenizer());
        orchestrator.registerTokenizer(new IdentifierTokenizer());
        orchestrator.registerTokenizer(new EqualEqualTokenizer());
        orchestrator.registerTokenizer(new EqualTokenizer());
        orchestrator.registerTokenizer(new NumberTokenizer());
        orchestrator.registerTokenizer(new PlusTokenizer());
    }

    @Test
    public void testTokenizationOutput() {
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
            actual.add(token.toString());
        }

        assertEquals(expected, actual);
    }

    @Test
    public void testUnknownTokenHandling() {
        String input = "if @ x";

        List<Token> tokens = orchestrator.tokenize(input);
        boolean hasUnknown = tokens.stream()
                .anyMatch(t -> t.getType().equalsIgnoreCase("UNKNOWN"));

        assertTrue(hasUnknown, "Expected an UNKNOWN token for '@'");
    }

    @Test
    public void testWhitespaceIsIgnored() {
        String input = "   \n\t print   ";

        List<Token> tokens = orchestrator.tokenize(input);

        assertEquals(1, tokens.size());
        assertEquals("Keyword", tokens.get(0).getType());
        assertEquals("print", tokens.get(0).getLexeme());
    }
}
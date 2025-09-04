import java.util.List;

public interface TokenizerOrchestrator {

    /**
     * Registers a DFA with the orchestrator.
     * DFAs will be tested in the order they are registered.
     *
     * @param dfa the DFA to add
     */
    void registerDFA(DFA dfa);

    /**
     * Tokenizes a complete input string.
     * The orchestrator will scan the input character by character,
     * trying each registered DFA until one recognizes a valid token.
     *
     * @param input the full input string (e.g., code snippet)
     * @return a list of recognized tokens in the format (tokenType, lexeme)
     */
    List<Token> tokenize(String input);
}

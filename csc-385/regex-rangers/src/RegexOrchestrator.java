public interface RegexOrchestrator {

    /**
     * Registers a tokenizer.
     * Tokenizers will be evaluated in the order they are registered.
     */
    void registerTokenizer(RegexTokenizer tokenizer);

    /**
     * Scans the input string and returns a list of matched tokens.
     *
     * @param input The input program (e.g., code snippet)
     * @return List of tokens (each with type and lexeme)
     */
    List<Token> tokenize(String input);
}

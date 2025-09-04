public interface DFA {
    /**
     * Resets the DFA to its start state.
     */
    void reset();

    /**
     * Processes a single character and advances the DFA’s state.
     *
     * @param c the input character
     */
    void processChar(char c);

    /**
     * Returns true if the DFA is currently in an accepting state.
     */
    boolean isAccepting();

    /**
     * Returns true if the DFA has reached a dead state
     * and can no longer accept any input.
     */
    boolean isDeadState();

    /**
     * Returns the type of token this DFA recognizes (e.g., "Identifier", "Number").
     */
    String getTokenType();

    /**
     * Returns the string recognized by the DFA so far.
     */
    String getCurrentLexeme();
}

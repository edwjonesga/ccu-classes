public interface RegexTokenizer {

    /**
     * Returns the type of token this matcher recognizes.
     * For example: "Keyword", "Identifier", "Number"
     */
    String getTokenType();

    /**
     * Attempts to match from the beginning of the given input.
     *
     * @param input The input string to scan from index 0
     * @return Optional length of match (0 if no match)
     */
    Optional<Integer> match(String input);
}

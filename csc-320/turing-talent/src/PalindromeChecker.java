public class PalindromeChecker {
    private TuringMachine tm;

    public PalindromeChecker(String input) {
        tm = new TuringMachine(input, "q0", "q_accept", "q_reject");
    }

    public String check() {
        tm.run();
        return tm.getTapeOutput();
    }
}

public class UnaryAdder {
    private TuringMachine tm;

    public UnaryAdder(String input) {
        tm = new TuringMachine(input, "q0", "q_accept", "q_reject");
    }

    public String compute() {
        tm.run();
        return tm.getTapeOutput();
    }
}

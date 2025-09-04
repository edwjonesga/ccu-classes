public class BinaryDecrementer {
    private TuringMachine tm;

    public BinaryDecrementer(String input) {
        tm = new TuringMachine(input, "q0", "q_accept", "q_reject");
    }

    public String compute() {
        tm.run();
        return tm.getTapeOutput();
    }
}

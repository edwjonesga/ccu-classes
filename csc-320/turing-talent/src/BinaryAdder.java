public class BinaryAdder {
    private TuringMachine tm;

    public BinaryAdder(String input) {
        tm = new TuringMachine(input, "q0", "q_accept", "q_reject");
    }

    public String compute() {
        tm.run();
        return tm.getTapeOutput();
    }
}

public class BinaryIncrementer {
    private TuringMachine tm;

    public BinaryIncrementer(String input) {
        tm = new TuringMachine(input, "init", "q_accept", "q_reject");
        tm.addRule("init",'_','_','R',"init");
        tm.addRule("init",'1','1','R',"q0");
        tm.addRule("init",'0','0','R',"q0");
        tm.addRule("q0",'1','1','R',"q0");
        tm.addRule("q0",'0','0','R',"q0");
        tm.addRule("q0",'_','_','L',"q1");

        // Found the end of the number lets process it
        tm.addRule("q1",'0','1','L',"q_accept");
        tm.addRule("q1",'_','1','L',"q_accept");
        tm.addRule("q1",'1', '0', 'L', "q1");
    }

    public String compute() {
        tm.run();
        return tm.getTapeOutput();
    }
}

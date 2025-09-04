import java.util.HashMap;
import java.util.Map;
public class TuringMachine {
    private char[] tape;
    private int head;
    private String state;
    private final Map<String, Transition> transitionRules;
    private final String ACCEPT_STATE;
    private final String REJECT_STATE;

    public TuringMachine(String input, String startState, String acceptState, String rejectState) {
        this.tape = (input + "_").toCharArray();
        this.head = 0;
        this.state = startState;
        this.transitionRules = new HashMap<>();
        this.ACCEPT_STATE = acceptState;
        this.REJECT_STATE = rejectState;
    }

    public void addRule(String inState, char justRead, char write, char move, String newState) {
        transitionRules.put(inState + "," + justRead, new Transition(newState, write, move));
    }

    public void run() {
        while (!state.equals(ACCEPT_STATE) && !state.equals(REJECT_STATE)) {
            String key = state + "," + tape[head];
            if (!transitionRules.containsKey(key)) {
                break;
            }

            Transition transition = transitionRules.get(key);
            tape[head] = transition.writeSymbol;
            state = transition.newState;
            head += (transition.moveDirection == 'R') ? 1 : -1;
            
            if (head < 0) {
                head = 0;
            }
        }
    }

    public String getTapeOutput() {
        return new String(tape).trim();
    }

    public static class Transition {
        String newState;
        char writeSymbol;
        char moveDirection;

        public Transition(String newState, char writeSymbol, char moveDirection) {
            this.newState = newState;
            this.writeSymbol = writeSymbol;
            this.moveDirection = moveDirection;
        }
    }
}

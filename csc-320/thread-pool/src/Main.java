
import java.util.List;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Sample input: lines of text
        List<String> input = List.of(
            "to be or not to be",
            "that is the question",
            "to be is to do",
            "do be do be do"
        );

        // Mapper: for each line, emit (word, 1) pairs
        Mapper<String, String, Integer> mapper = line -> {
            List<Pair<String, Integer>> output = new ArrayList<>();
            for (String word : line.split("\\s+")) {
                output.add(new Pair<>(word.toLowerCase(), 1));
            }
            return output;
        };

        // Reducer: sum the values for each word
        Reducer<String, Integer, Integer> reducer = (word, counts) -> {
            int sum = 0;
            for (int count : counts) {
                sum += count;
            }
            return sum;
        };

        // Create engine and run
        MapReduceEngine<String, String, Integer, Integer> engine = new MapReduceEngine<>();
        Map<String, Integer> result = engine.execute(input, mapper, reducer, 4);

        // Output results
        System.out.println("Word count results:");
        result.forEach((word, count) -> System.out.printf("%-10s : %d%n", word, count));
    }
}



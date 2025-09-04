import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.concurrent.*;

public class MainTest {

    @Test
    public void testMapReduceWordCount() throws Exception {
        List<String> input = List.of(
            "a b a",
            "b c a"
        );

        Mapper<String, String, Integer> mapper = line -> {
            List<Pair<String, Integer>> output = new ArrayList<>();
            for (String word : line.split("\\s+")) {
                output.add(new Pair<>(word.toLowerCase(), 1));
            }
            return output;
        };

        Reducer<String, Integer, Integer> reducer = (word, counts) -> {
            int sum = 0;
            for (int count : counts) sum += count;
            return sum;
        };

        MapReduceEngine<String, String, Integer, Integer> engine = new MapReduceEngine<>();
        Map<String, Integer> result = engine.execute(input, mapper, reducer, 3);

        assertEquals(3, result.get("a"), "Expected 'a' to occur 3 times");
        assertEquals(2, result.get("b"), "Expected 'b' to occur 2 times");
        assertEquals(1, result.get("c"), "Expected 'c' to occur 1 time");
    }
}

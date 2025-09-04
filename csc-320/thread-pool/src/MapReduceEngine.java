
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapReduceEngine<I, K, V, R> {

    /**
     * Executes a MapReduce job using student-supplied map and reduce functions.
     * The map and reduce phases should each use multiple threads.
     */
    public Map<K, R> execute(
        List<I> inputData,
        Mapper<I, K, V> mapper,
        Reducer<K, V, R> reducer,
        int numThreads
    ) throws InterruptedException {

        // TODO 1: Create a thread pool and submit map tasks for each input item
        // Each task should return a list of (K, V) pairs
        List<Pair<K, V>> intermediatePairs = new ArrayList<>();

        // TODO 2: Shuffle Phase — group intermediate pairs by key
        // Build a Map<K, List<V>> to hold the grouped data
        Map<K, List<V>> grouped = new HashMap<>();

        // TODO 3: Create a thread pool and submit reduce tasks
        // Each task should reduce a key and list of values to a final result
        Map<K, R> finalResults = new TreeMap<>();

        // TODO 4: Return the map of reduced results
        return finalResults;
    }
}

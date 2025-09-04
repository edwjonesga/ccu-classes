
import java.util.List;

public interface Mapper<I, K, V> {
    /**
     * Applies the map function to a single input item.
     * Returns a list of key-value pairs.
     */
    List<Pair<K, V>> map(I input);
}

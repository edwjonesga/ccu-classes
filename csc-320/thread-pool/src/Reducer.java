import java.util.List;

public interface Reducer<K, V, R> {
    /**
     * Applies the reduce function to a key and all associated values.
     * Returns a single reduced result per key.
     */
    R reduce(K key, List<V> values);
}

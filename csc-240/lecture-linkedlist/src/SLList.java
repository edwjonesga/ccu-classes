public interface SLList<T> {
    void addFirst(T data);
    void addLast(T data);
    T removeFirst();
    int size();
    T[] toArray();
}

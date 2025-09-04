public interface Deque<T> {
    void addFirst(T element); 
    void addLast(T element);
    T removeFirst();
    T removeLast();
    T peekFirst();
    T peekLast();
    boolean isEmpty();
}

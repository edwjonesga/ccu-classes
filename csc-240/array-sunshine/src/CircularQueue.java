public class CircularQueue<T> {
    private T[] array;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        // TODO: Initialize the circular queue with the given capacity
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(T element) {
        // TODO: Add the element to the rear of the queue, wrapping around if necessary
    }

    public T dequeue() {
        // TODO: Remove and return the element at the front of the queue, wrapping around if necessary
        return null;
    }

    public int size() {
        // TODO: Return the current number of elements in the queue
        return 0;
    }
}

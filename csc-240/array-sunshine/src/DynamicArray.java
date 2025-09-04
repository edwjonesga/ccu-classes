public class DynamicArray<T> {
    private T[] array;
    private int size;

    public DynamicArray() {
        // TODO: Initialize the array with a small initial capacity and size
        this.array = (T[]) new Object[4];
        this.size = 0;
    }

    public void add(T element) {
        // TODO: Add the given element to the dynamic array, resizing if necessary
    }

    public T get(int index) {
        // TODO: Return the element at the specified index
        return null;
    }

    public int size() {
        // TODO: Return the current number of elements in the array
        return 0;
    }

    private void resize() {
        // TODO: Double the size of the array and copy over the elements
    }
}

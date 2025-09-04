// DynamicArray.java

// CircularQueue.java

// Matrix.java
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting the Array-tastic Adventure!");

        // Demonstrate DynamicArray functionality
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        System.out.println("Adding elements to DynamicArray");
        for (int i = 1; i <= 8; i++) {
            dynamicArray.add(i);
            System.out.println("Added: " + i);
        }
        System.out.println("Size of DynamicArray: " + dynamicArray.size());

        // Demonstrate CircularQueue functionality
        CircularQueue<String> circularQueue = new CircularQueue<>(5);
        System.out.println("Enqueueing elements into CircularQueue");
        circularQueue.enqueue("A");
        circularQueue.enqueue("B");
        circularQueue.enqueue("C");
        circularQueue.enqueue("D");
        circularQueue.enqueue("E");

        System.out.println("Dequeued: " + circularQueue.dequeue());
        circularQueue.enqueue("F");
        System.out.println("Dequeued: " + circularQueue.dequeue());

        // Demonstrate Matrix functionality
        int[][] matrixData = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        Matrix matrix = new Matrix(matrixData);
        System.out.println("Top-left to bottom-right diagonal: ");
        int[] diagonal = matrix.getTopLeftToBottomRightDiagonal();
        for (int val : diagonal) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

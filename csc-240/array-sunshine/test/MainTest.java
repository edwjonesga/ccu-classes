import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {

    private DynamicArray<Integer> dynamicArray;
    private CircularQueue<String> circularQueue;
    private Matrix matrix;

    @BeforeEach
    public void setUp() {
        dynamicArray = new DynamicArray<>();
        circularQueue = new CircularQueue<>(3);
        int[][] matrixData = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        matrix = new Matrix(matrixData);
    }

    @Test
    public void testDynamicArrayResizeAndAdd() {
        for (int i = 0; i < 100; i++) {
            dynamicArray.add(i);
        }
        Assertions.assertEquals(100, dynamicArray.size(), "Dynamic array did not resize correctly.");
        Assertions.assertEquals(99, dynamicArray.get(99), "Dynamic array failed to add elements correctly.");
    }

    @Test
    public void testCircularQueue() {
        circularQueue.enqueue("A");
        circularQueue.enqueue("B");
        circularQueue.enqueue("C");

        Assertions.assertEquals("A", circularQueue.dequeue(), "Incorrect element dequeued.");
        circularQueue.enqueue("D");
        Assertions.assertEquals("B", circularQueue.dequeue(), "Incorrect element dequeued.");
        Assertions.assertEquals("C", circularQueue.dequeue(), "Incorrect element dequeued.");
        Assertions.assertEquals("D", circularQueue.dequeue(), "Incorrect element dequeued.");
    }

    @Test
    public void testMatrixDiagonals() {
        int[] topLeftToBottomRight = matrix.getTopLeftToBottomRightDiagonal();
        Assertions.assertArrayEquals(new int[]{1, 5, 9}, topLeftToBottomRight, "Incorrect top-left to bottom-right diagonal.");

        int[] topRightToBottomLeft = matrix.getTopRightToBottomLeftDiagonal();
        Assertions.assertArrayEquals(new int[]{3, 5, 7}, topRightToBottomLeft, "Incorrect top-right to bottom-left diagonal.");

        int[] bottomRightToTopLeft = matrix.getBottomRightToTopLeftDiagonal();
        Assertions.assertArrayEquals(new int[]{9, 5, 1}, bottomRightToTopLeft, "Incorrect bottom-right to top-left diagonal.");

        int[] bottomLeftToTopRight = matrix.getBottomLeftToTopRightDiagonal();
        Assertions.assertArrayEquals(new int[]{7, 5, 3}, bottomLeftToTopRight, "Incorrect bottom-left to top-right diagonal.");
    }

    @Test
    public void testMatrixAddition() {
        int[][] otherData = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };
        Matrix otherMatrix = new Matrix(otherData);
        Matrix resultMatrix = matrix.add(otherMatrix);

        int[][] expected = {
            {10, 10, 10},
            {10, 10, 10},
            {10, 10, 10}
        };
        Assertions.assertArrayEquals(expected, resultMatrix.toArray(), "Matrix addition failed.");
    }

    @Test
    public void testMatrixMultiplication() {
        int[] vector = {1, 2, 3};
        int[] result = matrix.multiply(vector);

        Assertions.assertArrayEquals(new int[]{14, 32, 50}, result, "Matrix-vector multiplication failed.");
    }
}

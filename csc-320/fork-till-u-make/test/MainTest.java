import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class MainTest {

    private static final Random random = new Random();

    // === Part 1: SimpleForkJoinTask Tests ===

    @Test
    public void testSimpleSum() {
        int[] arr = { 1, 2, 3, 4, 5 };
        SimpleForkJoinTask task = new SimpleForkJoinTask(arr, 0, arr.length);
        int result = ForkJoinPool.commonPool().invoke(task);
        assertEquals(15, result, "Sum of the array should be 15");
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        SimpleForkJoinTask task = new SimpleForkJoinTask(arr, 0, arr.length);
        int result = ForkJoinPool.commonPool().invoke(task);
        assertEquals(0, result, "Sum of an empty array should be 0");
    }

    // === Part 2: ParallelMergeSort Tests ===

    @Test
    public void testSortArray() {
        int[] input = { 5, 3, 1, 4, 2 };
        int[] expected = { 1, 2, 3, 4, 5 };
        ParallelMergeSort task = new ParallelMergeSort(input);
        int[] result = ForkJoinPool.commonPool().invoke(task);
        assertArrayEquals(expected, result, "Array should be sorted");
    }

    @Test
    public void testAlreadySorted() {
        int[] input = { 1, 2, 3, 4, 5 };
        ParallelMergeSort task = new ParallelMergeSort(input);
        int[] result = ForkJoinPool.commonPool().invoke(task);
        assertArrayEquals(input, result, "Already sorted array should remain unchanged");
    }

    // === Part 3: ParallelMatrixMultiplyTask Tests ===

    @Test
    public void testMatrixMultiply3x3() {
        double[][] A = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        double[][] B = {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
        };

        double[][] expected = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        double[][] C = new double[3][3];
        ParallelMatrixMultiplyTask task = new ParallelMatrixMultiplyTask(A, B, C, 0, 3);
        ForkJoinPool.commonPool().invoke(task);

        for (int i = 0; i < 3; i++) {
            assertArrayEquals(expected[i], C[i], 0.0001, "Matrix multiplication result incorrect at row " + i);
        }
    }


    @Test
    public void testLargeMergeSort() {
        int size = 1_000_000;
        int[] input = random.ints(size, 0, 10_000).toArray();
        int[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);

        ParallelMergeSort task = new ParallelMergeSort(input);
        int[] result = ForkJoinPool.commonPool().invoke(task);
        assertArrayEquals(expected, result, "Large array should be sorted correctly");
    }

    @Test
    public void testLargeMatrixMultiply() {
        int size = 200; // 200x200 matrix = 8 million multiplications
        double[][] A = new double[size][size];
        double[][] B = new double[size][size];
        double[][] C = new double[size][size];

        // Fill A with 1.0 and B with 2.0
        for (int i = 0; i < size; i++) {
            Arrays.fill(A[i], 1.0);
            Arrays.fill(B[i], 2.0);
        }

        ParallelMatrixMultiplyTask task = new ParallelMatrixMultiplyTask(A, B, C, 0, size);
        ForkJoinPool.commonPool().invoke(task);

        double expectedValue = size * 2.0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertEquals(expectedValue, C[i][j], 0.0001,
                        "C[" + i + "][" + j + "] should equal " + expectedValue);
            }
        }
    }

}

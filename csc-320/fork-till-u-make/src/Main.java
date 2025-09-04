import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        int size = 1_000_000;
        System.out.println(size);
        runSimpleForkJoin();
        runParallelMergeSort();
        runParallelMatrixMultiply();
    }

    // Part 1: Test SimpleForkJoinTask
    private static void runSimpleForkJoin() {
        System.out.println("== SimpleForkJoinTask ==");
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        SimpleForkJoinTask task = new SimpleForkJoinTask(arr, 0, arr.length);
        
        int result = ForkJoinPool.commonPool().invoke(task);
        System.out.println("Sum: " + result);
    }

    // Part 2: Test ParallelMergeSort
    private static void runParallelMergeSort() {
        System.out.println("\n== ParallelMergeSort ==");
        int[] unsorted = {9, 1, 5, 3, 8, 2, 6, 4, 7};
        ParallelMergeSort sortTask = new ParallelMergeSort(unsorted);
        int[] sorted = ForkJoinPool.commonPool().invoke(sortTask);
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }

    // Part 3: Test ParallelMatrixMultiplyTask
    private static void runParallelMatrixMultiply() {
        System.out.println("\n== ParallelMatrixMultiplyTask ==");
        int m = 3, n = 3, p = 3;

        double[][] A = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        double[][] B = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        double[][] C = new double[m][p];

        ParallelMatrixMultiplyTask task = new ParallelMatrixMultiplyTask(A, B, C, 0, m);
        ForkJoinPool.commonPool().invoke(task);

        System.out.println("Product:");
        for (double[] row : C) {
            System.out.println(Arrays.toString(row));
        }
    }
}

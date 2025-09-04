
import java.util.concurrent.RecursiveTask;


public class ParallelMergeSort extends RecursiveTask<int[]> {
    private final int[] array;
    private static final int THRESHOLD = 1000;

    public ParallelMergeSort(int[] array) {
        this.array = array;
    }

    @Override
    protected int[] compute() {
        // TODO: If small, sort sequentially
        // Otherwise, fork left and right, then merge
        return null;
    }

    private int[] merge(int[] left, int[] right) {
        // TODO: Implement merge logic
        return new int[0];
    }
}

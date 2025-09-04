
import java.util.concurrent.RecursiveTask;


public class SimpleForkJoinTask extends RecursiveTask<Integer> {
    private final int[] array;
    private final int start;
    private final int end;
    private static final int THRESHOLD = 10;

    public SimpleForkJoinTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int length = end - start;
        
        if(length <= THRESHOLD){
            int sum = 0;
            for (int i = start; i<end;i++) {
                sum += array[i];
            }
            return sum;
        }

        // Recursive case: split and add both halves
        int mid = start+length/2;

        SimpleForkJoinTask leftHalf = new SimpleForkJoinTask(array, start, mid);
        SimpleForkJoinTask rightHalf = new SimpleForkJoinTask(array, mid, end);

        leftHalf.fork();

        int rightSum = rightHalf.compute();
        int leftSum = leftHalf.join();

        return leftSum+rightSum;
    }
}

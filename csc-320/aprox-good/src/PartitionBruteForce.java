import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class PartitionBruteForce {

    public static class Result {
        public List<Integer> subsetA;
        public List<Integer> subsetB;
        public int diff;

        public Result(List<Integer> a, List<Integer> b, int diff) {
            this.subsetA = a;
            this.subsetB = b;
            this.diff = diff;
        }
    }

    public static Result findBestPartition(List<Integer> nums) {
        int n = nums.size();
        int bestDiff = Integer.MAX_VALUE;
        List<Integer> bestA = new ArrayList<>();
        List<Integer> bestB = new ArrayList<>();

        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            int sumA = 0, sumB = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    a.add(nums.get(i));
                    sumA += nums.get(i);
                } else {
                    b.add(nums.get(i));
                    sumB += nums.get(i);
                }
            }

            int currentDiff = Math.abs(sumA - sumB);
            if (currentDiff < bestDiff) {
                bestDiff = currentDiff;
                bestA = new ArrayList<>(a);
                bestB = new ArrayList<>(b);
            }
        }

        return new Result(bestA, bestB, bestDiff);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 1, 4, 2, 2, 1, 1,9,7,5);
        Result result = findBestPartition(nums);

        System.out.println("Subset A: " + result.subsetA);
        System.out.println("Subset B: " + result.subsetB);
        System.out.println("Difference: " + result.diff);
    }
}

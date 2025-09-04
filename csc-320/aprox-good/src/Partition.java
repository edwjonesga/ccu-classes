
import java.util.List;

public class Partition {
  public PartitionBruteForce.Result bruteForcePartition(List<Integer> nums) {
    return PartitionBruteForce.findBestPartition(nums);
  }

  public PartitionBruteForce.Result greedyPartition(List<Integer> nums) {
    return null;
  }

  public PartitionBruteForce.Result ptasPartition(List<Integer> nums, double epsilon) {
    return null;
  }
}

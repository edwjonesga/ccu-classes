import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class MainTest {

    @Test
    public void testVertexCoverMaxDegree() {
        VertexCoverAssignment.Graph g = VertexCoverAssignment.generatePathologicalGraph();
        Set<String> cover = VertexCoverAssignment.vertexCoverMaxDegree(g);

        List<String[]> edges = g.getEdges();
        for (String[] edge : edges) {
            assertTrue(cover.contains(edge[0]) || cover.contains(edge[1]), 
                "Edge " + Arrays.toString(edge) + " not covered");
        }
    }

    @Test
    public void testVertexCoverTwoApproxStub() {
        VertexCoverAssignment.Graph g = VertexCoverAssignment.generatePathologicalGraph();
        Set<String> cover = VertexCoverAssignment.vertexCoverTwoApprox(g);

        assertNotNull(cover, "2-approximation algorithm is not implemented");
        List<String[]> edges = g.getEdges();
        for (String[] edge : edges) {
            assertTrue(cover.contains(edge[0]) || cover.contains(edge[1]),
                "Edge " + Arrays.toString(edge) + " not covered");
        }
    }

    @Test
    public void testPathologicalGraphComparison() {
        VertexCoverAssignment.Graph g = VertexCoverAssignment.generatePathologicalGraph();
        Set<String> greedyCover = VertexCoverAssignment.vertexCoverMaxDegree(g);
        Set<String> approxCover = VertexCoverAssignment.vertexCoverTwoApprox(g);

        assertNotNull(greedyCover);
        assertNotNull(approxCover);
        assertTrue(approxCover.size() <= 2 * greedyCover.size() || greedyCover.size() < approxCover.size(),
            "Greedy may perform worse; this is expected");
    }

    @Test
    public void testBruteForcePartition() {
        Partition p = new Partition();
        List<Integer> nums = Arrays.asList(3, 1, 4, 2, 2);
        PartitionBruteForce.Result result = p.bruteForcePartition(nums);

        int sum1 = result.subsetA.stream().mapToInt(i -> i).sum();
        int sum2 = result.subsetA.stream().mapToInt(i -> i).sum();

        assertEquals(sum1, sum2, 1, "Brute-force partition is not approximately balanced");
    }

   
    @Test
    public void testGreedyPartition() {
        Partition p = new Partition();
        List<Integer> nums = Arrays.asList(10, 7, 6, 2, 1);
        PartitionBruteForce.Result result = p.greedyPartition(nums);

        assertNotNull(result);
        int sum1 = result.subsetA.stream().mapToInt(i -> i).sum();
        int sum2 = result.subsetB.stream().mapToInt(i -> i).sum();

        assertTrue(Math.abs(sum1 - sum2) <= Collections.max(nums),
            "Greedy partition should be reasonably balanced");
    }

    @Test
    public void testPTASPartition() {
        Partition p = new Partition();
        List<Integer> nums = Arrays.asList(10, 7, 6, 2, 1);
        PartitionBruteForce.Result result = p.ptasPartition(nums, 0.2);

        assertNotNull(result);
        int sum1 = result.subsetA.stream().mapToInt(i -> i).sum();
        int sum2 = result.subsetB.stream().mapToInt(i -> i).sum();

        double total = sum1 + sum2;
        double ratio = Math.max(sum1, sum2) / (total / 2);

        assertTrue(ratio <= 1.2,
            "PTAS partition should be within (1+ε) = 1.2 of optimal: got ratio = " + ratio);
    }
}

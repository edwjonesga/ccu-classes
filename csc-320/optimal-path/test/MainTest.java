import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MainTest {
    
    @Test
    public void testCoinChange() {
        int[] coins = {1, 5, 10};
        assertEquals(2, CoinChange.minCoins(coins, 15)); // Expecting 2 coins (10 + 5)
        assertEquals(1, CoinChange.minCoins(coins, 10)); // Expecting 1 coin (10)
        assertEquals(3, CoinChange.minCoins(coins, 7));  // Expecting 3 coins (5 + 1 + 1)
        assertEquals(-1, CoinChange.minCoins(coins, 3)); // Expecting -1 (not possible)
    }
    
    @Test
    public void testRodCutting() {
        int[] prices = {2, 5, 7, 8, 10};
        assertEquals(10, RodCutting.maxRodValue(prices, 5)); // Expecting max value 10
        assertEquals(12, RodCutting.maxRodValue(prices, 4)); // Expecting max value 12 (2 cuts)
        assertEquals(0, RodCutting.maxRodValue(prices, 0));  // Expecting 0 (no rod)
    }
    
    @Test
    public void testKnightShortestPath() {
        assertEquals(6, KnightShortestPath.minKnightMoves(8, 7, 7)); // Expecting 6 moves
        assertEquals(1, KnightShortestPath.minKnightMoves(8, 2, 1)); // Expecting 1 move
        assertEquals(0, KnightShortestPath.minKnightMoves(8, 0, 0)); // Expecting 0 moves (same position)
    }
    
    @Test
    public void testCoinChangeSolutionReconstruction() {
        int[] coins = {1, 5, 10};
        List<Integer> result = CoinChangeSolutionReconstruction.reconstructSolution(coins, 14);
        assertEquals(List.of(10, 1, 1, 1), result); // Expecting one possible solution

        result = CoinChangeSolutionReconstruction.reconstructSolution(coins, 7);
        assertEquals(List.of(5, 1, 1), result); // Expecting another valid solution
    }
    
    @Test
    public void testKnapsack() {
        Knapsack.Item[] items = {
            new Knapsack.Item("A", 3, 60),
            new Knapsack.Item("B", 2, 100),
            new Knapsack.Item("C", 4, 120)
        };
        
        List<Knapsack.Item> result = Knapsack.maxSackValue(items, 7);
        assertNotNull(result);
        assertTrue(result.contains(items[1])); // Item B (highest value)
        assertTrue(result.contains(items[2])); // Item C (fits within weight limit)
    }
}

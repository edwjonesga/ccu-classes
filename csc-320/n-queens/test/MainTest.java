import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class MainTest {

    @Test
    public void testNEquals1() {
        NQueens solver = new NQueens();
        List<List<String>> solutions = solver.solveNQueens(1);
        assertEquals(1, solutions.size());
        assertEquals("Q", solutions.get(0).get(0));
    }

    @Test
    public void testNEquals2() {
        NQueens solver = new NQueens();
        List<List<String>> solutions = solver.solveNQueens(2);
        assertEquals(0, solutions.size());
    }

    @Test
    public void testNEquals3() {
        NQueens solver = new NQueens();
        List<List<String>> solutions = solver.solveNQueens(3);
        assertEquals(0, solutions.size());
    }

    @Test
    public void testNEquals4() {
        NQueens solver = new NQueens();
        List<List<String>> solutions = solver.solveNQueens(4);
        assertEquals(2, solutions.size());

        // Each board must be 4x4 with one 'Q' per row and column
        for (List<String> board : solutions) {
            assertEquals(4, board.size());
            for (String row : board) {
                assertEquals(4, row.length());
                assertEquals(1, row.chars().filter(ch -> ch == 'Q').count());
            }
        }
    }

    @Test
    public void testNEquals5() {
        NQueens solver = new NQueens();
        List<List<String>> solutions = solver.solveNQueens(5);
        assertEquals(10, solutions.size()); // Known result for 5-Queens
    }
}

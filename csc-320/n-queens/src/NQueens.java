
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
;
/** An implementation of NQueens */
public class NQueens {
    /**
     * 
     * @param n number of queens and dimensions of board
     * @return all the solutions
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the board with dots (.)
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(0, board, solutions);
        return solutions;
    }

    /**
     * 
     * @param row
     * @param board
     * @param solutions
     */
    private void backtrack(int row, char[][] board, List<List<String>> solutions) {

        
    }

    private boolean isSafe(char[][] board, int row, int col) {
        boolean isSafe = false;
        return true;
    }

    // helper class for stashing away solutions
    private List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (char[] row : board) {
            // Turn the array of characters into a string
            path.add(new String(row));
        }
        return path;
    }

    // For testing
    public static void main(String[] args) {
        NQueens solver = new NQueens();
        int n = 4;
        List<List<String>> solutions = solver.solveNQueens(n);

        System.out.println("Number of solutions for " + n + "-Queens: " + solutions.size());
        for (List<String> solution : solutions) {
            for (String row : solution)
                System.out.println(row);
            System.out.println();
        }
    }
}

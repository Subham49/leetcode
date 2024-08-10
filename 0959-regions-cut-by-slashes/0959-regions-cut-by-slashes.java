import java.util.*;

public class Solution {
    // Method for Depth-First Search (DFS)
    private void dfs(int i, int j, int[][] mat, boolean[][] vis) {
        vis[i][j] = true; // Mark the cell as visited
        int n = mat.length, m = mat[0].length;
        
        // Directions arrays for up, right, down, left
        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};
        
        for (int k = 0; k < 4; k++) {
            int nrow = i + delr[k], ncol = j + delc[k];
            
            // Check if the new position is within bounds and not visited
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && mat[nrow][ncol] == 0 && !vis[nrow][ncol]) {
                dfs(nrow, ncol, mat, vis); // Recursive DFS call
            }
        }
    }

    // Main function to find the number of regions by slashes
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] mat = new int[n * 3][n * 3]; // Create the 3x size grid
        
        // Construct the matrix based on slashes and backslashes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    mat[i * 3][j * 3 + 2] = 1;
                    mat[i * 3 + 1][j * 3 + 1] = 1;
                    mat[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    mat[i * 3][j * 3] = 1;
                    mat[i * 3 + 1][j * 3 + 1] = 1;
                    mat[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        
        // Count the number of regions (islands of 0s)
        int count = 0;
        boolean[][] vis = new boolean[n * 3][n * 3];
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                if (mat[i][j] == 0 && !vis[i][j]) {
                    count++;
                    dfs(i, j, mat, vis); // Call DFS for the connected region
                }
            }
        }
        return count;
    }
}

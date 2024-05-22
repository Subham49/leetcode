class Solution {
    int fun(int i, int j, int a[][], Integer dp[][])
    {
        if(i>=a.length || j>=a[0].length)
            return 100000000;
        if(i==a.length-1 && j==a[0].length-1)
            return a[i][j];
        if(dp[i][j]!=null)
            return dp[i][j];
        int right = fun(i, j+1, a, dp);
        int down = fun(i+1, j, a, dp);
        return dp[i][j] = a[i][j] + Math.min(right, down);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer dp[][] = new Integer[m][n];
        return fun(0, 0, grid, dp);
    }
}
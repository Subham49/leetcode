class Solution {
    int fun(int i, int j, int a[][], Integer dp[][])
    {
        if(i>=a.length || j>=a[0].length || a[i][j]==1)
            return 0;
        if(i==a.length-1 && j==a[0].length-1)
            return 1;
        if(dp[i][j]!=null)
            return dp[i][j];
        int right = fun(i, j+1, a, dp);
        int down = fun(i+1, j, a, dp);
        return dp[i][j] = right+down;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Integer dp[][] = new Integer[m+1][n+1];
        return fun(0, 0, obstacleGrid, dp);
    }
}
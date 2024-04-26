class Solution {
    Integer dp[][];
    int fun(int i, int j, int a[][])
    {
        if(j<0 || j == a[0].length)
            return 100000000;
        if(i == a.length-1)
            return a[i][j];
        if(dp[i][j]!=null)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=0; k<a[0].length; k++)
        {
            if(j == k) continue;
            ans = Math.min(ans, fun(i+1, k, a));
        }
        return dp[i][j] = a[i][j] + ans;
    }
    public int minFallingPathSum(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        dp = new Integer[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++)
        {
            ans = Math.min(ans, fun(0, i, grid));
        }
        return ans;
    }
}
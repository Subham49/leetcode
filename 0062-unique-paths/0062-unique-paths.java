class Solution {
    int fun(int i, int j, int m, int n, Integer dp[][])
    {
        if(i>m || j>n)
            return 0;
        if(i==m && j==n)
            return 1;
        if(dp[i][j]!=null)
            return dp[i][j];

        int right = fun(i, j+1, m, n, dp);
        int down = fun(i+1, j, m, n, dp);
        return dp[i][j] = right+down;
    }
    public int uniquePaths(int m, int n) {
        Integer dp[][] = new Integer[m+1][n+1];
        return fun(1,1,m,n, dp);
    }
}
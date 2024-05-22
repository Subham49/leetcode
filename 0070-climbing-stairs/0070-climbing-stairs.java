class Solution {
    Integer dp[] = new Integer[46];
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        if(dp[n]!=null)
            return dp[n];
        return dp[n] = climbStairs(n-1)+climbStairs(n-2);
    }
}
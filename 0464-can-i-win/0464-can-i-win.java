class Solution {
    Boolean dp[];
    boolean fun(int max, int sum, int mask)
    {
        if(sum <= 0) return false;
        if(dp[mask] != null) return dp[mask];

        for(int i=0; i<max; i++)
        {
            if((mask & (1<<i)) == 0 && !fun(max, sum-(i+1), (mask | (1<<i))))
            {
                return dp[mask] = true;
            }
        }
        return dp[mask] = false;
    }
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        dp = new Boolean[1<<20];
        if(desiredTotal == 0) return true;
        int sum = (maxChoosableInteger*(maxChoosableInteger+1))/2;
        if(sum < desiredTotal) return false;
        if(sum == desiredTotal) return maxChoosableInteger%2 == 1;
        return fun(maxChoosableInteger, desiredTotal, 0);
    }
}
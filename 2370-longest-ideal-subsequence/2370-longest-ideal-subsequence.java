class Solution {
    Integer dp[][];
    int fun(int ind, char prev, String s, int k)
    {
        if(ind == s.length()) return 0;
        if(dp[ind][prev] != null) return dp[ind][prev];
        int le = 0, nale = 0;
        if(prev == '$' || Math.abs(s.charAt(ind) - prev) <= k)
            le = 1 + fun(ind+1, s.charAt(ind), s, k);
        nale = fun(ind+1, prev, s, k);
        return dp[ind][prev] = Math.max(le, nale);
        
    }
    public int longestIdealString(String s, int k) {
        dp = new Integer[s.length()][130];
        return fun(0, '$', s, k);
    }
}
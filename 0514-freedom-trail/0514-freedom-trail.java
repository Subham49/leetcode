class Solution {
    Integer dp[][];
    int fun(int ri, int ki, String r, String k)
    {
        if(ki == k.length()) return 0;
        
        if(dp[ri][ki] != null) return dp[ri][ki];
        
        int ans = Integer.MAX_VALUE;
        
        for(int i=0; i<r.length(); i++)
        {
            if(r.charAt(i) == k.charAt(ki)){
                int count = Math.min(Math.abs(ri-i), r.length() - Math.abs(ri-i));
                ans = Math.min(ans, count + fun(i, ki+1, r, k));
            }
        }
        return dp[ri][ki] = ans;
    }
    public int findRotateSteps(String ring, String key) {
        dp = new Integer[ring.length()][key.length()];
        return key.length() + fun(0, 0, ring, key);
    }
    
}
class Solution {
    Integer dp[][][];
    int check(String str, int s, int e)
    {
        if(s>e) return 10000000;
        int ans = 0;
        while(s <= e){
            if(str.charAt(s)!=str.charAt(e)) ans++;
            s++;
            e--;
        }
        return ans;
    }
    int fun(int start, int end, int k, String s)
    {
        if(start > end){
            if(k <= 0) return 0;
            return 99999;
        }
        if(end-start+1 == k){
            return 0;
        }
        if(end-start+1 < k){
            return 99999;
        }
        if(k == 1){
            return dp[start][end][k] = check(s, start, end);
        }
        if(dp[start][end][k] != null) return dp[start][end][k];
        
        int ans = 99999;
        for(int i=start; i<=end; i++)
        {
            int l = fun(start, i, 1, s);
            int r = fun(i+1, end, k-1, s);
            ans = Math.min(ans, l+r);
        }
        return dp[start][end][k] = ans;
    }
    public int palindromePartition(String s, int k) {
        dp = new Integer[s.length()][s.length()][k+1];
        return fun(0, s.length()-1, k, s);
    }
}
class Solution {
    int n;
    Integer dp[][];
    void genSubsequence(int ind, int jobs[], int mask, ArrayList<int[]> list, int time)
    {
        if(ind == jobs.length){
            list.add(new int[]{mask, time});
            return;
        }
        genSubsequence(ind+1, jobs, mask, list, time);

        if((mask & (1<<ind)) == 0)
            genSubsequence(ind+1, jobs, mask | (1<<ind), list, time + jobs[ind]);
    }
    int fun(int ind, int jobs[], int mask, int k)
    {
        if(mask == (1<<n)-1) return 0;
        if(ind == k) return 100000000;
        if(dp[ind][mask] != null) return dp[ind][mask];

        ArrayList<int[]> list = new ArrayList<>();
        genSubsequence(0, jobs, mask, list, 0);
        int ans = 100000000;
        for(int[] com : list)
        {
            ans = Math.min(ans, Math.max(com[1], fun(ind+1, jobs, com[0], k)));
        }
        return dp[ind][mask] = ans;
    }
    public int minimumTimeRequired(int[] jobs, int k) {
        n = jobs.length;
        dp = new Integer[n][(1<<n)-1];
        return fun(0, jobs, 0, k);
    }
}
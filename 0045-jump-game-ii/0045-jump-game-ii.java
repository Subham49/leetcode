class Solution {
    int fun(int a[], int ind, Integer dp[])
    {
        if(ind>=a.length)
            return 100000000;
        if(ind == a.length-1)
            return 0;
        if(dp[ind]!=null)
            return dp[ind];
        int ans = 100000000;
        for(int i=1; i<=a[ind]; i++)
        {
            int temp = 1 + fun(a, ind+i, dp);
            ans = Math.min(ans, temp);
        }
        return dp[ind] = ans;
    }
    public int jump(int[] nums) {
        Integer dp[] = new Integer[nums.length];
        return fun(nums, 0, dp);
    }
}
class Solution {
    boolean vis[];
    boolean fun(int ind, int[] nums, int currSum, int sum, int k)
    {
        if(k == 0) return true;
        if(currSum == sum) return fun(0, nums, 0, sum, k-1);

        for(int i=ind; i<nums.length; i++)
        {
            if(vis[i] || currSum+nums[i] > sum)
                continue;

            vis[i] = true;
            if(fun(i + 1, nums, currSum + nums[i], sum, k))
                return true;
            vis[i] = false;
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i : nums)
        {
            sum += i;
        }
        if(sum % k != 0) return false;
        sum = sum/k;
        vis = new boolean[nums.length];
        return fun(0, nums, 0, sum, k);
    }
}
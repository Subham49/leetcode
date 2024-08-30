class Solution {
    Integer dp[][];
    int fun(int[] nums1, int[] nums2, int ind, int swapped)
    {
        if(ind == nums1.length) return 0;

        if(dp[ind][swapped] != null) return dp[ind][swapped];

        int prev1 = ind == 0 ? -1 : nums1[ind-1];
        int prev2 = ind == 0 ? -1 : nums2[ind-1];

        if(swapped == 1)
        {
            int t = prev1;
            prev1 = prev2;
            prev2 = t;
        }
        int ans = 10000000;
        if(nums1[ind] > prev1 && nums2[ind] > prev2)
            ans = fun(nums1, nums2, ind+1, 0);

        if(nums1[ind] > prev2 && nums2[ind] > prev1)
            ans = Math.min(ans, 1 + fun(nums1, nums2, ind+1, 1));

        return dp[ind][swapped] = ans;

    }
    public int minSwap(int[] nums1, int[] nums2) {
        dp = new Integer[nums1.length][2];
        return fun(nums1, nums2, 0, 0);
    }
}
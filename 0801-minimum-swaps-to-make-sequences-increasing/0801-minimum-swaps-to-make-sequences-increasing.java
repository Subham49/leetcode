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

    int tab(int[] nums1, int nums2[])
    {
        int dp[][] = new int[nums1.length+1][2];
        for(int ind=nums1.length-1; ind>=0; ind--)
        {
            for(int swapped=1; swapped>=0; swapped--)
            {
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
                    ans = dp[ind+1][0];

                if(nums1[ind] > prev2 && nums2[ind] > prev1)
                    ans = Math.min(ans, 1 + dp[ind+1][1]);

                dp[ind][swapped] = ans;
            }
        }
        return dp[0][0];
    }

    int space(int[] nums1, int[] nums2)
    {
        int dp0 = 0;
        int dp1 = 0;
        for(int ind=nums1.length-1; ind>=0; ind--)
        {
            int currswap = 0;
            int currnoswap = 0;
            for(int swapped=1; swapped>=0; swapped--)
            {
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
                    ans = dp0;

                if(nums1[ind] > prev2 && nums2[ind] > prev1)
                    ans = Math.min(ans, 1 + dp1);

                if(swapped == 0) currswap = ans;
                else currnoswap = ans; 
            }
            dp0 = currswap;
            dp1 = currnoswap;
        }
        return Math.min(dp0, dp1);
    }

    public int minSwap(int[] nums1, int[] nums2) {
        dp = new Integer[nums1.length][2];
        // return fun(nums1, nums2, 0, 0);
        // return tab(nums1, nums2);
        return space(nums1, nums2);
    }
}
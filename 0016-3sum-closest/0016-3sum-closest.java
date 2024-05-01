class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        int prev = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++)
        {
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int lo = i+1;
            int hi = nums.length-1;
            while(lo<hi)
            {
                if(Math.abs(nums[i]+nums[lo]+nums[hi]-target)<prev)
                {
                    prev = Math.abs(nums[i]+nums[lo]+nums[hi]-target);
                    ans = nums[i]+nums[lo]+nums[hi];
                }
                else if(nums[i]+nums[lo]+nums[hi]<target)
                    lo++;
                else 
                    hi--;
            }
        }
        return ans;
    }
}
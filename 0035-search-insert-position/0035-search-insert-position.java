class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo=0, hi=nums.length-1, mid;
        while(lo<=hi)
        {
            mid=(lo+hi)/2;
            if(target>nums[mid])
                lo=mid+1;
            else if(target<nums[mid])
                hi=mid-1;
            else
                return mid;
        }
        return hi+1;
    }
}
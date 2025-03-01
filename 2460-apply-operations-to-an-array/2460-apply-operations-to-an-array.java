class Solution {
    public int[] applyOperations(int[] nums) {
        int ind = 0;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                nums[i] = 2*nums[i];
                nums[i+1] = 0;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) continue;
            nums[ind++] = nums[i];
        }
        while(ind < nums.length) nums[ind++] = 0;
        return nums;
    }
}
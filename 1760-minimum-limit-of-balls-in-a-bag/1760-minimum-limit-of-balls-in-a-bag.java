class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int h = 0;
        for(int i : nums) h = Math.max(h, i);
        while(l<h) {
            int m = (l+h)/2;
            int op = 0;
            for(int i=0; i<nums.length; i++) {
                op += (nums[i]-1)/m;
            }
            if(op <= maxOperations) h = m;
            else l = m+1;
        }
        return h;
    }
}
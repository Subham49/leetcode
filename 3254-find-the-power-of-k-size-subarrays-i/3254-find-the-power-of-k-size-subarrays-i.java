class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        for(int i=0; i<=nums.length-k; i++) {
            int last = -1;
            boolean f = true;
            for(int j=i; j<i+k; j++) {
                if(last != -1 && (last>nums[j] || last+1 != nums[j])) {
                    f = false;
                    break;
                }
                last = nums[j];
            }
            ans[i] = f ? last : -1;
        }
        return ans;
    }
}
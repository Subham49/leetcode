class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp;
        for(int i=0; i<(1<<nums.length); i++)
        {
            temp = new ArrayList<>();
            for(int j=nums.length-1; j>=0; j--)
            {
                if((i&(1<<j)) > 0) 
                    temp.add(nums[j]);
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}
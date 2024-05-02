class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();
        long t = (long)target;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int k=j+1, l=n-1;
                while(k<l)
                {
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == t)
                    {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        ans.add(list);
                        k++;
                        l--;
                    }
                    else if(sum<t)
                        k++;
                    else
                        l--;
                }
            }
        }
        return new ArrayList(ans);
    }
}
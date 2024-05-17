class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ans;
        }

        Arrays.sort(nums);
        helper(nums, new ArrayList(), new HashSet());

        return ans;
    }

    private void helper(int[] nums, List<Integer> list, Set<Integer> set) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && set.contains(i - 1) && nums[i] == nums[i - 1]) {
                continue;
            }

            if (!set.contains(i)) {
                list.add(nums[i]);
                set.add(i);
                helper(nums, list, set);
                set.remove(i);
                list.remove(list.size() - 1);
            }
        }
    }
}
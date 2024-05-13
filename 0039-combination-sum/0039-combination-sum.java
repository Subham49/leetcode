class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    void fun(int i, int tar, int[] a, List<Integer> list) {
        if (tar == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (tar < 0 || i == a.length) {
            return;
        }
        list.add(a[i]);
        fun(i, tar - a[i], a, list);
        list.remove(list.size() - 1);
        fun(i + 1, tar, a, list);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        fun(0, target, candidates, new ArrayList<>());
        return ans;
    }
}

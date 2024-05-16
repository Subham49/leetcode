class Solution {
    void fun(int a[], int start, List<List<Integer>> ans) {
        if (start == a.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : a) {
                permutation.add(num);
            }
            ans.add(permutation);
            return;
        }
        for (int i = start; i < a.length; i++) {
            swap(a, start, i);
            fun(a, start + 1, ans);
            swap(a, start, i);
        }
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        fun(nums, 0, ans);
        return ans;
    }
}

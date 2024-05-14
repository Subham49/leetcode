class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        fun(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }

    private void fun(int index, int target, int[] arr, List<Integer> subset, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(subset));
            return;
        }
        for(int i=index; i<arr.length;i++){
            if(i > index && arr[i] == arr[i-1])
                continue;
            if(arr[i] > target)
                break;

            subset.add(arr[i]);
            fun(i + 1, target - arr[i], arr, subset, ans);
            subset.remove(subset.size() - 1);
        }
    }
}
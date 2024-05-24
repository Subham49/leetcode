class Solution {
    List<List<Integer>> fun(int i, int n, int k)
    {
        
        if(k == 0)
        {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            return ans;
        }
        if(i == n+1)
        {
            List<List<Integer>> ans = new ArrayList<>();
            return ans;
        }
        List<List<Integer>> le = fun(i+1, n, k-1);
        for(List<Integer> list : le)
        {
            list.add(0, i);
        }
        List<List<Integer>> nale = fun(i+1, n, k);
        le.addAll(nale);
        return le;
    }
    public List<List<Integer>> combine(int n, int k) {
        return fun(1, n, k);
    }
}
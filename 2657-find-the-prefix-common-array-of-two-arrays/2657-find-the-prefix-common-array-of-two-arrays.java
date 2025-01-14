class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int ans[] = new int[n];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i=0; i<n; i++)
        {
            set1.add(A[i]);
            set2.add(B[i]);
            HashSet<Integer> tmp = new HashSet<>(set1);
            tmp.retainAll(set2);
            ans[i] = tmp.size();
        }
        return ans;
    }
}
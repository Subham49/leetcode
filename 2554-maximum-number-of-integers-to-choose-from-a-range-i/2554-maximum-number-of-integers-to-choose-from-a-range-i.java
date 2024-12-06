class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : banned) set.add(i);
        int sum = 0;
        int ans = 0;
        
        for(int i=1; i<=n && (sum+i)<=maxSum; i++) {
            if(!set.contains(i)) {
                ans++;
                sum += i;
            }
        }
        return ans;
    }
}
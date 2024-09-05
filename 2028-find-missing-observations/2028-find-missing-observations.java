class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int tar = mean*(n + rolls.length) - Arrays.stream(rolls).sum();
        if(tar < n || tar > 6*n) return new int[]{};
        int dis = tar/n;
        int rem = tar%n;
        int ans[] = new int[n];
        Arrays.fill(ans, dis);
        for(int i=0; i<rem; i++)
        {
            ans[i]++;
        }
        return ans;
    }
}
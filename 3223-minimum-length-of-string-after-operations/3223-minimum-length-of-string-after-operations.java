class Solution {
    public int minimumLength(String s) {
        int[] f = new int[26];
        int ans = 0;
        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }
        for (int freq : f) {
            if (freq == 0) continue;
            if (freq % 2 == 0) {
                ans += 2;
            } else {
                ans += 1;
            }
        }
        return ans;
    }
}
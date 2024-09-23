class Solution {
    int fun(String s, int index, Integer dp[], Set<String> dictionary)
    {
        if (index >= s.length()) return 0;
        if (dictionary.contains(s.substring(index, s.length()))) return 0;
        if (dp[index] != null) return dp[index];
        int min = s.length() - index;
        for (int i = index + 1; i <= s.length(); i++) {
            int count = dictionary.contains(s.substring(index, i)) ? 0 : i - index;
            count += fun(s, i, dp, dictionary);
            min = Math.min(min, count);
        }
        dp[index] = min;
        return min;
    }
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (String word : dictionary) set.add(word); 
        Integer[] dp = new Integer[s.length()];
        
        return fun(s, 0, dp, set);
    }
}
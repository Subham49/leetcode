class Solution:
    def __init__(self):
        self.dp = None

    def fun(self, ind, prev, s, k):
        if ind == len(s):
            return 0
        if self.dp[ind][ord(prev)] is not None:
            return self.dp[ind][ord(prev)]
        
        le = 0
        nale = 0
        
        if prev == '$' or abs(ord(s[ind]) - ord(prev)) <= k:
            le = 1 + self.fun(ind + 1, s[ind], s, k)
        nale = self.fun(ind + 1, prev, s, k)
        
        self.dp[ind][ord(prev)] = max(le, nale)
        return self.dp[ind][ord(prev)]

    def longestIdealString(self, s: str, k: int) -> int:
        self.dp = [[None] * 130 for _ in range(len(s))]
        return self.fun(0, '$', s, k)

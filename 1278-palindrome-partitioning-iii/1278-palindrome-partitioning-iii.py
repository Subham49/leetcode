class Solution:
    def __init__(self):
        self.dp = None
        
    def check(self, string, s, e):
        if s>e: return 10000000
        ans = 0
        
        while s <= e:
            if string[s] != string[e]: ans += 1
            s += 1
            e -= 1
        return ans
    
    def fun(self, start, end, k, s):
        if start > end:
            if k <= 0: return 0
            return 99999
        
        if end-start+1 == k:
            return 0
        
        if end-start+1 < k:
            return 99999
        
        if k == 1:
            self.dp[start][end][k] = self.check(s, start, end)
            return self.dp[start][end][k]
        
        if self.dp[start][end][k] != None: return self.dp[start][end][k]
        
        ans = 99999
        for i in range(start, end+1): 
            l = self.fun(start, i, 1, s)
            r = self.fun(i+1, end, k-1, s)
            ans = min(ans, l+r)
        
        self.dp[start][end][k] = ans
        return ans;
    
    def palindromePartition(self, s: str, k: int) -> int:
        self.dp = [[[None] * (k+1) for _ in range(len(s))] for _ in range(len(s))]
        return self.fun(0, len(s)-1, k, s)    
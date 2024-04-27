class Solution:
    def __init__(self):
        self.dp = None
        
    def fun(self, ri, ki, r, k):
        if ki == len(k): return 0
        
        if self.dp[ri][ki] != -1: return self.dp[ri][ki]
        
        ans = 2**31-1
        
        for i in range(len(r)):
            if r[i] == k[ki]:
                count = min(abs(ri-i), len(r) - abs(ri-i))
                ans = min(ans, count + self.fun(i, ki+1, r, k))
            
        
        self.dp[ri][ki] = ans
        return ans
    
    def findRotateSteps(self, ring: str, key: str) -> int:
        self.dp = [[-1]*len(key) for _ in range(len(ring))]
        return len(key) + self.fun(0, 0, ring, key)   
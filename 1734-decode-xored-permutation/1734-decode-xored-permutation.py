class Solution:
    def fun(self, n):
        if n%4 == 1: return 1
        if n%4 == 2: return n+1
        if n%4 == 3: return 0
        return n
    
    def decode(self, encoded: List[int]) -> List[int]:
        n = len(encoded)+1;
        xor = self.fun(n);
        
        temp = 0;
        for i in range(0, n-1, 2):
            temp ^= encoded[i]
        
        last = xor ^ temp
        ans = [0]*n
        ans[n-1] = last
        for i in range(n-2, -1, -1):
            ans[i] = ans[i+1]^encoded[i]
        
        return ans
        
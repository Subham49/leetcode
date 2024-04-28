class Solution:
    def funToCount(self, mid, m, n):
        count = 0
        for i in range(1, m+1):
            count += min(mid//i, n)
        return count
        
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        lo, hi = 1, m*n
        
        while lo < hi:
            mid = (lo + hi)//2
            count = self.funToCount(mid, m, n)
            
            if count >= k: hi = mid
            else: lo = mid+1
        return lo
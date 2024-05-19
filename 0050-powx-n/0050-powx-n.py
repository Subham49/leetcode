class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            n = -n
            x = 1 / x
        
        pow = 1
        
        while n != 0:
            if (n & 1) != 0:
                pow *= x
                
            x *= x
            n >>= 1
        
        return pow

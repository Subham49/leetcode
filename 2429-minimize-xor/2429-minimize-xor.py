class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        n = num2.bit_count()
        p = num1.bit_count()
        if n == p: return num1
        
        n -= p
        x = num1
        c = 1
        while n!=0:
            if n>0 and (x&c) == 0: 
                x |= c
                n -= 1
                
            elif n<0 and (x&c) != 0: 
                x ^= c
                n += 1
                
            c= c << 1

        return x
class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x<0: return False
        n = x
        r = 0
        while x!=0:
            r = r*10 + x%10
            x = x//10
        
        return r == n
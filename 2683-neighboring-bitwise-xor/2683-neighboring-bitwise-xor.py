class Solution:
    def doesValidArrayExist(self, derived: List[int]) -> bool:
        x = 0
        y = 1
        for i in range(len(derived)-1):
            x ^= derived[i]
            y ^= derived[i]
        
        if (x^0) == derived[-1]: return True
        if (y^1) == derived[-1]: return True
        return False
class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        
        def count(n: int) -> int:
            count = 0
            while n>0:
                n = n&(n-1)
                count += 1
            return count
        
        xor = 0
        for i in nums: xor ^= i
        return count(xor^k)
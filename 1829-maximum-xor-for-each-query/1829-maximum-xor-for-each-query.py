class Solution:
    def getMaximumXor(self, nums: List[int], maximumBit: int) -> List[int]:
        ans = [0]*len(nums)
        arr = 0
        for i in nums: arr ^= i
        
        for i in range(len(nums)-1, -1, -1):
            k = 0
            for j in range(maximumBit):
                bit = 1 if (arr & (1<<j)) > 0 else 0 # find the jth bit 
                bit ^= 1 #flid the bit 0 to 1 or 1 to 0
                k |= (bit<<j) #set jth bit to opp of bit
            
            arr ^= nums[i] #remove last no from the array
            ans[len(nums) - i - 1] = k
        return ans
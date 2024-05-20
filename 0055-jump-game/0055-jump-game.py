class Solution:
    def canJump(self, nums: List[int]) -> bool:
        b = 0
        for i in range(len(nums)):
            if i > b:
                return False
            b = max(b, i + nums[i])
            if b >= len(nums) - 1:
                return True
        return False

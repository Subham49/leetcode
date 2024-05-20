class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        sum = 0
        ans = -2**31
        for i in nums:
            sum += i
            ans = max(sum, ans)
            if sum<0:
                sum = 0
        return ans

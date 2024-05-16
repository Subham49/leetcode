class Solution:
    def fun(self, nums, ind, dp):
        if ind >= len(nums): return 1000000
        if ind == len(nums)-1: return 0
        if dp[ind] != -1: return dp[ind]
        ans = 1000000
        for i in range(1, nums[ind]+1):
            t = 1+self.fun(nums, ind+i, dp)
            ans = min(ans, t)

        dp[ind] = ans
        return ans

    def jump(self, nums: List[int]) -> int:
        return self.fun(nums, 0, [-1]*len(nums))
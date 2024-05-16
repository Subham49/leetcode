class Solution:
    def fun(self, ind, nums, ans):
        if ind == len(nums):
            ans.append(nums[:])
            return

        for i in range(ind, len(nums)):
            self.swap(ind, i, nums)
            self.fun(ind+1, nums, ans)
            self.swap(ind, i, nums)

    def swap(self, i, j, nums):
        t = nums[i]
        nums[i] = nums[j]
        nums[j] = t

    def permute(self, nums: List[int]) -> List[List[int]]:
        ans = []
        self.fun(0, nums, ans)
        return ans
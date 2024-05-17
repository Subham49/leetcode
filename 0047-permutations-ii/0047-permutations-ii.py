class Solution:
    def __init__(self):
        self.ans = []

    def permuteUnique(self, nums):
        if not nums:
            return self.ans

        nums.sort()
        self.helper(nums, [], set())
        return self.ans

    def helper(self, nums, path, used):
        if len(path) == len(nums):
            self.ans.append(path[:])
            return

        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i - 1] and (i - 1) in used:
                continue

            if i not in used:
                path.append(nums[i])
                used.add(i)
                self.helper(nums, path, used)
                used.remove(i)
                path.pop()
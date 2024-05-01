class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        prev = 2**31-1
        ans = 2**31-1

        for i in range(len(nums)):

            if i!=0 and nums[i] == nums[i-1]: continue

            lo = i+1
            hi = len(nums)-1

            while lo<hi:
                if abs(nums[i]+nums[lo]+nums[hi]-target) < prev:
                    prev = abs(nums[i]+nums[lo]+nums[hi]-target)
                    ans = nums[i]+nums[lo]+nums[hi]
                elif nums[i]+nums[lo]+nums[hi]<target: lo += 1
                else: hi -= 1

        return ans
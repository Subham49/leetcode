class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        ans = set()
        n = len(nums)
        nums.sort()

        for i in range(n): 
            for j in range(i+1, n): 
                k=j+1
                l=n-1
                while k<l:
                    sum = nums[i] + nums[j] + nums[k] + nums[l]
                    if sum == target:
                        ans.add((nums[i], nums[j], nums[k], nums[l]))
                        k += 1;
                        l -= 1;
                    
                    elif sum<target:
                        k += 1
                    else:
                        l -= 1
        return list(ans)
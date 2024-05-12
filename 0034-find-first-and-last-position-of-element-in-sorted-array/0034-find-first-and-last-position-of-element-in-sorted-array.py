class Solution:
    def searchRange(self, nums, target):
        
        def binary_search(nums, target, find_first):
            lo, hi, result = 0, len(nums) - 1, -1
            while lo <= hi:
                mid = (lo + hi) // 2
                if nums[mid] < target:
                    lo = mid + 1
                elif nums[mid] > target:
                    hi = mid - 1
                else:
                    result = mid
                    if find_first:
                        hi = mid - 1
                    else:
                        lo = mid + 1
            return result
        
        first_occurrence = binary_search(nums, target, True)
        last_occurrence = binary_search(nums, target, False)
        
        return [first_occurrence, last_occurrence]

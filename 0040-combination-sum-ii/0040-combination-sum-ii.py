class Solution:

    def fun(self, index, target, arr, subset, ans):
        if target == 0:
            print(subset)
            ans.append(subset[:])
            return

        for i in range(index, len(arr)): 
            if i > index and arr[i] == arr[i-1]:
                continue
            if arr[i] > target:
                break

            subset.append(arr[i])
            self.fun(i + 1, target - arr[i], arr, subset, ans)
            subset.pop()
        
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        candidates.sort()
        self.fun(0, target, candidates, [], ans)
        return ans
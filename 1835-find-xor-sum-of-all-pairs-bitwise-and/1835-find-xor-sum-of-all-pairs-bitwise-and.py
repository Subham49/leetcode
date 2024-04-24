class Solution:
    def getXORSum(self, arr1: List[int], arr2: List[int]) -> int:
        xorArr2 = 0;
        for i in arr2: xorArr2 ^= i
        xorArr1 = 0
        for j in arr1: xorArr1 ^= j
        return xorArr2 & xorArr1
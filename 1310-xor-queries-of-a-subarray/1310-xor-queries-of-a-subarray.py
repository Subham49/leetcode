class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        n = len(arr)
        xor = [0]*n
        xor[0] = arr[0]
        
        for i in range(1, n):
            xor[i] = xor[i-1]^arr[i]
        
        l = len(queries)
        ans = [0]*l
        
        for i in range(l):
            if queries[i][0] == 0:
                ans[i] = xor[queries[i][1]]
            else:
                ans[i] = xor[queries[i][0]-1] ^ xor[queries[i][1]]
        return ans;
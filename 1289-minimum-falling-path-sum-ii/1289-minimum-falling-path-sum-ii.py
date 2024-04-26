class Solution:
    def __init__(self):
        self.dp = None

    def fun(self, i, j, a):
        if j < 0 or j == len(a[0]):
            return 10**8
        if i == len(a) - 1:
            return a[i][j]
        if self.dp[i][j] is not None:
            return self.dp[i][j]
        
        ans = float('inf')
        for k in range(len(a[0])):
            if j == k:
                continue
            ans = min(ans, self.fun(i + 1, k, a))
        
        self.dp[i][j] = a[i][j] + ans
        return self.dp[i][j]

    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        ans = float('inf')
        self.dp = [[None] * len(grid[0]) for _ in range(len(grid))]
        for i in range(len(grid)):
            ans = min(ans, self.fun(0, i, grid))
        return ans

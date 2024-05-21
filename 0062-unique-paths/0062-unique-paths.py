class Solution:
    def fun(self, i: int, j: int, m: int, n: int, dp: List[List[int]]) -> int:
        if i > m or j > n:
            return 0
        if i == m and j == n:
            return 1
        if dp[i][j] is not None:
            return dp[i][j]

        right = self.fun(i, j + 1, m, n, dp)
        down = self.fun(i + 1, j, m, n, dp)
        dp[i][j] = right + down
        return dp[i][j]

    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[None for _ in range(n + 1)] for _ in range(m + 1)]
        return self.fun(1, 1, m, n, dp)

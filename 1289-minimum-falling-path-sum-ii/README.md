<h2><a href="https://leetcode.com/problems/minimum-falling-path-sum-ii">1289. Minimum Falling Path Sum II</a></h2><h3>Hard</h3><hr><div><p>Given an <code>n x n</code> integer matrix <code>grid</code>, return <em>the minimum sum of a <strong>falling path with non-zero shifts</strong></em>.</p>

<p>A <strong>falling path with non-zero shifts</strong> is a choice of exactly one element from each row of <code>grid</code> such that no two elements chosen in adjacent rows are in the same column.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/10/falling-grid.jpg" style="width: 244px; height: 245px;">
<pre><strong>Input:</strong> grid = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> 13
<strong>Explanation:</strong> 
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is&nbsp;[1,5,7], so the answer is&nbsp;13.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> grid = [[7]]
<strong>Output:</strong> 7
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == grid.length == grid[i].length</code></li>
	<li><code>1 &lt;= n &lt;= 200</code></li>
	<li><code>-99 &lt;= grid[i][j] &lt;= 99</code></li>
</ul>
</div>

## Java

```java
class Solution {
    Integer dp[][];
    int fun(int i, int j, int a[][])
    {
        if(j<0 || j == a[0].length)
            return 100000000;
        if(i == a.length-1)
            return a[i][j];
        if(dp[i][j]!=null)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=0; k<a[0].length; k++)
        {
            if(j == k) continue;
            ans = Math.min(ans, fun(i+1, k, a));
        }
        return dp[i][j] = a[i][j] + ans;
    }
    public int minFallingPathSum(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        dp = new Integer[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++)
        {
            ans = Math.min(ans, fun(0, i, grid));
        }
        return ans;
    }
}
```

## Python

```python
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
```

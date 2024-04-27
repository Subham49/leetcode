<h2><a href="https://leetcode.com/problems/palindrome-partitioning-iii/">1278. Palindrome Partitioning III</a></h2><h3>Hard</h3><hr><div><p>You are given a string <code>s</code> containing lowercase letters and an integer <code>k</code>. You need to :</p>

<ul>
	<li>First, change some characters of <code>s</code> to other lowercase English letters.</li>
	<li>Then divide <code>s</code> into <code>k</code> non-empty disjoint substrings such that each substring is a palindrome.</li>
</ul>

<p>Return <em>the minimal number of characters that you need to change to divide the string</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "abc", k = 2
<strong>Output:</strong> 1
<strong>Explanation:</strong>&nbsp;You can split the string into "ab" and "c", and change 1 character in "ab" to make it palindrome.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "aabbc", k = 3
<strong>Output:</strong> 0
<strong>Explanation:</strong>&nbsp;You can split the string into "aa", "bb" and "c", all of them are palindrome.</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "leetcode", k = 8
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= s.length &lt;= 100</code>.</li>
	<li><code>s</code> only contains lowercase English letters.</li>
</ul>
</div>

## Java

```java
class Solution {
    Integer dp[][][];
    int check(String str, int s, int e)
    {
        if(s>e) return 10000000;
        int ans = 0;
        while(s <= e){
            if(str.charAt(s)!=str.charAt(e)) ans++;
            s++;
            e--;
        }
        return ans;
    }
    int fun(int start, int end, int k, String s)
    {
        if(start > end){
            if(k <= 0) return 0;
            return 99999;
        }
        if(end-start+1 == k){
            return 0;
        }
        if(end-start+1 < k){
            return 99999;
        }
        if(k == 1){
            return dp[start][end][k] = check(s, start, end);
        }
        if(dp[start][end][k] != null) return dp[start][end][k];
        
        int ans = 99999;
        for(int i=start; i<=end; i++)
        {
            int l = fun(start, i, 1, s);
            int r = fun(i+1, end, k-1, s);
            ans = Math.min(ans, l+r);
        }
        return dp[start][end][k] = ans;
    }
    public int palindromePartition(String s, int k) {
        dp = new Integer[s.length()][s.length()][k+1];
        return fun(0, s.length()-1, k, s);
    }
}
```

## Python

```python
class Solution:
    def __init__(self):
        self.dp = None
        
    def check(self, string, s, e):
        if s>e: return 10000000
        ans = 0
        
        while s <= e:
            if string[s] != string[e]: ans += 1
            s += 1
            e -= 1
        return ans
    
    def fun(self, start, end, k, s):
        if start > end:
            if k <= 0: return 0
            return 99999
        
        if end-start+1 == k:
            return 0
        
        if end-start+1 < k:
            return 99999
        
        if k == 1:
            self.dp[start][end][k] = self.check(s, start, end)
            return self.dp[start][end][k]
        
        if self.dp[start][end][k] != None: return self.dp[start][end][k]
        
        ans = 99999
        for i in range(start, end+1): 
            l = self.fun(start, i, 1, s)
            r = self.fun(i+1, end, k-1, s)
            ans = min(ans, l+r)
        
        self.dp[start][end][k] = ans
        return ans;
    
    def palindromePartition(self, s: str, k: int) -> int:
        self.dp = [[[None] * (k+1) for _ in range(len(s))] for _ in range(len(s))]
        return self.fun(0, len(s)-1, k, s)
```

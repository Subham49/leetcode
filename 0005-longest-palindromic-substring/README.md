<h2><a href="https://leetcode.com/problems/longest-palindromic-substring/">5. Longest Palindromic Substring</a></h2><h3>Medium</h3><hr><div><p>Given a string <code>s</code>, return <em>the longest</em> <span data-keyword="palindromic-string"><em>palindromic</em></span> <span data-keyword="substring-nonempty"><em>substring</em></span> in <code>s</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "babad"
<strong>Output:</strong> "bab"
<strong>Explanation:</strong> "aba" is also a valid answer.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "cbbd"
<strong>Output:</strong> "bb"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> consist of only digits and English letters.</li>
</ul>
</div>

## Java
```java
class Solution {
    int[] expand(String s, int i, int j)
    {
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j))
        {
            i--;
            j++;
        }
        return new int[]{i+1, j-1};
    }
    public String longestPalindrome(String s) {
        int[] ans = new int[]{0,0};
        for(int i=0; i<s.length(); i++)
        {
            int[] temp = expand(s, i, i);
            if(temp[1]-temp[0]+1>ans[1]-ans[0]+1) ans = temp;

            temp = expand(s, i, i+1);
            if(temp[1]-temp[0]+1>ans[1]-ans[0]+1) ans = temp;
        }
        return s.substring(ans[0], ans[1]+1);
    }
}
```

## Python
```python
class Solution:
    def expand(self, s, i, j):
        while i>=0 and j<len(s) and s[i] == s[j]:
            i-=1
            j+=1
        return [i+1, j-1]
    
    def longestPalindrome(self, s: str) -> str:
        ans = [0,0]
        for i in range(len(s)): 
            temp = self.expand(s, i, i)
            if temp[1]-temp[0]+1>ans[1]-ans[0]+1: ans = temp

            temp = self.expand(s, i, i+1)
            if temp[1]-temp[0]+1>ans[1]-ans[0]+1: ans = temp
                
        return s[ans[0]: ans[1]+1]
```

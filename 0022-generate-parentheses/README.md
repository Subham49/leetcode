<h2><a href="https://leetcode.com/problems/generate-parentheses/">22. Generate Parentheses</a></h2><h3>Medium</h3><hr><p>Given <code>n</code> pairs of parentheses, write a function to <em>generate all combinations of well-formed parentheses</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> ["((()))","(()())","(())()","()(())","()()()"]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> ["()"]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 8</code></li>
</ul>

## Java
```java
class Solution {
    void fun(int n, List<String> ans, String s, int c, int o)
    {
        if(s.length() == 2*n)
        {
            ans.add(s);
            return;
        }
        if(o<n)
        {
            fun(n, ans, s+'(', c, o+1);
        }
        if(c<o)
        {
            fun(n, ans, s+')', c+1, o);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        fun(n, list, "", 0, 0);
        return list;
    }
}
```

## Python
```python
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []

        def fun(string, open, close, n):
            if len(string) == 2*n:
                ans.append(string)
                return
            
            if(open < n): fun(string+"(", open+1, close, n)
            if(open > close): fun(string+")", open, close+1, n)

        fun("", 0, 0, n)
        return ans
```

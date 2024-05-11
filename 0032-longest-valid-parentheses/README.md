<h2><a href="https://leetcode.com/problems/longest-valid-parentheses/">32. Longest Valid Parentheses</a></h2><h3>Hard</h3><hr><p>Given a string containing just the characters <code>&#39;(&#39;</code> and <code>&#39;)&#39;</code>, return <em>the length of the longest valid (well-formed) parentheses </em><span data-keyword="substring-nonempty"><em>substring</em></span>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;(()&quot;
<strong>Output:</strong> 2
<strong>Explanation:</strong> The longest valid parentheses substring is &quot;()&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;)()())&quot;
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest valid parentheses substring is &quot;()()&quot;.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;&quot;
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>s[i]</code> is <code>&#39;(&#39;</code>, or <code>&#39;)&#39;</code>.</li>
</ul>

## Java
```java
class Solution {
    int stackApproach(String s)
    {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        stack.push(-1);

        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(') stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                ans = Math.max(ans, i-stack.peek());
            }
        }
        return ans;
    }
    int withoutStackApproach(String s)
    {
        int o = 0;
        int c = 0;
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') o++;
            else c++;

            if(o == c)
            {
                ans = Math.max(ans, o+c);
            }
            else if(c>o){
                o = c = 0;
            }
        }

        o = c = 0;
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch == '(') o++;
            else c++;
            
            if(o == c)
            {
                ans = Math.max(ans, o+c);
            }
            else if(c<o){
                o = c = 0;
            }
        }
        return ans;
    }
    public int longestValidParentheses(String s) {
        return withoutStackApproach(s);
    }
}
```

## Python
```python
class Solution:
    def stackApproach(self, s: str) -> int:
        stack = [-1]
        ans = 0

        for i in range(len(s)):
            ch = s[i]
            if ch == '(':
                stack.append(i)
            else:
                stack.pop()
                if not stack:
                    stack.append(i)
                ans = max(ans, i - stack[-1])

        return ans

    def withoutStackApproach(self, s: str) -> int:
        o, c = 0, 0
        ans = 0
        for i in range(len(s)):
            ch = s[i]
            if ch == '(':
                o += 1
            else:
                c += 1

            if o == c:
                ans = max(ans, o + c)
            elif c > o:
                o = c = 0

        o = c = 0
        for i in range(len(s) - 1, -1, -1):
            ch = s[i]
            if ch == '(':
                o += 1
            else:
                c += 1

            if o == c:
                ans = max(ans, o + c)
            elif c < o:
                o = c = 0

        return ans

    def longestValidParentheses(self, s: str) -> int:
        return self.stackApproach(s)
```

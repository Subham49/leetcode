<h2><a href="https://leetcode.com/problems/valid-parentheses/">20. Valid Parentheses</a></h2><h3>Easy</h3><hr><p>Given a string <code>s</code> containing just the characters <code>&#39;(&#39;</code>, <code>&#39;)&#39;</code>, <code>&#39;{&#39;</code>, <code>&#39;}&#39;</code>, <code>&#39;[&#39;</code> and <code>&#39;]&#39;</code>, determine if the input string is valid.</p>

<p>An input string is valid if:</p>

<ol>
	<li>Open brackets must be closed by the same type of brackets.</li>
	<li>Open brackets must be closed in the correct order.</li>
	<li>Every close bracket has a corresponding open bracket of the same type.</li>
</ol>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;()&quot;
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;()[]{}&quot;
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;(]&quot;
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of parentheses only <code>&#39;()[]{}&#39;</code>.</li>
</ul>

## Java
```java
class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray())
        {
            if("({[".indexOf(ch) != -1) stack.push(ch);
            else{
                if(stack.isEmpty()) return false;
                if(
                    !(stack.peek() == '(' && ch == ')') && 
                    !(stack.peek() == '[' && ch == ']') && 
                    !(stack.peek() == '{' && ch == '}')
                )
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
```

## Python
```python
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        for i in s:
            if i in "({[": stack.append(i)
            else:
                if not stack: return False
                if (stack[-1] == '(' and i == ')') or \
                (stack[-1] == '[' and i == ']') or \
                (stack[-1] == '{' and i == '}'):
                    stack.pop()
                else: return False
        
        return not stack
```

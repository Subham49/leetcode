<h2><a href="https://leetcode.com/problems/n-th-tribonacci-number/">1137. N-th Tribonacci Number</a></h2><h3>Easy</h3><hr><div><p>The Tribonacci sequence T<sub>n</sub> is defined as follows:&nbsp;</p>

<p>T<sub>0</sub> = 0, T<sub>1</sub> = 1, T<sub>2</sub> = 1, and T<sub>n+3</sub> = T<sub>n</sub> + T<sub>n+1</sub> + T<sub>n+2</sub> for n &gt;= 0.</p>

<p>Given <code>n</code>, return the value of T<sub>n</sub>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 4
<strong>Output:</strong> 4
<strong>Explanation:</strong>
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 25
<strong>Output:</strong> 1389537
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 37</code></li>
	<li>The answer is guaranteed to fit within a 32-bit integer, ie. <code>answer &lt;= 2^31 - 1</code>.</li>
</ul></div>

## Java

```java
class Solution {
    public int tribonacci(int n) {
        if(n == 0)  return 0;
        if(n == 1 || n == 2)  return 1;
        int a = 0, b=1, c=1;
        for(int i=3; i<=n; i++)
        {
            int d = a+b+c;
            a=b;
            b=c;
            c=d;
        }
        return c;
    }
}
```

## Python

```python
class Solution:
    def tribonacci(self, n: int) -> int:
        if n == 0:  return 0
        if n == 1 or n == 2:  return 1
        a = 0 
        b=1
        c=1
        for i in range(3, n+1): 
            d = a+b+c
            a=b
            b=c
            c=d
        
        return c
```


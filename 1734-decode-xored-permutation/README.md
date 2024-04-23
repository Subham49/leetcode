<h2><a href="https://leetcode.com/problems/decode-xored-permutation/">1734. Decode XORed Permutation</a></h2><h3>Medium</h3><hr><div><p>There is an integer array <code>perm</code> that is a permutation of the first <code>n</code> positive integers, where <code>n</code> is always <strong>odd</strong>.</p>

<p>It was encoded into another integer array <code>encoded</code> of length <code>n - 1</code>, such that <code>encoded[i] = perm[i] XOR perm[i + 1]</code>. For example, if <code>perm = [1,3,2]</code>, then <code>encoded = [2,1]</code>.</p>

<p>Given the <code>encoded</code> array, return <em>the original array</em> <code>perm</code>. It is guaranteed that the answer exists and is unique.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> encoded = [3,1]
<strong>Output:</strong> [1,2,3]
<strong>Explanation:</strong> If perm = [1,2,3], then encoded = [1 XOR 2,2 XOR 3] = [3,1]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> encoded = [6,5,4,6]
<strong>Output:</strong> [2,4,1,5,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= n &lt;&nbsp;10<sup>5</sup></code></li>
	<li><code>n</code>&nbsp;is odd.</li>
	<li><code>encoded.length == n - 1</code></li>
</ul>
</div>

## Java
```java
class Solution {
    int fun(int n)
    {
        if(n%4 == 1) return 1;
        if(n%4 == 2) return n+1;
        if(n%4 == 3) return 0;
        return n;
    }
    
    public int[] decode(int[] encoded) {
        int n = encoded.length+1;
        int xor = fun(n);
        
        int temp = 0;
        for(int i=0; i<n-1; i+=2)
        {
            temp ^= encoded[i];
        }
        int last = xor ^ temp;
        int ans[] = new int[n];
        ans[n-1] = last;
        for(int i=n-2; i>=0; i--)
        {
            ans[i] = ans[i+1]^encoded[i];
        }
        return ans;
    }
}
```

## Python
```python
class Solution:
    def fun(self, n):
        if n%4 == 1: return 1
        if n%4 == 2: return n+1
        if n%4 == 3: return 0
        return n
    
    def decode(self, encoded: List[int]) -> List[int]:
        n = len(encoded)+1;
        xor = self.fun(n);
        
        temp = 0;
        for i in range(0, n-1, 2):
            temp ^= encoded[i]
        
        last = xor ^ temp
        ans = [0]*n
        ans[n-1] = last
        for i in range(n-2, -1, -1):
            ans[i] = ans[i+1]^encoded[i]
        
        return ans
```

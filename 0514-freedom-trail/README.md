<h2><a href="https://leetcode.com/problems/freedom-trail/">514. Freedom Trail</a></h2><h3>Hard</h3><hr><div><p>In the video game Fallout 4, the quest <strong>"Road to Freedom"</strong> requires players to reach a metal dial called the <strong>"Freedom Trail Ring"</strong> and use the dial to spell a specific keyword to open the door.</p>

<p>Given a string <code>ring</code> that represents the code engraved on the outer ring and another string <code>key</code> that represents the keyword that needs to be spelled, return <em>the minimum number of steps to spell all the characters in the keyword</em>.</p>

<p>Initially, the first character of the ring is aligned at the <code>"12:00"</code> direction. You should spell all the characters in <code>key</code> one by one by rotating <code>ring</code> clockwise or anticlockwise to make each character of the string key aligned at the <code>"12:00"</code> direction and then by pressing the center button.</p>

<p>At the stage of rotating the ring to spell the key character <code>key[i]</code>:</p>

<ol>
	<li>You can rotate the ring clockwise or anticlockwise by one place, which counts as <strong>one step</strong>. The final purpose of the rotation is to align one of <code>ring</code>'s characters at the <code>"12:00"</code> direction, where this character must equal <code>key[i]</code>.</li>
	<li>If the character <code>key[i]</code> has been aligned at the <code>"12:00"</code> direction, press the center button to spell, which also counts as <strong>one step</strong>. After the pressing, you could begin to spell the next character in the key (next stage). Otherwise, you have finished all the spelling.</li>
</ol>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img src="https://assets.leetcode.com/uploads/2018/10/22/ring.jpg" style="width: 450px; height: 450px;">
<pre><strong>Input:</strong> ring = "godding", key = "gd"
<strong>Output:</strong> 4
<strong>Explanation:</strong>
For the first key character 'g', since it is already in place, we just need 1 step to spell this character. 
For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make it become "ddinggo".
Also, we need 1 more step for spelling.
So the final output is 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> ring = "godding", key = "godding"
<strong>Output:</strong> 13
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= ring.length, key.length &lt;= 100</code></li>
	<li><code>ring</code> and <code>key</code> consist of only lower case English letters.</li>
	<li>It is guaranteed that <code>key</code> could always be spelled by rotating <code>ring</code>.</li>
</ul>
</div>

## Java

```java
class Solution {
    Integer dp[][];
    int fun(int ri, int ki, String r, String k)
    {
        if(ki == k.length()) return 0;
        
        if(dp[ri][ki] != null) return dp[ri][ki];
        
        int ans = Integer.MAX_VALUE;
        
        for(int i=0; i<r.length(); i++)
        {
            if(r.charAt(i) == k.charAt(ki)){
                int count = Math.min(Math.abs(ri-i), r.length() - Math.abs(ri-i));
                ans = Math.min(ans, count + fun(i, ki+1, r, k));
            }
        }
        return dp[ri][ki] = ans;
    }
    public int findRotateSteps(String ring, String key) {
        dp = new Integer[ring.length()][key.length()];
        return key.length() + fun(0, 0, ring, key);
    }
    
}
```

## Python

```python
class Solution:
    def __init__(self):
        self.dp = None
        
    def fun(self, ri, ki, r, k):
        if ki == len(k): return 0
        
        if self.dp[ri][ki] != -1: return self.dp[ri][ki]
        
        ans = 2**31-1
        
        for i in range(len(r)):
            if r[i] == k[ki]:
                count = min(abs(ri-i), len(r) - abs(ri-i))
                ans = min(ans, count + self.fun(i, ki+1, r, k))
            
        
        self.dp[ri][ki] = ans
        return ans
    
    def findRotateSteps(self, ring: str, key: str) -> int:
        self.dp = [[-1]*len(key) for _ in range(len(ring))]
        return len(key) + self.fun(0, 0, ring, key)
```

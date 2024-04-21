<h2><a href="https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/">421. Maximum XOR of Two Numbers in an Array</a></h2><h3>Medium</h3><hr><div><p>Given an integer array <code>nums</code>, return <em>the maximum result of </em><code>nums[i] XOR nums[j]</code>, where <code>0 &lt;= i &lt;= j &lt; n</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [3,10,5,25,2,8]
<strong>Output:</strong> 28
<strong>Explanation:</strong> The maximum result is 5 XOR 25 = 28.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [14,70,53,83,49,91,36,80,92,51,66,70]
<strong>Output:</strong> 127
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div>

## Java
```java
class TrieNode{
    TrieNode[] children;

    TrieNode()
    {
        children = new TrieNode[2];
    }
}

class Solution {
    TrieNode root;
    
    public Solution() 
    {
        root = new TrieNode();
    }
    
    public int findMaximumXOR(int[] nums) {
        
        for(int num : nums)
        {
            TrieNode curr = root;
            for(int i=31; i>=0; i--)
            {
                int bit = (num&(1<<i))>0?1:0;
                
                if(curr.children[bit] == null)
                {
                    curr.children[bit] = new TrieNode();
                }
                curr = curr.children[bit];
            }
        }
        
        int ans = 0;
        
        for(int num : nums)
        {
            TrieNode curr = root;
            int temp = 0;
            for(int i=31; i>=0; i--)
            {
                int bit = (num&(1<<i))>0?0:1;
                
                if(curr.children[bit] == null)
                {
                    bit = bit == 0?1:0;
                }
                temp = temp<<1 | bit;
                curr = curr.children[bit];
            }
            ans = Math.max(ans, num ^ temp);
        }
        return ans;
    }
}
```

<h2><a href="https://leetcode.com/problems/maximum-xor-with-an-element-from-array/">1707. Maximum XOR With an Element From Array</a></h2><h3>Hard</h3><hr><div><p>You are given an array <code>nums</code> consisting of non-negative integers. You are also given a <code>queries</code> array, where <code>queries[i] = [x<sub>i</sub>, m<sub>i</sub>]</code>.</p>

<p>The answer to the <code>i<sup>th</sup></code> query is the maximum bitwise <code>XOR</code> value of <code>x<sub>i</sub></code> and any element of <code>nums</code> that does not exceed <code>m<sub>i</sub></code>. In other words, the answer is <code>max(nums[j] XOR x<sub>i</sub>)</code> for all <code>j</code> such that <code>nums[j] &lt;= m<sub>i</sub></code>. If all elements in <code>nums</code> are larger than <code>m<sub>i</sub></code>, then the answer is <code>-1</code>.</p>

<p>Return <em>an integer array </em><code>answer</code><em> where </em><code>answer.length == queries.length</code><em> and </em><code>answer[i]</code><em> is the answer to the </em><code>i<sup>th</sup></code><em> query.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
<strong>Output:</strong> [3,3,7]
<strong>Explanation:</strong>
1) 0 and 1 are the only two integers not greater than 1. 0 XOR 3 = 3 and 1 XOR 3 = 2. The larger of the two is 3.
2) 1 XOR 2 = 3.
3) 5 XOR 2 = 7.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
<strong>Output:</strong> [15,-1,5]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length, queries.length &lt;= 10<sup>5</sup></code></li>
	<li><code>queries[i].length == 2</code></li>
	<li><code>0 &lt;= nums[j], x<sub>i</sub>, m<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
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
    TrieNode root = new TrieNode();
    
    void insert(int n)
    {
        TrieNode curr = root;
        
        for(int i=31; i>=0; i--)
        {
            int bit = (n>>i)&1;
            if(curr.children[bit] == null)
            {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
        }
    }
    
    int fun(int n)
    {
        TrieNode curr = root;
        int ans = 0;
        for(int i=31; i>=0; i--)
        {
            int bit = (n>>i)&1;
            if(curr.children[bit^1] != null)
            {
                ans = ans | 1<<i;
                curr = curr.children[bit^1];
            }else if(curr.children[bit] != null)
                curr = curr.children[bit];
            else return -1;
            
        }
        return ans;
    }
    
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        
        int ans[] = new int[queries.length];
        
        Arrays.sort(nums);
        int temp[][] = new int[queries.length][3];
        
        int i = 0;
        for(int q[] : queries){
            temp[i][0] = q[0];
            temp[i][1] = q[1];
            temp[i][2] = i++;
        }
        
        Arrays.sort(temp, (a, b)->a[1]-b[1]);
        
        i = 0;
        for(int q[] : temp)
        {
            while(i < n && nums[i]<=q[1]) insert(nums[i++]);
            ans[q[2]] = fun(q[0]);
        }
        return ans;
    }
}
```

## Python

```python
class TrieNode:
    def __init__(self):
        self.children = [None, None]
        
class Solution:
    
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, n):
        curr = self.root
        
        for i in range(31,-1,-1):
            bit = (n>>i)&1
            if curr.children[bit] == None: curr.children[bit] = TrieNode()
            curr = curr.children[bit]
    
    def fun(self, n):
        curr = self.root
        ans = 0
        for i in range(31,-1,-1):
            bit = (n>>i)&1
            
            if curr.children[bit^1] != None:
                ans = ans | 1<<i
                curr = curr.children[bit^1]
            elif curr.children[bit] != None:
                curr = curr.children[bit]
            else: return -1
            
        return ans
    
    def maximizeXor(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        n = len(nums)
        q = len(queries)
        
        ans = [0]*q
        
        nums.sort()
        
        temp = [[0] * 3 for _ in range(q)]
        
        i = 0
        for q in queries:
            temp[i][0] = q[0]
            temp[i][1] = q[1]
            temp[i][2] = i
            i += 1
        
        temp.sort(key=lambda x: x[1])
        
        i = 0
        for q in temp:
            while i < n and nums[i]<=q[1]: 
                self.insert(nums[i])
                i+=1
                
            ans[q[2]] = self.fun(q[0])
        return ans
```

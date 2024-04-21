<h2><a href="https://leetcode.com/problems/xor-queries-of-a-subarray/">1310. XOR Queries of a Subarray</a></h2><h3>Medium</h3><hr><div><p>You are given an array <code>arr</code> of positive integers. You are also given the array <code>queries</code> where <code>queries[i] = [left<sub>i, </sub>right<sub>i</sub>]</code>.</p>

<p>For each query <code>i</code> compute the <strong>XOR</strong> of elements from <code>left<sub>i</sub></code> to <code>right<sub>i</sub></code> (that is, <code>arr[left<sub>i</sub>] XOR arr[left<sub>i</sub> + 1] XOR ... XOR arr[right<sub>i</sub>]</code> ).</p>

<p>Return an array <code>answer</code> where <code>answer[i]</code> is the answer to the <code>i<sup>th</sup></code> query.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
<strong>Output:</strong> [2,7,14,8] 
<strong>Explanation:</strong> 
The binary representation of the elements in the array are:
1 = 0001 
3 = 0011 
4 = 0100 
8 = 1000 
The XOR values for queries are:
[0,1] = 1 xor 3 = 2 
[1,2] = 3 xor 4 = 7 
[0,3] = 1 xor 3 xor 4 xor 8 = 14 
[3,3] = 8
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
<strong>Output:</strong> [8,0,4,4]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length, queries.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>queries[i].length == 2</code></li>
	<li><code>0 &lt;= left<sub>i</sub> &lt;= right<sub>i</sub> &lt; arr.length</code></li>
</ul>
</div>

## Java
```java
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int xor[] = new int[arr.length];
        xor[0] = arr[0];
        for(int i=1; i<arr.length; i++)
        {
            xor[i] = xor[i-1]^arr[i];
        }
        
        int ans[] = new int[queries.length];
        for(int i=0; i<queries.length; i++)
        {
            if(queries[i][0] == 0)
                ans[i] = xor[queries[i][1]];
            else{
                ans[i] = xor[queries[i][0]-1] ^ xor[queries[i][1]];
            }
        }
        return ans;
    }
}
```

## Python
```python
class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        n = len(arr)
        xor = [0]*n
        xor[0] = arr[0]
        
        for i in range(1, n):
            xor[i] = xor[i-1]^arr[i]
        
        l = len(queries)
        ans = [0]*l
        
        for i in range(l):
            if queries[i][0] == 0:
                ans[i] = xor[queries[i][1]]
            else:
                ans[i] = xor[queries[i][0]-1] ^ xor[queries[i][1]]
        return ans
```

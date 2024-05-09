<h2><a href="https://leetcode.com/problems/4sum/">18. 4Sum</a></h2><h3>Medium</h3><hr><p>Given an array <code>nums</code> of <code>n</code> integers, return <em>an array of all the <strong>unique</strong> quadruplets</em> <code>[nums[a], nums[b], nums[c], nums[d]]</code> such that:</p>

<ul>
	<li><code>0 &lt;= a, b, c, d&nbsp;&lt; n</code></li>
	<li><code>a</code>, <code>b</code>, <code>c</code>, and <code>d</code> are <strong>distinct</strong>.</li>
	<li><code>nums[a] + nums[b] + nums[c] + nums[d] == target</code></li>
</ul>

<p>You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,0,-1,0,-2,2], target = 0
<strong>Output:</strong> [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,2,2,2,2], target = 8
<strong>Output:</strong> [[2,2,2,2]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
</ul>

## Java
```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();
        long t = (long)target;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int k=j+1, l=n-1;
                while(k<l)
                {
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == t)
                    {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        ans.add(list);
                        k++;
                        l--;
                    }
                    else if(sum<t)
                        k++;
                    else
                        l--;
                }
            }
        }
        return new ArrayList(ans);
    }
}
```

## Python
```python
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        ans = set()
        n = len(nums)
        nums.sort()

        for i in range(n): 
            for j in range(i+1, n): 
                k=j+1
                l=n-1
                while k<l:
                    sum = nums[i] + nums[j] + nums[k] + nums[l]
                    if sum == target:
                        ans.add((nums[i], nums[j], nums[k], nums[l]))
                        k += 1;
                        l -= 1;
                    
                    elif sum<target:
                        k += 1
                    else:
                        l -= 1
        return list(ans)
```

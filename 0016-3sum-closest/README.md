<h2><a href="https://leetcode.com/problems/3sum-closest/">16. 3Sum Closest</a></h2><h3>Medium</h3><hr><p>Given an integer array <code>nums</code> of length <code>n</code> and an integer <code>target</code>, find three integers in <code>nums</code> such that the sum is closest to <code>target</code>.</p>

<p>Return <em>the sum of the three integers</em>.</p>

<p>You may assume that each input would have exactly one solution.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [-1,2,1,-4], target = 1
<strong>Output:</strong> 2
<strong>Explanation:</strong> The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,0], target = 1
<strong>Output:</strong> 0
<strong>Explanation:</strong> The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 500</code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
</ul>

## Java
```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        int prev = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++)
        {
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int lo = i+1;
            int hi = nums.length-1;
            while(lo<hi)
            {
                if(Math.abs(nums[i]+nums[lo]+nums[hi]-target)<prev)
                {
                    prev = Math.abs(nums[i]+nums[lo]+nums[hi]-target);
                    ans = nums[i]+nums[lo]+nums[hi];
                }
                else if(nums[i]+nums[lo]+nums[hi]<target)
                    lo++;
                else 
                    hi--;
            }
        }
        return ans;
    }
}
```
## Python
```python
class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        prev = 2**31-1
        ans = 2**31-1

        for i in range(len(nums)):

            if i!=0 and nums[i] == nums[i-1]: continue

            lo = i+1
            hi = len(nums)-1

            while lo<hi:
                if abs(nums[i]+nums[lo]+nums[hi]-target) < prev:
                    prev = abs(nums[i]+nums[lo]+nums[hi]-target)
                    ans = nums[i]+nums[lo]+nums[hi]
                elif nums[i]+nums[lo]+nums[hi]<target: lo += 1
                else: hi -= 1

        return ans
```

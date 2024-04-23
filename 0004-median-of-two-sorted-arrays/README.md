<h2><a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">4. Median of Two Sorted Arrays</a></h2><h3>Hard</h3><hr><div><p>Given two sorted arrays <code>nums1</code> and <code>nums2</code> of size <code>m</code> and <code>n</code> respectively, return <strong>the median</strong> of the two sorted arrays.</p>

<p>The overall run time complexity should be <code>O(log (m+n))</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,3], nums2 = [2]
<strong>Output:</strong> 2.00000
<strong>Explanation:</strong> merged array = [1,2,3] and median is 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,2], nums2 = [3,4]
<strong>Output:</strong> 2.50000
<strong>Explanation:</strong> merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>nums1.length == m</code></li>
	<li><code>nums2.length == n</code></li>
	<li><code>0 &lt;= m &lt;= 1000</code></li>
	<li><code>0 &lt;= n &lt;= 1000</code></li>
	<li><code>1 &lt;= m + n &lt;= 2000</code></li>
	<li><code>-10<sup>6</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
</ul>
</div>

## Java

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int nums1Size = nums1.length;
    int nums2Size = nums2.length;

    int n=nums1Size+nums2Size;
    int c[] = new int[n];
    int i=0,j=0,k=0;
    while(i<nums1Size&&j<nums2Size)
    {
        if(nums1[i]<nums2[j])
        {
            c[k++]=nums1[i++];
        }
        else{
            c[k++]=nums2[j++];
        }
    }
    while(i<nums1Size)
    {
        c[k++]=nums1[i++];
    }
    while(j<nums2Size)
    {
        c[k++]=nums2[j++];
    }
    if(n%2 == 1)
        return c[n/2];
    
    return (c[n/2]+c[n/2-1])/2.0;
        
    }
}
```

## Python

```python
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums1Size = len(nums1)
        nums2Size = len(nums2)

        n=nums1Size+nums2Size;
        c = [0]*n;
        i=0
        j=0
        k=0
        while i<nums1Size and j<nums2Size:
            if nums1[i]<nums2[j]:
                c[k]=nums1[i]
                k+=1
                i+=1
            
            else:
                c[k]=nums2[j]
                k+=1
                j+=1
        
        while i<nums1Size:
            c[k]=nums1[i]
            k+=1
            i+=1
        
        while j<nums2Size:
            c[k]=nums2[j]
            k+=1
            j+=1
        
        if n%2 == 1:
            return c[n//2]

        return (c[n//2]+c[n//2-1])/2.0
```

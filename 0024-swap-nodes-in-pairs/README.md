<h2><a href="https://leetcode.com/problems/swap-nodes-in-pairs/">24. Swap Nodes in Pairs</a></h2><h3>Medium</h3><hr><p>Given a&nbsp;linked list, swap every two adjacent nodes and return its head. You must solve the problem without&nbsp;modifying the values in the list&#39;s nodes (i.e., only nodes themselves may be changed.)</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg" style="width: 422px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4]
<strong>Output:</strong> [2,1,4,3]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> head = []
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> head = [1]
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the&nbsp;list&nbsp;is in the range <code>[0, 100]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
</ul>

## Java
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode i=head, j;
        if(head == null || head.next == null)
            return head;
        j=head.next;
        head=j;
        while(true)
        {
            ListNode t=j.next;
            j.next=i;
            if (t == null || t.next == null) {
                i.next = t;
                break;
            }
            i.next=t.next;
            i=t;
            j=i.next;
        }
        return head;
    }
}
```

## Python
```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        i=head

        if head == None or head.next == None: return head
        j=head.next

        head=j
        while True:
            t=j.next
            j.next=i
            if t == None or t.next == None: 
                i.next = t
                break
            
            i.next=t.next
            i=t
            j=i.next
        
        return head
```

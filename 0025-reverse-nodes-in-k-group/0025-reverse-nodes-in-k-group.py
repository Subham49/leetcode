# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        end = head
        for i in range(1, k+1):
            if not end:
                return head
            end = end.next
        
        c, p, n = head, None, None
        count = 0
        while c and count < k:
            n = c.next
            c.next = p
            p = c
            c = n
            count += 1
        
        if end:
            head.next = self.reverseKGroup(end, k)
        return p
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        prev = ListNode(-1)
        curr = head
        len = 0
        while curr: 
            len += 1
            curr = curr.next

        if n is len: return head.next
        curr = head
        for i in range(len-n):
            prev = curr
            curr = curr.next

        if curr:
            prev.next = curr.next
        
        return head
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
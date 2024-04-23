# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        curr = dummy
        carry = 0
        
        while l1 or l2 or carry:
            sum_value = carry
            
            if l1:
                sum_value += l1.val
                l1 = l1.next
                
            if l2:
                sum_value += l2.val
                l2 = l2.next
            
            carry = sum_value // 10
            curr.next = ListNode(sum_value % 10)
            curr = curr.next
        
        return dummy.next

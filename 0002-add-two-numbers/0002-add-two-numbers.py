# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        a = l1;
        b = l2;
        
        c = ListNode(-1);
        curr = c;
        while a!=None or b!=None:
            f = 0
            if a!=None:
                f = a.val
                a = a.next
            
            s = 0
            if b!=None:
                s = b.val
                b = b.next
            
            curr.next = ListNode(f+s)
            curr = curr.next
        
        curr = c.next
        carry = 0
        while curr!=None:
            temp = (carry+curr.val)//10
            curr.val = (carry+curr.val)%10
            carry = temp
            if curr.next == None and carry!=0:
                curr.next = ListNode(carry)
                break
            
            curr = curr.next
            
        return c.next
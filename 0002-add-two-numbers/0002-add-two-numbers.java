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
    public ListNode reverse(ListNode head) {
        ListNode c=head, p=null, n=null;
        while(c!=null)
        {
            n=c.next;
            c.next=p;
            p=c;
            c=n;
        }
        return p;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        
        ListNode c = new ListNode(-1);
        ListNode curr = c;
        while(a!=null || b!=null)
        {
            int f = 0;
            if(a!=null){
                f = a.val;
                a = a.next;
            }
            int s = 0;
            if(b!=null){
                s = b.val;
                b = b.next;
            }
            curr.next = new ListNode(f+s);
            curr = curr.next;
        }
        
        curr = c.next;
        int carry = 0;
        while(curr!=null)
        {
            int temp = (carry+curr.val)/10;
            curr.val = (carry+curr.val)%10;
            carry = temp;
            if(curr.next == null && carry!=0)
            {
                curr.next = new ListNode(carry);
                break;
            }
            curr = curr.next;
        }
        return c.next;
    }
}
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr=head, p=head, prev=null;
        for(int i=1; i<n; i++)
            ptr=ptr.next;
        while(ptr.next!=null)
        {
            ptr=ptr.next;
            prev=p;
            p=p.next;
        }
        if(prev==null)
            head=head.next;
        else
            prev.next=p.next;
        return head;
    }
}
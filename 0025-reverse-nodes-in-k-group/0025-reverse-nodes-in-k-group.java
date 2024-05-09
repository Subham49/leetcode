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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode end = head;
        for(int i=1; i<=k; i++)
        {
            if(end == null)
                return head;
            end = end.next;
        }
        ListNode c=head, p=null, n=null;
        int count = 0;
        while(c!=null && count<k)
        {
            n=c.next;
            c.next=p;
            p=c;
            c=n;
            count++;
        }
        if(end!=null)
            head.next = reverseKGroup(end, k);
        return p;
        
    }
}
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
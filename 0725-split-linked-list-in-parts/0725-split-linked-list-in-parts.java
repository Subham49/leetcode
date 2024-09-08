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
    int length(ListNode h)
    {
        int l = 0;
        while(h!=null)
        {
            l++;
            h = h.next;
        }
        return l;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int l = length(head);
        int t = l/k;
        ListNode[] list = new ListNode[k];
        int rem = l%k;
        ListNode h = head;

        for(int i=0; i<k; i++)
        {
            ListNode s = h;
            ListNode p = null;
            for(int j=0; h!=null && j<t+(rem>0?1:0); j++)
            {
                p = h;
                h = h.next;
            }
            if(p!=null)
                p.next = null;
            list[i] = s;
            rem--;
        }
        return list;
    }
}
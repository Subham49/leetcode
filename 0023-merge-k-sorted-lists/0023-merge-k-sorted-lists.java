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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)-> a.val - b.val);

        for(ListNode list : lists)
        {
            ListNode curr = list;
            while(curr != null)
            {
                pq.add(curr);
                curr = curr.next;
            }
        }
        for(ListNode list : pq) System.out.println(list.val);
        
        ListNode d = new ListNode(-1);
        ListNode curr = d;
        while(!pq.isEmpty())
        {
            ListNode t = pq.remove();
            curr.next = t;
            curr = curr.next;
        }
        curr.next = null;
        return d.next;
    }
}
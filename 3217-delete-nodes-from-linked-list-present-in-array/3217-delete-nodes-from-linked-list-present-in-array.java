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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode d = new ListNode(-1);
        d.next = head;
        ListNode curr = head;
        ListNode prev = d;
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        while(curr != null)
        {
            if(!set.contains(curr.val))
            {
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = curr;
        return d.next;
    }
}
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode i = list1, j = list2;
        ListNode d = new ListNode(-1);
        ListNode curr = d;
        while(i != null && j != null)
        {
            if(i.val<j.val){
                d.next = i;
                i = i.next;
            }else{
                d.next = j;
                j = j.next;
            }
            d = d.next;
        }

        while(i != null){
            d.next = i;
            i = i.next;
            d = d.next;
        } 
        while(j != null){
            d.next = j;
            j = j.next;
            d = d.next;
        }    
        return curr.next;
    }
}
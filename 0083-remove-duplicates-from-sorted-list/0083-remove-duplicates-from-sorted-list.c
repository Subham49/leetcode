/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* deleteDuplicates(struct ListNode* head){
    struct ListNode *i=head, *j=NULL;
    while(i && i->next)
    {
       j=i->next;
       while(j && i->val==j->val)
       {
           i->next=j->next;
           free(j);
           j=i->next;
       }
       i=j;
    }
    return head;
}
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* deleteDuplicates(struct ListNode* head){
    struct ListNode *i = head, *j = NULL;
    while (i && i->next)
    {
        if (i->val == (i->next)->val)
        {
            int n = i->val;
            while (i && i->val == n)
            {
                if (i == head)
                {
                    head=head->next;
                    free(i);
                    i=head;
                }
                else{
                    j->next=i->next;
                    free(i);
                    i=j->next;
                }
            }
        }
        else{
            j=i;
            i=i->next;
        }
    }
    return head;
}
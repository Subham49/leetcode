/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* create(struct ListNode *head, int n)
{
    struct ListNode *p=head;
    if(head==NULL)
    {
        head=(struct ListNode*)malloc(sizeof(struct ListNode));
        head->val=n;
        head->next=NULL;
        return head;
    }
    while (p->next!=NULL)
    {
        p=p->next;
    }
    p->next=(struct ListNode*)malloc(sizeof(struct ListNode));
    p=p->next;
    p->val=n;
    p->next=NULL;
    return head;
}

struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2){
    struct ListNode *p=list1, *q=list2, *h=NULL;
    while(p!=NULL && q!=NULL)
    {
        if(p->val > q->val)
        {
            h=create(h,q->val);
            q=q->next;
        }
        else{
            h=create(h,p->val);
            p=p->next;
        }
    }
    while(p!=NULL)
    {
        h=create(h,p->val);
        p=p->next;
    }
    while(q!=NULL)
    {
        h=create(h,q->val);
        q=q->next;
    }
    return h;
}


// Complete the reverse function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode* next;
 * };
 *
 */
SinglyLinkedListNode* reverse(SinglyLinkedListNode* head) {

    if(head == NULL) return NULL;
    else if(head->next == NULL) return head;
    else 
    {
        SinglyLinkedListNode *p,*t,*n;
        p = head;
        t = head->next;
        n = head;
        head->next = NULL;
        while(n!=NULL)
        {
            n = t->next;
            t->next = p;
            p = t;
            t = n;
        }
        return p;
    }
    
}


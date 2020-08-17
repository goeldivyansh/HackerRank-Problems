

// Complete the removeDuplicates function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode* next;
 * };
 *
 */
SinglyLinkedListNode* removeDuplicates(SinglyLinkedListNode* head) {
    SinglyLinkedListNode *t =  head,*t2,*t3;

    if(head == NULL || head->next == NULL)
        return head;

    while(t!=NULL)
    {
        t2 = t->next;
        while(t2!=NULL)
        {
            if(t->data == t2->data)
            {
                t3 = head;
                while(t3->next != t2)
                    t3 = t3->next;

                t3->next = t2->next;
                free(t2);  
                t2 = t3;
            }
            t2 = t2->next;
        }
        t = t->next;
    }
    return head;
}


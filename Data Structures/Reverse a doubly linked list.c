

// Complete the reverse function below.

/*
 * For your reference:
 *
 * DoublyLinkedListNode {
 *     int data;
 *     DoublyLinkedListNode* next;
 *     DoublyLinkedListNode* prev;
 * };
 *
 */
DoublyLinkedListNode* reverse(DoublyLinkedListNode* head) {

    DoublyLinkedListNode *temp,*t2, *t = head;

    while(t->next != NULL)
        t = t->next;

    head = t;
    t2 = t->prev;
   // t->prev = NULL;
    while(t != NULL)
    {
        if(t->next == NULL)
        {
            t->prev = NULL;
        }
        else 
        {
            t->prev = temp;
        }
        t->next = t2;
        temp = t;
        t = t2;
        if(t2!=NULL)
            t2 = t2->prev;
    }
    return head;
}


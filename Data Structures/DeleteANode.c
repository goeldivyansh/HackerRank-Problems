

// Complete the deleteNode function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode* next;
 * };
 *
 */
SinglyLinkedListNode* deleteNode(SinglyLinkedListNode* head, int position) {

    int i;
    SinglyLinkedListNode *t = head,*t2;

    if(position == 0)
    {
        head = head->next;
        free(t);
        return head;
    }

    for(i=0;i<position;i++)
    {
        t2 = t;
        t = t->next;
    }
    t2->next = t->next;
    free(t);
    return head;
}


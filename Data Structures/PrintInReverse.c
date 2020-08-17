

// Complete the reversePrint function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode* next;
 * };
 *
 */
void reversePrint(SinglyLinkedListNode* head) {
    
    if(head == NULL)
        return NULL;

    reversePrint(head->next);
    // return head->next;
    printf("%d\n",head->data);
}


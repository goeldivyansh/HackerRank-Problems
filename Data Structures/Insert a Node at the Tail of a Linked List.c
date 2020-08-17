

// Complete the insertNodeAtTail function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode* next;
 * };
 *
 */
SinglyLinkedListNode* insertNodeAtTail(SinglyLinkedListNode* head, int data) {
    SinglyLinkedListNode* temp;
    SinglyLinkedListNode* t = head;
    temp = create_singly_linked_list_node(data);

    if(head == NULL)
    {
        head = temp;
    }
    else
    if(head->next == NULL)
    {
        head->next = temp;
    }
    else
    {
        while(t->next != NULL)
        {
            t = t->next;
        }
        t->next = temp;
    }
    return head;
}


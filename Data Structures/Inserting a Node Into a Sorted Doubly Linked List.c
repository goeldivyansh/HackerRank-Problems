

// Complete the sortedInsert function below.

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
DoublyLinkedListNode* sortedInsert(DoublyLinkedListNode* head, int data) {

    DoublyLinkedListNode* temp;
    temp = (DoublyLinkedListNode*)malloc(sizeof(DoublyLinkedListNode));
    temp->prev = temp->next = NULL;
    temp->data = data;

    if(head == NULL)
        head = temp;
    else
    if(temp->data <= head->data)
    {
        temp->next = head;
        head->prev = temp;
        head = temp;
    }
    else 
    {
        DoublyLinkedListNode* t;
        t = head;
        while(t->data < temp->data)
        {
            if(t->next == NULL)
            {
                t->next = temp;
                temp->prev = t;
                return head;
            }
            t = t->next;
        }        

        temp->prev = t->prev;
        temp->next = t;

        t->prev->next = temp;
        t->prev = temp;
    }
    return head;
}


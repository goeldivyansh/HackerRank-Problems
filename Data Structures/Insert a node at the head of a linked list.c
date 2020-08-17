

// Complete the insertNodeAtHead function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode* next;
 * };
 *
 */
SinglyLinkedListNode* insertNodeAtHead(SinglyLinkedListNode* llist, int data) {

    SinglyLinkedListNode* t = llist;
    SinglyLinkedListNode* temp;

    temp = create_singly_linked_list_node(data);

    temp->next = t;
    llist = temp;
    return llist;


}


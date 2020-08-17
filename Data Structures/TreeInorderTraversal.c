

/* you only have to complete the function given below.  
node is defined as  

struct node {
    
    int data;
    struct node *left;
    struct node *right;
  
};

*/
void inOrder( struct node *r) {
    if(r==NULL) return;
    inOrder(r->left);
    printf("%d ",r->data);
    inOrder(r->right);
}


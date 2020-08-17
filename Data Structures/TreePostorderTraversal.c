

/* you only have to complete the function given below.  
node is defined as  

struct node {
    
    int data;
    struct node *left;
    struct node *right;
  
};

*/
void postOrder( struct node *r) {

    if(r==NULL) return;
    postOrder(r->left);
    postOrder(r->right);
    printf("%d ",r->data);

}




/* you only have to complete the function given below.  
node is defined as  

struct node {
    
    int data;
    struct node *left;
    struct node *right;
  
};

*/
void preOrder( struct node *r) {


    if(r==NULL) return;
    printf("%d ",r->data);

    preOrder(r->left);
    preOrder(r->right);
    
}


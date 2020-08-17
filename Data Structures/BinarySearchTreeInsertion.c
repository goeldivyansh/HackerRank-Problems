#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

struct node {
    
    int data;
    struct node *left;
    struct node *right;
  
};

void preOrder( struct node *root) {
  
	if( root == NULL ) 
      return;
	printf("%d ",root->data);
	preOrder(root->left);
	preOrder(root->right);
  
}

/* you only have to complete the function given below.  
node is defined as  

struct node {
    
    int data;
    struct node *left;
    struct node *right;
  
};

*/
struct node* insert( struct node* root, int data ) {

    struct node *r,*t,*temp;
    r = root;
    t = (struct node*)malloc(sizeof(struct node)); 
    t->data = data;
    t->left = NULL;
    t->right = NULL;
	
	if(r==NULL) return t;

    while(r)
    {
        temp = r;
        if(t->data < r->data)
            r = r->left;
        else 
            r = r->right;
    }
    if(t->data < temp->data)
        temp->left = t;
	else 
        temp->right = t;
    
    return root;	
}


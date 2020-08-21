#include <stdio.h>
#include <stdlib.h>
typedef struct Node{
    struct Node* left;
    struct Node* right;
    int data;
}Node;
Node* newNode(int data){
    Node* node=(Node*)malloc(sizeof(Node));
    node->left=node->right=NULL;
    node->data=data;
    return node;
}

int getHeight(Node* root){
  //Write your code here
    if(root==NULL)
        return -1;
    int left = getHeight(root->left);
    int right = getHeight(root->right);

    if(left >= right) return left+1;
    else return right+1;
}

Node* insert(Node* root,int data){
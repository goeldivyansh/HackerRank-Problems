#include<stdio.h>

int main()
{
    int i,j=0,n,d;

    scanf("%d%d",&n,&d);

    int a[n],b[n];

    for(i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
  //1 2 3 4 5
  //5 1 2 3 4 
    for(i=d;i<n;i++)
    {
        b[j] = a[i];
        j++;        
    }
    for(i=0;i<d;i++)
        {
            b[j] = a[i];
            j++;
        }

    for(i=0;i<n;i++)
    {
        printf("%d ",b[i]);
    }
    return 0;
}

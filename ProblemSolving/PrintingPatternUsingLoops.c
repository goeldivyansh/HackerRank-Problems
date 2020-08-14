#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() 
{
    int n,i,j;
    scanf("%d", &n);
    int size = 2*n-1; 
    int s=0;
    int e=size-1;
    int a[size][size];
    int m=n;
    while(m!=0)
    {
        for(i=s;i<=e;i++)
        {
            for(j=s;j<=e;j++)
            {
                if(i==s || i==e || j==s || j==e)
                    a[i][j] = m;
            }
        }
        ++s;
        --e;
        --m;
    }
    for(i=0;i<2*n-1;i++)
    {
        for(j=0;j<2*n-1;j++)
        {
            printf("%d ",a[i][j]);
        }
        printf("\n");
    }
    return 0;
}

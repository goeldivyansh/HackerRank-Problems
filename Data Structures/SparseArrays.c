#include <assert.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main()
{
    int i,j,n,q;

    scanf("%d",&n);
    char a[n][21];
    for(i=0;i<n;i++)
        scanf("%s",&a[i]);

    
    scanf("%d",&q);
    char b[q][21];
    int ans[q],x;

    for(i=0;i<q;i++)
    {
        scanf("%s",&b[i]);
        ans[i] = 0;
    }

    for(i=0;i<q;i++)
    {
        for(j=0;j<n;j++)
        {
            if(strcmp(a[j],b[i]) == 0)
            {
                ans[i]++;
            }
        }
    }

    for(i=0;i<q;i++)
    {
        printf("%d\n",ans[i]);
    }
    return 0;
}

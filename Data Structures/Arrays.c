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
    int a[1000];
    int n,i;

    scanf("%d",&n);
    for(i=0;i<n;i++)
        scanf("%d",&a[i]);

    for(i=0;i<n/2;i++)
    {
        a[i] = a[i] + a[n-1-i];
        a[n-1-i] = a[i] - a[n-1-i];
        a[i] = a[i] - a[n-1-i];
    }
for(i=0;i<n;i++)
        printf("%d ",a[i]);

    return 0;
}

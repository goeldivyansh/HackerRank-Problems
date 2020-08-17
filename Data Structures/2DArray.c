#include<stdio.h>

int main()
{
    int a[6][6],n=6,i,j,k,sum,max;
    max = -2147483648;

    for(i=0;i<6;i++)
    {
        for(j=0;j<6;j++)
        {
            scanf("%d",&a[i][j]);
        }
    }

    for(i=0;i<4;i++)
    {
        for(j=0;j<4;j++)
        {
            sum = a[i+1][j+1];

            for(k=0;k<3;k++)
            {
                sum = sum + a[i][k+j] + a[i+2][k+j];
            }

            if(max<sum)
            {
                max = sum;
            }
        }
    }
    printf("%d",max);
    return 0;
}

#include <assert.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* readline();
char** split_string(char*);

// Complete the longestCommonSubsequence function below.

// Please store the size of the integer array to be returned in result_count pointer. For example,
// int a[3] = {1, 2, 3};
//
// *result_count = 3;
//
// return a;
//
int ans[100];
int max(int x,int y)
{
    if(x>=y) return x;
    else return y;
}


int* longestCommonSubsequence(int a_count, int* a, int b_count, int* b, int* result_count) {

    int i,j,count=0;
    int arr[a_count+1][b_count+1];

    for(i=0;i<a_count+1;i++)
    {
        for(j=0;j<b_count+1;j++)
        {
            if(i==0 || j==0) 
            {
                arr[i][j] = 0;
            }
            else
            {
                if(a[i-1] == b[j-1])
                {
                    arr[i][j] = arr[i-1][j-1] +1; 
                    count++;
                }
                else
                {
                    arr[i][j] = max(arr[i][j-1],arr[i-1][j]);
                }
            }
        }
    }

    // Finding Length of largest common subsequence
    int max=0,indi,indj;
    for(i=1;i<a_count+1;i++)
    {
        for(j=1;j<b_count+1;j++)
        {
            if(arr[i][j] > max)
            {
                max = arr[i][j];
                indi = i;
                indj = j;
            }
        }
    }

    //Finding subsequence
    *result_count = max;
    //int ans[max];
    max--;
    while(arr[indi][indj])
    {
        if(a[indi-1] == b[indj-1])
        {
            ans[max] = a[indi-1];
            indi--;
            indj--;
            max--;
        }
        else 
        {
            if(arr[indi][indj] == arr[indi][indj-1])
                indj--;
            else
            if(arr[indi][indj] == arr[indi-1][indj])
                indi--;
        }
    }
    return ans;
}

int main()
{
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");

    char** nm = split_string(readline());

    char* n_endptr;
    char* n_str = nm[0];
    int n = strtol(n_str, &n_endptr, 10);

    if (n_endptr == n_str || *n_endptr != '\0') { exit(EXIT_FAILURE); }

    char* m_endptr;
    char* m_str = nm[1];
    int m = strtol(m_str, &m_endptr, 10);

    if (m_endptr == m_str || *m_endptr != '\0') { exit(EXIT_FAILURE); }

    char** a_temp = split_string(readline());

    int* a = malloc(n * sizeof(int));

    for (int i = 0; i < n; i++) {
        char* a_item_endptr;
        char* a_item_str = *(a_temp + i);
        int a_item = strtol(a_item_str, &a_item_endptr, 10);

        if (a_item_endptr == a_item_str || *a_item_endptr != '\0') { exit(EXIT_FAILURE); }

        *(a + i) = a_item;
    }

    int a_count = n;

    char** b_temp = split_string(readline());

    int* b = malloc(m * sizeof(int));

    for (int i = 0; i < m; i++) {
        char* b_item_endptr;
        char* b_item_str = *(b_temp + i);
        int b_item = strtol(b_item_str, &b_item_endptr, 10);

        if (b_item_endptr == b_item_str || *b_item_endptr != '\0') { exit(EXIT_FAILURE); }

        *(b + i) = b_item;
    }

    int b_count = m;

    int result_count;
    int* result = longestCommonSubsequence(a_count, a, b_count, b, &result_count);

    for (int i = 0; i < result_count; i++) {
        fprintf(fptr, "%d", *(result + i));

        if (i != result_count - 1) {
            fprintf(fptr, " ");
        }
    }

    fprintf(fptr, "\n");

    fclose(fptr);

    return 0;
}

char* readline() {
    size_t alloc_length = 1024;
    size_t data_length = 0;
    char* data = malloc(alloc_length);

    while (true) {
        char* cursor = data + data_length;
        char* line = fgets(cursor, alloc_length - data_length, stdin);

        if (!line) { break; }

        data_length += strlen(cursor);

        if (data_length < alloc_length - 1 || data[data_length - 1] == '\n') { break; }

        size_t new_length = alloc_length << 1;
        data = realloc(data, new_length);

        if (!data) { break; }

        alloc_length = new_length;
    }

    if (data[data_length - 1] == '\n') {
        data[data_length - 1] = '\0';
    }

    data = realloc(data, data_length);

    return data;
}

char** split_string(char* str) {
    char** splits = NULL;
    char* token = strtok(str, " ");

    int spaces = 0;

    while (token) {
        splits = realloc(splits, sizeof(char*) * ++spaces);
        if (!splits) {
            return splits;
        }

        splits[spaces - 1] = token;

        token = strtok(NULL, " ");
    }

    return splits;
}

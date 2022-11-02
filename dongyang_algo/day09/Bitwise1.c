#include <stdio.h>
#include <string.h>

int isEven(int n)
{
    return (n & 1);
}
int main()
{
    int n = 16;

    if (isEven(n) == 1)
        printf("Odd");
    else
        printf("Even");
    return 0;
}
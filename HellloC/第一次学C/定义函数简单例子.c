#include <stdio.h>
#include <math.h>
int main(void)
{
    int a,b;

    printf("Input a number as the first.\n");
    scanf("%d", &a);
    printf("Input the next number.\n");
    scanf("%d", &b);

    int sb;
    sb = sum(a,b);

    printf("The result is %d.\n", sb);
    printf("Done!");

    return 0;
}

void sum(int a,int b)
{
    int c;
    c = a * b;
    return c;
}
#include <stdio.h>
int main(void)
{
    int i,j;
    char c,d;
    d = 'A' + i;
    for (i = 0;i < 7;i++)
    {
        for (j = 0;j < i;j++,d++)
        {
            printf("%c",d);
        }
        printf("\n");
    }
    return 0;
}
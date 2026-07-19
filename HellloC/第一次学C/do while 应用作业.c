#include <stdio.h>
#include <math.h>
int main(void)
{
    int numbers[8];
    int i;

    for ( i = 0;i < 8;i++)
    {
        numbers[i] = pow(2,i);
    }

    i = 0;
    
    do
    {
        printf("%d\n", numbers[i++]);
    } 
    while (i < 8);

    return 0;
}
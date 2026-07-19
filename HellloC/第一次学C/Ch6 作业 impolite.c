#include <stdio.h>//这是一个编程作业
int main(void)
{
    int shit, fuck, sb, cnm, nmb;
    printf("This program computes moduli.\n");
    printf("Enter an integer to serve as the second operand:\n");
    scanf("%d", &shit);
    printf("Now,enter the first operand:\n");
    scanf("%d", &fuck);
    sb = fuck % shit;
    printf("%d %% %d is %d\n", fuck ,shit ,sb);
    printf("Enter next number for first operand:\n");
    scanf("%d", &cnm);
    while (cnm > 0)
    {
    printf("Enter next number for first operand:\n");
    scanf("%d", &cnm);
    nmb = cnm % shit;
    printf("%d %% %d is %d\n", cnm, shit, nmb);
    if (cnm < 0)
    break;
    }
    printf("Done");
    return 0;
}
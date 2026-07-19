//四则运算计算器
#include <stdio.h>
#include <ctype.h>
#include <math.h>

int main(void)
{
    int choice;
    float first,next,result;

    printf("Hello,this is a simple calculator which can help you.\n");
    printf("Now,please input the first number.\n");

    scanf("%f", &first);

    printf("OK,please input the next number.\n");

    begin : scanf("%f", &next);

    printf("Please make a choice.\n");
    printf("Choose a number : \n1) + 2) - \n3) * 4) /\nq) quit\n");//菜单；

    scanf("%d", &choice);

    switch (choice)
    {
        case 1 :
        {
            result = (first + next);
            break;
        }
        case 2 :
        {
            result = (first - next);
            break;
        }
        case 3 :
        {
            result = (first * next);
            break;
        }
        case 4 :
        {
            if (next == 0)
            {
                printf("E! 0! Please reinput.\n");
                goto begin;//除数不可为0，返回上级；
            }
            result = (first / next);
            break;
        }
        default :
        {
            printf("Are you blind?\n");//友好的交流，试错；
        }
    }

    printf("Well the result is %f !\n",result);
    printf("Done! Ctrl + Z + Enter to exit.\n");
    scanf("%s");

    return 0;
}
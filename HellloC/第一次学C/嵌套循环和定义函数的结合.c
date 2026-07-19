//设计一个函数chline(ch, i, j),打印指定的字符j行i列.
#include <stdio.h>
void chline(int ch, int i, int j);
int main(void)
{
    printf("Welcome!\nPlease input a character and tell me how many do you want to print?\n");
    int a,b;
    char input;
    scanf("%c", &input);
    printf("First to input HENG.\nNext to input SHU.\n");
    scanf("%d",&a);
    scanf("%d",&b);
    chline(input, a, b);
    return 0;
}

void chline(int ch, int i, int j)
{
    int m,n;
    for (m = 1;m <= j;m++)
    {
        for (n = 1;n <= i;n++)
        {
            printf("%c",ch);
        }
        printf("\n");
    }
}
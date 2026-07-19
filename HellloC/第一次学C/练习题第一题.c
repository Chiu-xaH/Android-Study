//编写一个程序读取输入，读到#为止，然后报告读取的空格数、换行符数、所有其他字符的数量。
#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
int main(void)
{
    int ch;
    int chars = 0;
    int space = 0;
    int enter = 0;

    printf("Please input something.Input # to over\n");

    while ( (ch = getchar()) != '#')
    {
        if (ch == '\n')
            enter++;      //统计换行
        else if (ch == ' ')
            space++;    //统计空格
        else
            chars++;
    }
    printf("There are %d chars %d space %d enters.\n",chars,space,enter);
    printf("Done!");

    return 0;
}
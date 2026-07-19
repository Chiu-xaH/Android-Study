//编写一个程序读取输入，读到0为止，然后报告输入的偶数（不包括0）的个数，奇数的个数,通过询问用户输入数字个数来计算输入数字总和平均数。

#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
int main(void)
{
    int input = 0;;
    int deodd = 0;
    int odd = 0;
    int addodd = 0;
    int adddeodd = 0;
    int pingjunshu;
    int howmany;
    int total = 0;

    printf("Please input something.Input 0 to over.Input q to quit\n");

    while ( scanf("%d", &input) )
    {
       if (input == 0)
       {
        break;
       }
       if (input % 2 == 0)
       {
        deodd++;
        adddeodd += input;
       }
       else if (input % 2 == 1)
       {
        odd++;
        addodd += input;
       }
       total += input;
    }
    
    pingjunshu = (total / howmany);//不用双等号！！！！！！！赋值操作,整篇最大误区
    printf("Oh baby,how many numbers did you input just now?.\n");
    scanf("%d", &howmany);
    printf("There are %d deodds and also %d odds in this.\n",deodd,odd);
    printf("The result of the ODD ADD is %d and the DEODD ADD is %d\n",addodd,adddeodd);
    printf("The number of Pingjunshu is %d\n", pingjunshu);
    printf("Done!");

    return 0;
}
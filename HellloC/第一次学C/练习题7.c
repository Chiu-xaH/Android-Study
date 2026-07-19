#include <stdio.h>
#define a 0.15
#define b 0.20
#define c 0.25

int main(void)
{
    int input,money,xinshui,grade,basic,add;
    add = (1.5 * basic);

    printf("Enter the number corresponding to the desired pay rate or action:\n");
    printf("1) $8.75/hr     2) $9.73/hr     3) $10.00/hr     4) $11.20/hr     q) quit\n");
    scanf("%d", &grade);

    switch (grade)
    {
      case 1 :
        {
         basic = 8.75;
         break;
        }
      case 2 :
        {
         basic = 9.73;
         break;
         }
      case 3 :
        {
         basic = 10.00;
         break;
        }
      case 4 :
        {
         basic = 11.20;
         break;
        }
      default :
        {
         printf("No choice!\n");
         break;
        }
    }

    printf("Please tell me how many hours have you worked a week?\n");
    scanf("%d", &input);

    if (input <= 40 && input > 0)
       {
        money = (basic * input);
        if (money <= 300)
          xinshui = ((1 - a) * money);
        else
          xinshui = ((1 - b) * (money - 300)) + (300 * (1 - a));
       }
    else if (input > 40)
       {
       money = (((input - 40) * add) + (40 * basic));
       if (money <= 450)
          xinshui = ((1 - b) * (money - 300)) + (300 * (1 - a));
        else
          xinshui = ((money - 450) * (1 -c)) + (150 * (1 - b)) + (300 * (1 - a));
       }

    printf("Your money is %d!\n", xinshui);
    printf("Done!");

    return 0;
}
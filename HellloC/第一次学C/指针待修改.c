//以3个double变量的地址为参数，把最小值放在第一个变量，依次排放。
#include <stdio.h>

double poinner(double a,double b,double c);

int main(void)
{
    double d,e,f;

    printf("Please input 3 numbers.\n");
    scanf("%lf %lf %lf",&d,&e,&f);
    printf("From Biggest to smallest are\n");
    poinner(d,e,f);

    return 0;
}

double poinner(double a,double b,double c)
{
    if (a >= b && a >= c)
    {
        printf("%lf ",a);

        if (b >= c)
            printf("%lf %lf",b,c);
        if (b <= c)
            printf("%lf %lf",c,b);
    }
    if (b >= a && b >= c)
    {
        printf("%lf ",b);

        if (a >= c)
            printf("%lf %lf",a,c);
        if (a <= c)
            printf("%lf %lf",c,a);
    }
    if (c >= a && c >= b)
    {
        printf("%lf ",c);

        if (a >= b)
            printf("%lf %lf",a,b);
        if (a <= b)
            printf("%lf %lf",b,a);
    }

    return 0;
}

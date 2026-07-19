
#include <stdio.h>
double new(double a,double b);
int main(void)
{
    double c,d;
    printf("Please input tewo news.\n");
    scanf("%lf %lf",&c,&d);
    printf("The result is %lf.\nDone!",new(c,d));
    return 0;
}

double new(double a,double b)
{
    double c;
    c = 2.0 / ((1.0 / a) + (1.0 / b)) ;
    return c;
}

#include <stdio.h>

void swap(double *x,double *y,double *z);

int main(void)
{
    double a,b,c;

    printf("Enter the number.\n");
    scanf("%lf %lf %lf",&a,&b,&c);
    swap(&a,&b,&c);
    printf("%lf %lf %lf.\nDone!",a,b,c);

    return 0;
}

void swap(double *x,double *y,double *z)
{
    double temp;

    if (*x > *y)
    {
        temp = *x;
        *x = *y;
        *y = temp;
    }
    if (*x > *z)
    {
        temp = *x;
        *x = *z;
        *z = temp;
    }
    if (*y > *z)
    {
        temp = *y;
        *y = *z;
        *z = temp;
    }

    return 0;
}
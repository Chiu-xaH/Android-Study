//编写在一个函数，返回存储在int类型数组中的最大值，并在一个简单的程序中才测试该函数
#include <stdio.h>
int max(int numbers[],int n);

int main(void) {
    int c[8] = {6,4,2,8,11,8,4,4};
    printf("%d",max(c,8));
    return 0;
}
int max(int numbers[],int n) {
    int m = numbers[0];
    int i,x;
    for (i = 0;i < n;i++) {
        if (m < numbers[i]) {
            m = numbers[i];
            x = i;
        }
    }
    return x;
}
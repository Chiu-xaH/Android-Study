//倒序排列
#include <stdio.h>
int max(int numbers[],int n);

int main(void) {
    int c[8] = {6,4,2,8,11,8,1,4};
    int i;
    for (i = 0;i < 8;i++) printf("%g", c[i]);
    printf("\n");
    max(c,8);
    for (i = 0;i < 8;i++) printf("%g", c[i]);
    return 0;
}
int max(int numbers[],int n) {
    int temp;
    for (int j = 0;j < n - 1 - j;j++) {
        if (numbers[j] < numbers[j + 1]) {
            temp = numbers[j];
            numbers[j] = numbers [j + 1];
            numbers[j + 1] = temp;
        }
    }
}
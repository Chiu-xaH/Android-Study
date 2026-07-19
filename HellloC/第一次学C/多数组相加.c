#include <stdio.h>
void add(int numbers1[],int numbers2[],int n);
int main(void) {
    int group1[6] = {1,2,3,4,5,6};
    int group2[6] = {9,8,7,6,5,4};
    add(group1,group2,6);
    return 0;
}

void add(int numbers1[],int numbers2[],int n) {
    int numbers3[n];
    for (int i = 0;i < n;i++) {
        numbers3[i] = (numbers1[i] + numbers2[i]);
        printf("%4d",numbers3[i]);
    }
}
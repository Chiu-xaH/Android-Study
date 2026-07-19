#include <stdio.h>
int main() {
    int num1,num2,num3,num4,num5;
    printf("Please input 5 numbers,bewteen one space.\n");
    scanf("%d %d %d %d %d ",&num1,&num2,&num3,&num4,&num5);
    int total = num1 + num2 + num3 + num4 + num5;
    int pingjunshu = total / 5;
    printf("%d\n",pingjunshu);
    printf("Done! Ctrl + Z + Enter to exit.\n");
    scanf("%s");
}//
// Created by 赵思涵 on 2023/10/29.
//

//声明一个int 3*5 数组，并用合适的值初始化它。程序打印数组中的值，然后各值翻倍，并显示出各元素新值。编写两个函数去实现，都以函数名和行数为参数
#include <stdio.h>
void print(int m,int n,int numbers[m][n]);
void douprint(int m,int n,int numbers[m][n]);
int main(void) {
    int group[5][3] = {
        {1,2,3,4,5},
        {6,7,8,9,10},
        {11,12,13,14,15}
    };
    print(5,3,group);
    
    return 0;
}
void print(int m,int n,int numbers[m][n]) {
    for (int i = 0;i < m;i++) {
        for (int j = 0;j < n;j++)
             printf("%4d",numbers[i][j]);
    }
}
//void douprint(int m,int n,int numbers[m][n]){

//}
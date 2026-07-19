//用户输入三组数字（每组5个），作为二维数组，计算出每组（5个）平均数。
#include <stdio.h>
double pingjunshu(double group[][5],int n);
double pingjunshuall(double group[][5],int n);
double max(double group[][5],int n);

int main(void) {
    double numbers[3][5];

    printf("Hello,please input some numbers to make up a group!\n");
    
    for (int a = 0;a < 3;a++) {
            scanf("%lf %lf %lf %lf %lf"
                   ,&numbers[a][0],&numbers[a][1],&numbers[a][2],&numbers[a][3],&numbers[a][4]);
            printf("OK,please input the next group\n");
    }

    printf("The numbers group were saved!\nI will tell you the pingjunshu.\n");

    pingjunshu(numbers,3);
    pingjunshuall(numbers,3);
    max(numbers,3);

    return 0;
}

double pingjunshu(double group[][5],int n) {
    for (int i = 0;i < n;i++) {

        double sum = 0;

        for (int j = 0;j < 5;j++) 
            sum += group[i][j];
            
        double pjs = sum / 5;
        
        printf("The pingjunshu is %lf\n",pjs);
    }
}

double pingjunshuall(double group[][5],int n) {
    double sum = 0;

    for (int i = 0;i < n;i++) {
        for (int j = 0;j < 5;j++) 
            sum += group[i][j];
    }

    double pjs = sum / 15;
    printf("The pingjunshuall is %lf\n",pjs);
}

double max(double group[][5],int n) {
    double ch = group[0][0];

    for (int i = 0;i < n;i++) {
        for (int j = 0;j < 5;j++) {
            if (group[i][j] > ch) 
                ch = group[i][j];
        }
    }
    printf("The max is %lf\n",ch);
}



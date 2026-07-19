#include <stdlib.h>
#include <stdio.h>
#include <windows.h>

#define N 50
#define M 50

typedef int Status;
#define OK 1;
#define  ERROR 0;

int a [N][M];
Status ReadFiles(int a[][M],int *n,int *m);
void Show(int a[][M],int n,int m);

int main() {
    int n,m,status;
    printf("读取数据文件");
    status = ReadFiles(a,&n,&m);

    if(status) {
        printf("加载完成!\n");
        Show(a,n,m);
    }
    else printf("无法打开文件");

    return 0;
}

Status ReadFiles(int a[][M],int *n,int *m) {
    FILE *fp;
    if((fp = fopen("Game.txt","r")) == NULL) {
        return ERROR;
    }
    fscanf(fp,"%d%d",n,m);
    for(int i = 0;i < *n;i++) {
        for(int j = 0;j < *m;j++) {
            fscanf(fp,"%d",&a[i][j]);
        }
    }
    fclose(fp);
    return OK;
}

void Show(int a[][M],int n,int m) {
    for(int i = 0;i < n;i++) {
        for(int j = 0;j < m;j++) {
            if(a[i][j] == 1) {
                printf("口");
            } else if(a[i][j] == 0) {
                printf(" ");
            } else if(a[i][j] == 2) {
                printf("人");
            }
        }
        printf("\n");
    }
}

//定义结构类型编程实现如下功能：
// 从键盘输入整数n，代表学生的数量。
// 每个学生信息包括：姓名、学号、以及每一个学生的4门功课的成绩
// 分别计算每个学生的总分和均分，并将此表按总分的高低排序。
// 要求输入n，动态分配n个连续单元。编程实现上述要求。

#include <stdio.h>
#include <stdlib.h>

#define courseNum 4

typedef int Status;
#define OK 1;
#define  ERROR 0;

typedef struct {
    char name[10];
    long id;
    float score[courseNum];
    float avgScore;
    float totalScore;
} Student;

void Sort(Student student[],int size);
void WriteFile(Student student[],int size);
Status ReadFile(Student student[]);

int main() {
    int n = 0;
    printf("输入学生数量   ");
    scanf("%d",&n);

    Student  student[n];


    printf("请输入学生的姓名、学号、四门功课成绩，按空格间隔\n");
    for(int i = 0;i < n;i++) {
        scanf("%s %ld %f %f %f %f",student[i].name,&student[i].id,&student[i].score[0],&student[i].score[1],&student[i].score[2],&student[i].score[3]);
        student[i].totalScore = 0;
        student[i].avgScore = 0;
    }
    for(int i = 0;i < n;i++) {
        for(int j = 0;j < courseNum;j++) {
            student[i].totalScore += student[i].score[j];
        }
        student[i].avgScore = student[i].totalScore / courseNum;
    }
    printf("已录入数据\n");
    for (int i = 0; i < n; i++) {
        printf("姓名: %s, 学号: %ld, 总分: %.2f, 均分: %.2f\n", student[i].name, student[i].id, student[i].totalScore, student[i].avgScore);
    }
    Sort(student,n);
    printf("已按总分排序\n");
    for (int i = 0; i < n; i++) {
        printf("姓名: %s, 学号: %ld, 总分: %.2f, 均分: %.2f\n", student[i].name, student[i].id, student[i].totalScore, student[i].avgScore);
    }
    printf("写入文件为CSV\n");
    WriteFile(student,n);


    Student  student2[n];
    Status status = ReadFile(student2);

    if(status) {
        printf("读取文件\n");
        for (int i = 0; i < n; i++) {
        printf("姓名: %s, 学号: %ld, 总分: %.2f, 均分: %.2f\n", student2[i].name, student2[i].id, student2[i].totalScore, student2[i].avgScore);
        }
    }
    return 0;
}


void Sort(Student student[],int size) {
    for(int i = 0;i < size - 1;i++) {
        for(int j = 0; j < size - i - 1;j++){
            if(student[j].totalScore < student[j+1].totalScore) {
                 Student temp;
                 temp = student[j];
                 student[j] = student[j+1];
                 student[j+1] = temp;
            }
        }
    }
}

void WriteFile(Student student[],int size) {
    FILE *fp;
    if((fp = fopen("A.csv","w")) == NULL) {
        printf("无法打开文件");
        exit(0);
    }
    fwrite(student,sizeof(Student),size,fp);
    fclose(fp);
    printf("写入完成!");
}

Status ReadFile(Student student[]) {
    FILE *fp;
    if((fp = fopen("A.csv","r")) == NULL) {
        printf("无法打开文件");
        return ERROR;
    }
    for(int i = 0;!feof(fp);i++) {
        fread(&student[i],sizeof(Student),1,fp);
    }
    fclose(fp);
    return OK;
}


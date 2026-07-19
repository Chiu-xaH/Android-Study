#include <stdio.h>
#include <unistd.h>
//通过用户定义类型，将无符号字符型定义成BYTEPORT类型。
//通过BYTEPORT类型定义一个变量，其中6bit控制一个十字路口的红绿灯，每bit控制不同路口一个颜色的灯，1亮、0灭。
//假设路口是东西-南北走向。两个方向各有红、绿、黄三各颜色的交通通行指示，黄灯总是在绿转红之间插入五秒。
//要求编程实现一个1s延时函数，输入两个路口的红灯、绿灯亮、灭时间（单位秒，作为参数调用一秒函数实现要求的时间），共四个值。
//编程实现交通灯的控制。

typedef unsigned char BYTEPORT;
#define LIGHT 1
#define DARK 0
typedef struct {
    BYTEPORT ESRed : LIGHT;
    BYTEPORT ESYellow : LIGHT;
    BYTEPORT ESGreen : LIGHT;
    BYTEPORT NSRed : LIGHT;
    BYTEPORT NSYellow : LIGHT;
    BYTEPORT NSGreen : LIGHT;
} TrafficLight;

void delay1s() {
    sleep(1);
}

void ControlTrafficLight(int ESRedTime,
                         int ESGreenTime,
                         int NSRedTime,
                         int NSGreenTime) {

    TrafficLight trafficight = { 0 };

    while(1) {
        //东西通行，南北不通
        trafficight.ESGreen = LIGHT;
        trafficight.ESRed = DARK;
        trafficight.NSGreen = DARK;
        trafficight.NSRed = LIGHT;
        trafficight.NSYellow = DARK;
        trafficight.ESYellow = DARK;
        printf("东西通行%d秒，南北不通\n",ESGreenTime);

        for(int i = 0;i < ESGreenTime;i++) delay1s();

        //黄灯
        trafficight.ESGreen = DARK;
        trafficight.ESRed = DARK;
        trafficight.NSGreen = DARK;
        trafficight.NSRed = DARK;
        trafficight.NSYellow = DARK;
        trafficight.ESYellow = LIGHT;

         printf("黄灯5s\n");

        //黄灯5s
        for(int i = 0;i < 5;i++) delay1s();

        //南北通行，东西不通
        trafficight.ESGreen = DARK;
        trafficight.ESRed = LIGHT;
        trafficight.NSGreen = LIGHT;
        trafficight.NSRed = DARK;
        trafficight.NSYellow = DARK;
        trafficight.ESYellow = DARK;

        printf("南北通行%d秒，东西不通\n",NSGreenTime);

        for(int i = 0;i < NSGreenTime;i++) delay1s();

        //黄灯
        trafficight.ESGreen = DARK;
        trafficight.ESRed = DARK;
        trafficight.NSGreen = DARK;
        trafficight.NSRed = DARK;
        trafficight.NSYellow = LIGHT;
        trafficight.ESYellow = DARK;

        printf("黄灯5s\n");

        //黄灯5s
        for(int i = 0;i < 5;i++) delay1s();
    }
}

int main() {
    int ewRedTime, ewGreenTime, nsRedTime, nsGreenTime;
     // 用户输入红绿灯时间
    printf("请输入东西向红灯时间（秒）: ");
    scanf("%d", &ewRedTime);
    printf("请输入东西向绿灯时间（秒）: ");
    scanf("%d", &ewGreenTime);
    printf("请输入南北向红灯时间（秒）: ");
    scanf("%d", &nsRedTime);
    printf("请输入南北向绿灯时间（秒）: ");
    scanf("%d", &nsGreenTime);

    ControlTrafficLight(ewRedTime, ewGreenTime, nsRedTime, nsGreenTime);

    return 0;
}
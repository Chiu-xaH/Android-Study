//使用嵌套循环，打印以下内容；
//$
//$$
//$$$
//$$$$
//$$$$$

#include <stdio.h>
int main(void) {
    for (int i = 1; i < 6; i++) {
        for (int j = 0; j < i; j++) printf("$");
        printf("\n");
    }
}
#include <stdio.h>
int main(void) {
    const int numbers[5][4] = {
        {3,6,9,1,5},
        {10,56,48,36,12},
        {55,99,21,222,333},
        {895,546,985,211,2}
    };
    printf("%d",*(*(numbers + 2)+3));
    return 0;
}
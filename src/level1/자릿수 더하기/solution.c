#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    int div = 100000000;
    while(1) {
        answer += n / div;
        n = n % div;
        div /= 10;
        if(div < 1) 
            break;
    }
    return answer;
}
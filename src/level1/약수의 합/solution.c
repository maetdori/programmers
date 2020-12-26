#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    int div = 1;
    while(n>=div){
        if(n%div == 0) {
            answer += div;
        }
        div++;
    }
    return answer;
}